package org.bedoing.blog.entity;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * 
 * @author Ken
 *
 */
@Entity
@Data
@Table(name = "login_account")
public class LoginAccount {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String accountName;
	private String password;
	private int role;
	private String mobilePhone;
	private int sex;
	private String nickname;
	private String headimgurl;
	private String country;
	private String city;
	private String province;
	private Date createTime;
	private int status;

	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
