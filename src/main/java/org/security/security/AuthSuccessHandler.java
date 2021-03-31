package org.security.security;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		
		List<String> authList = new ArrayList<String>();
		authentication.getAuthorities().forEach(auth -> {
			authList.add(auth.getAuthority());
			System.out.println("권한 : " + auth);
		});
		
		if (authList.contains("ROLE_ADMIN")) {
			System.out.println("관리자이므로 member로 이동");
			response.sendRedirect("/controller/security/member");
			return;
		}
		if (authList.contains("ROLE_MEMBER")) {
			System.out.println("멤버이므로 all로 이동");
			response.sendRedirect("/controller/security/all");
			return;
		}
		System.out.println("관한이 없으므로  all로 이동");
		response.sendRedirect("/controller/");
	}

}
