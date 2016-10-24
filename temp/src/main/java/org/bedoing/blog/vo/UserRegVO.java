package org.bedoing.blog.vo;

import java.util.Date;

import javax.validation.constraints.Size;

import org.bedoing.blog.validator.PasswordConfirm;
import org.hibernate.validator.constraints.NotBlank;

@PasswordConfirm(filed = "password", verifyFiled= "passwordRep", message = "{constraint.password.not.equals}")
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
	
	public String getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(String loginAccount) {
		this.loginAccount = loginAccount;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPasswordRep() {
		return passwordRep;
	}
	public void setPasswordRep(String passwordRep) {
		this.passwordRep = passwordRep;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public int getSex() {
		return sex;
	}
	public void setSex(int sex) {
		this.sex = sex;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getHeadimgurl() {
		return headimgurl;
	}
	public void setHeadimgurl(String headimgurl) {
		this.headimgurl = headimgurl;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getVerCode() {
		return verCode;
	}
	public void setVerCode(String verCode) {
		this.verCode = verCode;
	}
	public boolean isChecked() {
		return checked;
	}
	public void setChecked(boolean checked) {
		this.checked = checked;
	}
}
