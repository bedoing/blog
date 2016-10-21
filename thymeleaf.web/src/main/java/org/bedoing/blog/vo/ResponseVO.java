package org.bedoing.blog.vo;

import java.io.Serializable;

import com.alibaba.fastjson.JSON;

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

	public Meta getMeta() {
		return meta;
	}
	
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

		public boolean isSuccess() {
			return success;
		}

		public String getMessage() {
			return message;
		}
	}

	public String getErrNum() {
		return errNum;
	}

	public void setErrNum(String errNum) {
		this.errNum = errNum;
	}

	public Object getRetData() {
		return retData;
	}

	public void setRetData(Object retData) {
		this.retData = retData;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public String getRetMsg() {
		return retMsg;
	}

	public void setRetMsg(String retMsg) {
		this.retMsg = retMsg;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}