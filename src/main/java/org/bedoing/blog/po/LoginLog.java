package org.bedoing.blog.po;

import java.util.Date;

/**
 * 
 * @author Ken
 *
 */
public class LoginLog {

	private int logId;
	private int loginAccount;
	private int log;
	private Date oprTime;
	private String ip;
	private String os;
	private String browser;
	
	public int getLogId() {
		return logId;
	}
	public void setLogId(int logId) {
		this.logId = logId;
	}
	public int getLoginAccount() {
		return loginAccount;
	}
	public void setLoginAccount(int loginAccount) {
		this.loginAccount = loginAccount;
	}
	public int getLog() {
		return log;
	}
	public void setLog(int log) {
		this.log = log;
	}
	public Date getOprTime() {
		return oprTime;
	}
	public void setOprTime(Date oprTime) {
		this.oprTime = oprTime;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getOs() {
		return os;
	}
	public void setOs(String os) {
		this.os = os;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(String browser) {
		this.browser = browser;
	}
}
