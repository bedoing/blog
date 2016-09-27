package org.bedoing.blog.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author ken
 *
 */
@Data
@Entity
@Table(name = "articleTags")
public class ArticleTags {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "articleId", nullable = false)
	private int articleId;

	@Column(name = "tagId", nullable = false)
	private int tagId;
	
	public ArticleTags() {}
	
	public ArticleTags(int articleId, int tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
	}
}
