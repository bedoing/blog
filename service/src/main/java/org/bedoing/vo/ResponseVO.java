package org.bedoing.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.io.Serializable;

@Data
public class ResponseVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String SUCCESS = "success";
	private static final String ERROR = "error";

	private Meta meta;
	private String errNum = "-1";
	private String retMsg = "";
	private Object retData;
	
	public ResponseVO success() {
		this.meta = new Meta(true, SUCCESS);
		return this;
	}

	public ResponseVO success(Object retData) {
		this.meta = new Meta(true, SUCCESS);
		this.retData = retData;
		return this;
	}

	public ResponseVO failure() {
		this.meta = new Meta(false, ERROR);
		return this;
	}

	public ResponseVO failure(String message) {
		this.meta = new Meta(false, message);
		return this;
	}

	@Data
	public class Meta {

		private boolean success;
		private String message;

		public Meta(boolean success) {
			this.success = success;
		}

		public Meta(boolean success, String message) {
			this.success = success;
			this.message = message;
		}
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}