package org.bedoing.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 
 * @author ken
 *
 */
@Data
@Entity
@Table
public class ArticleTags {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private int articleId;

	@Column(nullable = false)
	private int tagId;
	
	public ArticleTags() {}
	
	public ArticleTags(int articleId, int tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
	}
}
