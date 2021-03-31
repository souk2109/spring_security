package org.security.mapper;

import java.util.List;

import org.security.domain.AuthVO;
import org.security.domain.UserVO;

public interface UserMapper {
	public List<UserVO> getAllUser();
	public int insertUser(UserVO vo);
	public int insertAuth(AuthVO vo);
}
