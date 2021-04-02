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
	// 패스워드 인코딩 테스트
	public void isPasswordEncoder() {
		log.info("================================");
		log.info(encoder);
		log.info(encoder.encode("1234"));
		
		log.info("================================");
	}
	
	@Test
	public void getUser() {
		UserVO user = mapper.getUser("user88");
		user.getAuthList().forEach(auth -> log.info(auth));
	}

}
