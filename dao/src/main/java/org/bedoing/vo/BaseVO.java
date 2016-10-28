package org.bedoing.vo;

import com.alibaba.fastjson.JSON;
import lombok.Data;

@Data
public class BaseVO {

	private int pageNo = 1;
	private int beginRow = 0; 
	private int endRow = -1; 
	private int pageSize = 10;
	private String sortColumn = "NULL";
	private String sortMode = "desc";
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
