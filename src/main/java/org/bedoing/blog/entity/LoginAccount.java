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
@Table
public class LoginAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@NotNull
	private String accountName;
	@NotNull
	private String password;
	@NotNull
	private Integer role;
	private String mobilePhone;
	private Integer sex;
	private String nickname;
	private String headimgurl;
	private String country;
	private String city;
	private String province;
	@NotNull
	private Date createTime;
	@NotNull
	private Integer status;
}
