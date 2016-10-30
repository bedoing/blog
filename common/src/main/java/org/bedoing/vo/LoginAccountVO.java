package org.bedoing.vo;

import lombok.Data;
import org.bedoing.entity.LoginAccount;

/**
 * 
 * @author Ken
 *
 */
@Data
public class LoginAccountVO extends LoginAccount {

	private String roleStr;
	private String sexStr;
//	private String country;
//	private String city;
//	private String province;
	private String createTimeStr;
	private String statusStr;
}
