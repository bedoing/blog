package org.bedoing.vo;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
public class UserRegVO implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotBlank(message = "账号 {constraint.username.not.empty}")
	@Size(min=4, max=20, message="账号应为{min} - {max}位")
	private String loginAccount;
	@NotBlank(message = "密码 {constraint.username.not.empty}")
	@Size(min=6, max=18, message="密码长度应为{min} - {max}位")
	private String password;
	@NotBlank(message = "密码 {constraint.username.not.empty}")
	private String passwordRep;
	private int role;
	@Size(min=11, max=11, message="手机号码长度应为{max}位")
	private String mobilePhone;
	private int sex;
	private String nickname;
	private String headimgurl;
	private String country;
	private String city;
	private String province;
	private Date createTime;
	private int status;
	
	@NotBlank(message = "验证码 {constraint.username.not.empty}")
	private String verCode;
	private boolean checked;
}
