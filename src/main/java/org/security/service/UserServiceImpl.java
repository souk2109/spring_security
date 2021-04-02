package org.security.service;

import org.security.domain.AuthVO;
import org.security.domain.UserVO;
import org.security.mapper.AuthMapper;
import org.security.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper userMapper;
	
	@Autowired
	private AuthMapper authMapper;
	
	@Autowired
	private PasswordEncoder encoder;
	
	// 유저 추가 메소드
	@Override
	public int addUser(UserVO userVO) {
		userVO.setPwd(encoder.encode(userVO.getPwd())); // db에 추가하기 전 비밀번호를 암호화
		log.info("암호화된 password : " + userVO.getPwd()); // 암호화 확인
		int insertuserResut = userMapper.insert(userVO); // 실질적으로 db에 추가
		int insertAuthResut = authMapper.insert(userVO.getId());
		return insertuserResut * insertAuthResut;
	}

}
