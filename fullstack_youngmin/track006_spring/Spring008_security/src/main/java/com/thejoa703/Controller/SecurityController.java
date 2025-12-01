package com.thejoa703.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security")
public class SecurityController {
	
	@RequestMapping("/all")
	public String all() {return "member/all";}
	
	@RequestMapping("/member")
	public String member() {return "member/member";}
	
	@RequestMapping("/admin")
	public String admin() {return "member/admin";}

}
