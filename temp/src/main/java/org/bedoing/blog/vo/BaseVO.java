package org.bedoing.blog.vo;

import com.alibaba.fastjson.JSON;

public class BaseVO {

	private int pageNo = 1;
	private int beginRow = 0; 
	private int endRow = -1; 
	private int pageSize = 10;
	private String sortColumn = "NULL";
	private String sortMode = "desc";
	
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public int getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(int beginRow) {
		this.beginRow = beginRow;
	}
	public int getEndRow() {
		return endRow;
	}
	public void setEndRow(int endRow) {
		this.endRow = endRow;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public String getSortColumn() {
		return sortColumn;
	}
	public void setSortColumn(String sortColumn) {
		this.sortColumn = sortColumn;
	}
	public String getSortMode() {
		return sortMode;
	}
	public void setSortMode(String sortMode) {
		this.sortMode = sortMode;
	}
	
	@Override
	public String toString() {
		return JSON.toJSONString(this);
	}
}
