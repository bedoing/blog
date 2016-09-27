package org.bedoing.blog.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 * @author Ken
 *
 */
@Data
@Entity
@Table(name = "loginLog")
public class LoginLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "logId")
	private int logId;

	@Column(name = "loginAccount")
	private int loginAccount;
	private int log;
	@Column(name = "oprTime")
	private Date oprTime;
	private String ip;
	private String os;
	private String browser;
}
