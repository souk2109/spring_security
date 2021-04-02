package org.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.security.domain.UserVO;
import org.security.mapper.UserMapper;
import org.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/user/*")
@Log4j
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public void loginPage(String error, String logout, Model model) {
		String str = "";
		if (error != null) {
			str = "로그인 실패";
			System.out.println("에러 발생");
		}
		if (logout != null) {
			str = "로그아웃!";
			System.out.println("로그아웃 성공");
		}

		model.addAttribute("msg", str);
	}
	
	@GetMapping("/register")  
	public void loginPage() {
		
	}
	
	@PostMapping(value = "doRegister")
	public String doRegister(UserVO user) {
		int result = userService.addUser(user);
		log.info("회원가입 성공!? : " + result);
		return "redirect:/user/login";
	}
	
}
