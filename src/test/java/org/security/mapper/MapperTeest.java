package org.security.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.security.domain.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@Log4j
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class MapperTeest {

	@Autowired
	private UserMapper mapper;

	@Test
	public void isMapper() {
		log.info("----mapper : " + mapper);
	}

	@Test
	public void getAllUser() {

		List<UserVO> list = mapper.getAllUser();
		if(list.size() == 0) {
			log.info("없습니다.");
		}else {
			mapper.getAllUser().forEach(user -> {log.info(user);});
		}
		 
	}
}
