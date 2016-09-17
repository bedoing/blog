package org.bedoing.blog.entity;

/**
 * 
 * @author ken
 *
 */
public class Statistics {

	private int id;
     private String type;
     private int result;
     private long statisticalTime;
     
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public long getStatisticalTime() {
		return statisticalTime;
	}
	public void setStatisticalTime(long statisticalTime) {
		this.statisticalTime = statisticalTime;
	}
}
