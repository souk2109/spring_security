package org.security.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class UserVO {
	private String id;
	private String pwd;
	private String userName;
	private Date regDate;
	private Date updateDate;
	private boolean enabled;
	private List<AuthVO> authList;
}
