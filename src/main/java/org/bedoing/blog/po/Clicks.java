package org.bedoing.blog.po;

/**
 * 
 * @author ken
 *
 */
public class Clicks extends BasePO {
	
	private int articleId;
	private int clicks;
	
	public int getArticleId() {
		return articleId;
	}
	public void setArticleId(int articleId) {
		this.articleId = articleId;
	}
	public int getClicks() {
		return clicks;
	}
	public void setClicks(int clicks) {
		this.clicks = clicks;
	}
}
