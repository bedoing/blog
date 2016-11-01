package org.bedoing.vo;

import lombok.Data;
import java.util.Date;

@Data
public class UserRegVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String loginAccount;

	private String password;

	private String passwordRep;

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

	private String verCode;
	private boolean checked;
}
