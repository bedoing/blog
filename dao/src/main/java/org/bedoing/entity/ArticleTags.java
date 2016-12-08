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
	private Integer id;

	@Column(nullable = false)
	private Integer articleId;

	@Column(nullable = false)
	private Integer tagId;
	
	public ArticleTags() {}
	
	public ArticleTags(int articleId, int tagId) {
		this.articleId = articleId;
		this.tagId = tagId;
	}
}
