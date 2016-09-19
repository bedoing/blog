package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author ken
 *
 */
@Data
public class ArticleTags extends BaseEntity {
	
	private int articleId;
	private int tagId;
	
	public ArticleTags() {}
	
	public ArticleTags(int articleId, int tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
	}
}
