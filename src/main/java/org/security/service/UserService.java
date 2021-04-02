package org.security.service;

import org.security.domain.UserVO;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserService {
	// tbl_user와 tbl_user_auth 두개의 테이블에 추가해야되므로 트랜잭션 처리 추가
	@Transactional
	public int addUser(UserVO userVO);
}
