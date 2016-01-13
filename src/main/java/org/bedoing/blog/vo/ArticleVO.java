package org.bedoing.blog.vo;

import java.util.ArrayList;
import java.util.List;

import org.bedoing.blog.po.Subject;
import org.bedoing.blog.po.Tag;


public class ArticleVO extends BaseVO{

	private int articleId;
	private String title;
	private int articleType; // 1.article  2.subject
	private String summary;
	private String content;
	private String createBy;
	private long createTime;
	private String lastUpdBy;
	private long lastUpdTime;
	
	private String createTimeStr;
	private String lastUpdTimeStr;
	
	private String tags;
	private int clicks;
	
	private List<Tag> tagList = new ArrayList<Tag>();
	Subject subject = new Subject();
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getSummary() {
		return summary;
	}
	public void setSummary(String summary) {
		this.summary = summary;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCreateBy() {
		return createBy;
	}
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	public long getCreateTime() {
		return createTime;
	}
	public void setCreateTime(long createTime) {
		this.createTime = createTime;
	}
	public String getLastUpdBy() {
		return lastUpdBy;
	}
	public void setLastUpdBy(String lastUpdBy) {
		this.lastUpdBy = lastUpdBy;
	}
	public long getLastUpdTime() {
		return lastUpdTime;
	}
	public void setLastUpdTime(long lastUpdTime) {
		this.lastUpdTime = lastUpdTime;
	}
	public String getCreateTimeStr() {
		return createTimeStr;
	}
	public void setCreateTimeStr(String createTimeStr) {
		this.createTimeStr = createTimeStr;
	}
	public String getLastUpdTimeStr() {
		return lastUpdTimeStr;
	}
	public void setLastUpdTimeStr(String lastUpdTimeStr) {
		this.lastUpdTimeStr = lastUpdTimeStr;
	}
	public String getTags() {
		return tags;
	}
	public void setTags(String tags) {
		this.tags = tags;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
	public List<Tag> getTagList() {
		return tagList;
	}
	public void setTagList(List<Tag> tagList) {
		this.tagList = tagList;
	}
	public int getArticleType() {
		return articleType;
	}
	public void setArticleType(int articleType) {
		this.articleType = articleType;
	}
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
