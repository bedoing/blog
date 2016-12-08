package org.bedoing.entity;

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
	private Integer logId;

	@Column
	private int loginAccount;
	private int log;
	@Column
	private Date oprTime;
	private String ip;
	private String os;
	private String browser;
}
