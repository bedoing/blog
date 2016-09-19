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
public class LoginAccount extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	private String accountName;
	private String password;
	private Integer role;
	private String mobilePhone;
	private Integer sex;
	private String nickname;
	private String headimgurl;
	private String country;
	private String city;
	private String province;
	private Date createTime;
	private Integer status;
}
