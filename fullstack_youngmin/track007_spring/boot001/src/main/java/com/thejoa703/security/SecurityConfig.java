package com.thejoa703.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.thejoa703.oauth.Oauth2IUserService;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final Oauth2IUserService oauth2IUserService;
		


	@Bean 
	public SecurityFilterChain  filterChain(HttpSecurity http) throws Exception  {
		
		http /* 1. 허용경로 */
			.authorizeHttpRequests(auth-> auth
				 //누구나다 접근가능
				.antMatchers("/users/join" , "/users/login" , "/users/iddouble","/images/**").permitAll()
				 //로그인한 유저들만 접근가능
				.antMatchers("/users/mypage" , "/users/update" , "/users/delete").authenticated()
				 //그외 요청은 모두 허용
				.anyRequest().permitAll()
			)
			 /* 2. 로그인처리 */
	     	.formLogin(form -> form
	     			.loginPage("/users/login")
	     			.loginProcessingUrl("/users/loginProc")
	     			.defaultSuccessUrl("/users/mypage", true)
	     			.failureUrl("/users/fail")
	     			.permitAll()
	     			)
		    //.formLogin()
		     /* 3. 로그아웃 */
	     	.logout(logout->logout
	     			.logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
	     			.logoutSuccessUrl("/users/login")
	     			.invalidateHttpSession(true)
	     			.permitAll()
	     			)
	     	.oauth2Login(oauth2 -> oauth2  
	     	.loginPage("/users/login")
	     	.defaultSuccessUrl("/users/mypage",true)// 로그인성공시 경로
	     	.userInfoEndpoint(userInfo -> userInfo.userService(oauth2IUserService))
	     	)
		    //.logout()
		     /* 4. csrf 예외처리 */
	     	.csrf(csrf -> csrf.ignoringAntMatchers("/users/join","/users/update","/users/delete"));
		    //.csrf();
		return http.build(); 
	}
	
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration  authConfig) throws Exception {
		return authConfig.getAuthenticationManager(); 
	}
	
}

	