package org.bedoing.vo;

import lombok.Data;

import java.util.Date;

/**
 * 
 * @author Ken
 *
 */
@Data
public class LoginAccountVO {

	private String roleStr;
	private String sexStr;
//	private String country;
//	private String city;
//	private String province;
	private String createTimeStr;
	private String statusStr;

	// *****************
	private Integer id;

	private String accountName;

	private String password;

	private Integer role;

	private String mobilePhone;

	private Integer sex;

	private String nickname;

	private String headImgUrl;

	private String country;

	private String city;

	private String province;

	private Date createTime;

	private Integer status;
}
