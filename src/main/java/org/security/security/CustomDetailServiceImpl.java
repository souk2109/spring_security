package org.security.security;

import org.security.domain.UserVO;
import org.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class CustomDetailServiceImpl implements UserDetailsService {
	@Autowired
	private UserMapper mapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = mapper.getUser(username);
		return user == null ? null : new CustomUser(user);
	}

}
