package org.security.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.security.domain.AuthVO;
import org.security.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration({"file:src/main/webapp/WEB-INF/spring/root-context.xml",
	"file:src/main/webapp/WEB-INF/spring/security-context.xml"})
public class MapperTeest {

	@Autowired
	private UserMapper mapper;

	@Autowired
	private PasswordEncoder encoder;

	@Test
	public void isMapper() {
		log.info("----mapper : " + mapper);
	}

	@Test
	public void getAllUser() {

		List<UserVO> list = mapper.getAllUser();
		if (list.size() == 0) {
			log.info("없습니다.");
		} else {
			mapper.getAllUser().forEach(user -> {
				log.info(user);
			});
		}

	}
	
	@Test
	public void isPasswordEncoder() {
		log.info("================================");
		log.info(encoder);
		log.info(encoder.encode("1234"));
		
		log.info("================================");
	}
	
 
	
	@Test
	public void insertUserTest() {
		UserVO userVO = new UserVO();

		for (int i = 0; i < 100; i++) {
			// 비밀번호 1234로 통일 후 인코딩한 값을 저장
			userVO.setPwd(encoder.encode("1234"));
			if (i < 31) {
				userVO.setId("user" + i);
				userVO.setUserName("일반회원" + i);
			} else if (i < 61) {
				userVO.setId("user" + i);
				userVO.setUserName("운영자" + i);
			} else {
				userVO.setId("user" + i);
				userVO.setUserName("관리자");
			}

			mapper.insertUser(userVO);
		}

	}
	@Test
	public void AuthTest() {
		 AuthVO authVO = new AuthVO();
		 authVO.setId("jin002");
		 authVO.setAuth("호스트");
		 mapper.insertAuth(authVO);

	}
	@Test
	public void insertAuthTest() {
		AuthVO authVO = new AuthVO();

		for (int i = 0; i < 100; i++) {
			if (i < 31) {
				authVO.setId("user" + i);
				authVO.setAuth("ROLE_USER");
				 
			} else if (i < 61) {
				authVO.setId("user" + i);
				authVO.setAuth("ROLE_MEMBER");
			} else {
				authVO.setId("user" + i);
				authVO.setAuth("ROLE_ADMIN");
			}

			mapper.insertAuth(authVO);
		}

	}
}
