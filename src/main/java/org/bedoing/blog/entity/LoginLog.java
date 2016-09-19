package org.bedoing.blog.entity;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @author Ken
 *
 */
@Data
public class LoginLog extends BaseEntity {

	private int logId;
	private int loginAccount;
	private int log;
	private Date oprTime;
	private String ip;
	private String os;
	private String browser;
}
