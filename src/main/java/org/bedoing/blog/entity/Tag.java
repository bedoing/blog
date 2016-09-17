package org.bedoing.blog.entity;

/**
 * 
 * @author ken
 *
 */
public class Tag extends BasePO {

	private int tagId;
	private String tagName;
	private int tagType;
	
	public int getTagId() {
		return tagId;
	}
	public void setTagId(int tagId) {
		this.tagId = tagId;
	}
	public String getTagName() {
		return tagName;
	}
	public void setTagName(String tagName) {
		this.tagName = tagName;
	}
	public int getTagType() {
		return tagType;
	}
	public void setTagType(int tagType) {
		this.tagType = tagType;
	}
}
