package org.bedoing.blog.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 
 * @author Ken
 *
 */
@Data
@Entity
@Table(name = "loginAccount")
public class LoginAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "accountName", nullable = false)
	private String accountName;

	@Column(name = "password", nullable = false)
	private String password;

	@NotNull
	private Integer role;

	@Column(name = "mobilePhone")
	private String mobilePhone;

	private Integer sex;

	private String nickname;

	private String headimgurl;

	private String country;

	private String city;

	private String province;

	@Column(name = "createTime", nullable = false)
	private Date createTime;

	@Column(name = "status", nullable = false)
	private Integer status;
}
