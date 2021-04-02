package org.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/security/*")
public class SecurityController {
	@GetMapping("/all")
	public void allPage() {
	
	}
	@GetMapping("/member")
	public void memberPage(Authentication auth) {
		System.out.println("허용, 권한 : "+auth.getAuthorities()); 
	}
	@GetMapping("/admin")
	public void adminPage(Authentication auth) {
		System.out.println("허용, 권한 : "+auth.getAuthorities()); 
	}
	
	@GetMapping("/error")
	public void errorPage(Authentication auth) {
		System.out.println("에러, 권한 : "+auth.getAuthorities()); 
	}
	
}
