package com.thejoa703.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BasicController {
	@RequestMapping("/basic.do")
	public String basic(Model model) {
		//1. 해결사-service
		model.addAttribute("result","Hello");
		return "basic.jsp"; //2. 해당view
	}
	
	@RequestMapping("/basic2.do")
	public String basic2(Model model) {
		//1. 해결사-service
		model.addAttribute("result","Hello");
		return "basic"; //2. 해당view  /view/ + basic(파일명) + .jsp ## 0
	}

}
