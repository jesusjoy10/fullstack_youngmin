package com.thejoa703.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thejoa703.dto.AppUserDto;
import com.thejoa703.service.AppUserService;

@Controller
@RequestMapping("/security/*")
public class SecurityController {


	@Autowired AppUserService service;   //##
	
	////////////////////////
    //	@RequestMapping("/mypage") public String mypage() { return "member/mypage2"; }	
	
	@RequestMapping("/mypage") public String mypage(Principal  principal, Model model) {
		System.out.println(".......@@@@@@@@@@@@@@" + principal);
		System.out.println(".......@@@@@@@@@@@@@@" + principal.getName()); //username-email
		String email = principal.getName();  //##
		model.addAttribute("dto", service.selectEmail(email)); 
		return "member/mypage2";
	}
	///////////////////////// 
	@RequestMapping("/all")
	public String all() { return "member/all"; }
	
	@RequestMapping("/member")
	public String member() { return "member/member"; }
	
	@RequestMapping("/admin")
	public String admin() { return "member/admin"; }
	//////////////////////// 
	@RequestMapping("/login")
	public String login() { return "member/login"; }	
	
	@RequestMapping("/fail")
	public String fail( HttpServletResponse  response ,  RedirectAttributes rttr) { 
	    String result = "로그인 실패";
	    rttr.addFlashAttribute("loginError", result);
	    return "redirect:/security/login";
	}	  //알림창
	
	//@RequestMapping("/security/*")
	///////////////// 
	// 회원가입폼
	@RequestMapping("/join")
	public String join_get() { return "member/join"; }	

	// 회원기능
	//@PreAuthorize("hasAnyRole('ROLE_ADMIN' , 'ROLE_MEMBER')")  //1. 안에 있는 권한중
	//@PreAuthorize("isAuthenticated()  and  hasRole('ROLE_ADMIN')") //2. 로그인 + ADMIN 권한이 있다면
	//@PreAuthorize("isAnonymous()")     //3. 아무나다 글쓰기 가능 (로그인하지 않은 사용자 , 회원가입)
	//@PreAuthorize("isAuthenticated()") //4. 로그인했다면	
	@PreAuthorize("isAnonymous()")  
	@RequestMapping(value="/join" 
			,  method=RequestMethod.POST 
			,  headers=("content-type=multipart/*")  )
	public String join(
			@RequestParam("file") MultipartFile file    ,  AppUserDto dto ,  RedirectAttributes rttr ) { 
		String result ="회원가입 실패";
		if( service.insert3(file,dto)  > 0  ) {  result ="회원가입 성공"; }
		rttr.addFlashAttribute("success", result);
		//return "redirect:security/login"; 
		return "redirect:/security/login"; 
	}

	/*	Security	*/
	/*	Security	*/


	
	@PreAuthorize("isAuthenticated()") 
	@RequestMapping(value="/delete" , method=RequestMethod.POST) //삭제기능
	public String delete_post(AppUserDto dto , RedirectAttributes rttr 
			,HttpServletRequest  request ,HttpServletResponse  response) { 
		String result = "비밀번호를 확인해주세요";
		if( service.delete3(dto)  > 0  ) {  // 삭제 성공 → 로그아웃 처리 
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	        if (auth != null) { new SecurityContextLogoutHandler().logout(request, response, auth); }
	        result = "회원탈퇴가 완료되었습니다.";
			rttr.addFlashAttribute("success" , result); 
			return "redirect:/security/login"; 
	        
		} else {
			result = "비밀번호를 확인해주세요.";
			rttr.addFlashAttribute("deleteError", result);
			return "redirect:/security/mypage";
		}
	}  

	@PreAuthorize("isAuthenticated()") 
	@RequestMapping(value="/update" , method=RequestMethod.POST  ,  headers=("content-type=multipart/*")) //수정기능
	public String uploadEdit_post(  @RequestParam("file") MultipartFile file   
			,  AppUserDto dto ,  RedirectAttributes rttr, Principal principal){ 
		String result = "비밀번호를 확인해주세요";
		if( service.update3(file,dto)  > 0  ) {  result ="수정 성공"; }
		rttr.addFlashAttribute("success" , result);
		return "redirect:/security/mypage"; 
	}
	
}





