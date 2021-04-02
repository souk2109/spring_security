package org.security.mapper;

import java.util.List;

import org.security.domain.AuthVO;
import org.security.domain.UserVO;

public interface UserMapper {
	public UserVO getUser(String id);
	public int insert(UserVO UserVO);
}
