package org.bedoing.blog.vo;


public class TagsVO extends BaseVO {

	private int articleNum;
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
	public int getArticleNum() {
		return articleNum;
	}
	public void setArticleNum(int articleNum) {
		this.articleNum = articleNum;
	}
	public int getTagType() {
		return tagType;
	}
	public void setTagType(int tagType) {
		this.tagType = tagType;
	}
}
