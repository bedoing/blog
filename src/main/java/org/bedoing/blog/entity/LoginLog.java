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
@Table
public class LoginLog {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int logId;
	private int loginAccount;
	private int log;
	private Date oprTime;
	private String ip;
	private String os;
	private String browser;
}
