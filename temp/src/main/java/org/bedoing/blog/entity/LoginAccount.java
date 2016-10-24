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

	@Column(nullable = false)
	private String accountName;

	@Column(nullable = false)
	private String password;

	@NotNull
	private Integer role;

	@Column
	private String mobilePhone;

	private Integer sex;

	private String nickname;

	private String headImgUrl;

	private String country;

	private String city;

	private String province;

	@Column(nullable = false)
	private Date createTime;

	@Column(nullable = false)
	private Integer status;
}
