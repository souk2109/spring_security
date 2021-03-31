package org.security.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user/*")
public class UserController {

	@GetMapping("/login")
	public void loginPage(String error, String logout, Model model, HttpServletRequest request) {
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
}
