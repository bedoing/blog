package org.bedoing.commons;

import java.util.HashMap;

public class MapFactory extends HashMap<String, Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private MapFactory(){}
	
	private static final String TOTAL = "total";
	private static final String PAGE_NO = "pageNo";
	private static final String PAGE_SIZE = "pageSize";
	private static final String RESULT = "result";
	
	public MapFactory setTotal(int total) {
		this.put(TOTAL, total);
		return this;
	}
	public MapFactory setPageNo(int pageNo) {
		this.put(PAGE_NO, pageNo);
		return this;
	}
	public MapFactory setPageSize(int pageSize) {
		this.put(PAGE_SIZE, pageSize);
		return this;
	}
	public MapFactory setResult(Object result) {
		this.put(RESULT, result);
		return this;
	}
	public MapFactory setParam(String key, Object value) {
		this.put(key, value);
		return this;
	}
	
	public static MapFactory buildResMap() {
		return new MapFactory();
	}
}
