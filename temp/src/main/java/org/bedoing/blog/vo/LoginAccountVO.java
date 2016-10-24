package org.bedoing.blog.vo;

import org.bedoing.blog.entity.LoginAccount;

/**
 * 
 * @author Ken
 *
 */
public class LoginAccountVO extends LoginAccount {

	private String roleStr;
	private String sexStr;
//	private String country;
//	private String city;
//	private String province;
	private String createTimeStr;
	private String statusStr;
	
	public String getRoleStr() {
		return roleStr;
	}
	public void setRoleStr(String roleStr) {
		this.roleStr = roleStr;
	}
	public String getSexStr() {
		return sexStr;
	}
	public void setSexStr(String sexStr) {
		this.sexStr = sexStr;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public String getStatusStr() {
		return statusStr;
	}
	public void setStatusStr(String statusStr) {
		this.statusStr = statusStr;
	}
}
