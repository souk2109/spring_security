package org.security.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.security.domain.UserVO;
import org.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomUser extends User {
	private static final long serialVersionUID = 1L;
	
	private UserVO user;
	
	public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, authorities);
		// TODO Auto-generated constructor stub
	}
	
	public CustomUser(UserVO user) {
		super(user.getId(),user.getPwd() , user.getAuthList().stream().map(auth -> new SimpleGrantedAuthority(auth.getAuth())).collect(Collectors.toList()));
	}

}
