package com.thejoa703.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.thejoa703.service.AppUserService;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@Autowired AppUserService service;
	
	///////////////////////////
	//@RequestMapping("/mypage") public String mypage() {return "member/mypage2";}
	
	@RequestMapping("/mypage") public String mypage(Principal  principal, Model model) {
		System.out.println(".......@@@@@@@@@@@@@@" + principal);
		System.out.println(".......@@@@@@@@@@@@@@" + principal.getName()); //username-email
		String email = principal.getName();  //##
		model.addAttribute("dto", service.selectEmail(email)); 
		return "member/mypage2";
	}
	///////////////////////////
	
	@RequestMapping("/all")
	public String all() {return "member/all";}
	
	@RequestMapping("/member")
	public String member() {return "member/member";}
	
	@RequestMapping("/admin")
	public String admin() {return "member/admin";}
	
	@RequestMapping(value="/login" , method=RequestMethod.GET)
	public String login() {return "member/login";}
	
	@RequestMapping("/fail")
	public String fail() {return "member/fail";}

 
	
}
