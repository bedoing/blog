package org.bedoing.blog.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author ken
 *
 */
@Data
/*@Entity
@Table*/
public class ArticleTags {
	@NotNull
	private int articleId;
	@NotNull
	private int tagId;
	
	public ArticleTags() {}
	
	public ArticleTags(int articleId, int tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
	}
}
