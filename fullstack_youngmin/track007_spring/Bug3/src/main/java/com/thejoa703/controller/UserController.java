package com.thejoa703.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.security.CustomUserDetails;
import com.thejoa703.service.AppUserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private AppUserService userService;

	/* ================= 회원가입 ================= */

	@PreAuthorize("permitAll()")
	@RequestMapping("/iddouble")
	@ResponseBody
	public Map<String, Object> iddouble(
			@RequestParam String email,
			@RequestParam String provider) {

		Map<String, Object> result = new HashMap<>();
		result.put("cnt", userService.iddouble(email, provider));
		return result;
	}

	@GetMapping("/join")
	public String joinForm() {
		return "users/join";
	}

	@PostMapping("/join")
	public String join(
			@RequestParam(value = "file", required = false) MultipartFile file,
			AppUserDto dto,
			RedirectAttributes rttr) {

		try {
			int result = userService.insert(file, dto);
			rttr.addFlashAttribute(
					"successMessage",
					result > 0 ? "회원가입 성공!" : "회원가입 실패"
			);
			return "redirect:/users/login";
		} catch (Exception e) {
			rttr.addFlashAttribute(
					"errorMessage",
					"회원가입 실패: " + e.getMessage()
			);
			return "redirect:/users/join";
		}
	}

	/* ================= 로그인 ================= */

	@GetMapping("/login")
	public String loginForm() {
		return "users/login";
	}

	@GetMapping("/fail")
	public String loginFail(Model model) {
		model.addAttribute(
				"errorMessage",
				"로그인 실패: 아이디 또는 비밀번호를 확인하세요."
		);
		return "users/login";
	}

	/* ================= 마이페이지 ================= */

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/mypage")
	public String mypage(Authentication authentication, Model model) {

		AppUserDto dto = resolveLoginUser(authentication);
		if (dto != null) {
			dto = userService.selectEmail(dto.getEmail(), dto.getProvider());
		}

		model.addAttribute("dto", dto);
		return "users/mypage";
	}

	/* ================= 회원정보 수정 ================= */

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/update")
	public String updateForm(Authentication authentication, Model model) {

	    // ✅ 로그인 정보 기준
	    AppUserDto loginUser = resolveLoginUser(authentication);

	    if (loginUser == null) {
	        return "redirect:/login";
	    }

	    // ✅ email + provider 정확히 조회
	    AppUserDto dto =
	            userService.selectEmail(loginUser.getEmail(), loginUser.getProvider());

	    model.addAttribute("dto", dto);
	    return "users/update";
	}
	@PreAuthorize("isAuthenticated()")
	@PostMapping("/update")
	public String update(
	        @RequestParam(value = "file", required = false) MultipartFile file,
	        AppUserDto dto,
	        Authentication authentication,
	        RedirectAttributes rttr) {

	    // 🔥🔥🔥 핵심: 폼 값 무시하고 로그인 정보로 덮어쓰기
	    AppUserDto loginUser = resolveLoginUser(authentication);

	    dto.setEmail(loginUser.getEmail());
	    dto.setProvider(loginUser.getProvider());

	    int result = userService.update(file, dto);

	    rttr.addFlashAttribute(
	            "successMessage",
	            result > 0 ? "회원정보 수정 성공" : "회원정보 수정 실패"
	    );

	    return "redirect:/users/mypage";
	}

	/* ================= 회원탈퇴 ================= */

	@PreAuthorize("isAuthenticated()")
	@GetMapping("/delete")
	public String deleteForm(Authentication authentication, Model model) {

		AppUserDto dto = resolveLoginUser(authentication);
		if (dto != null) {
			dto = userService.selectEmail(dto.getEmail(), dto.getProvider());
		}

		model.addAttribute("dto", dto);
		return "users/delete";
	}

	@PreAuthorize("isAuthenticated()")
	@PostMapping("/delete")
	public String delete(
			AppUserDto dto,
			RedirectAttributes rttr,
			Authentication authentication,
			HttpServletRequest request,
			HttpServletResponse response) {

		AppUserDto loginUser = resolveLoginUser(authentication);
		if (loginUser == null) {
			return "redirect:/users/login";
		}

		dto.setEmail(loginUser.getEmail());
		dto.setProvider(loginUser.getProvider());

		boolean requirePasswordCheck =
				"local".equalsIgnoreCase(loginUser.getProvider());

		if (requirePasswordCheck) {
			if (dto.getPassword() == null || dto.getPassword().isEmpty()) {
				rttr.addFlashAttribute(
						"errorMessage",
						"회원탈퇴 실패: 비밀번호를 입력해주세요"
				);
				return "redirect:/users/delete";
			}

			if (!userService.matchesPassword(
					dto.getEmail(),
					dto.getProvider(),
					dto.getPassword())) {

				rttr.addFlashAttribute(
						"errorMessage",
						"회원탈퇴 실패: 비밀번호가 일치하지 않습니다."
				);
				return "redirect:/users/delete";
			}
		}

		if (userService.delete(dto, requirePasswordCheck) > 0) {
			Authentication auth =
					SecurityContextHolder.getContext().getAuthentication();
			if (auth != null) {
				new SecurityContextLogoutHandler()
						.logout(request, response, auth);
			}
			rttr.addFlashAttribute(
					"successMessage",
					"회원탈퇴가 완료되었습니다."
			);
		}

		return "redirect:/users/login";
	}

	/* ================= 공통 로그인 사용자 추출 ================= */

	private AppUserDto resolveLoginUser(Authentication authentication) {

		Object principal = authentication.getPrincipal();

		// local
		if (principal instanceof CustomUserDetails) {
			CustomUserDetails userDetails =
					(CustomUserDetails) principal;
			return userDetails.getUser();
		}

		// social
		if (principal instanceof OAuth2User
				&& authentication instanceof OAuth2AuthenticationToken) {

			OAuth2User oAuth2User = (OAuth2User) principal;
			String email = (String) oAuth2User
					.getAttributes()
					.get("email");

			String provider =
					((OAuth2AuthenticationToken) authentication)
							.getAuthorizedClientRegistrationId();

			AppUserDto dto = new AppUserDto();
			dto.setEmail(email);
			dto.setProvider(provider);
			return dto;
		}

		return null;
	}
}
