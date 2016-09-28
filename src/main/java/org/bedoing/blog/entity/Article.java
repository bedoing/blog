package org.bedoing.blog.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Data
@Entity
@Table
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int articleId;

	private String title;

	@Column(nullable = false, length = 11)
	private int articleType; // 1.article  2.subject

	@Column(nullable = true, length = 1024)
	private String summary;

	@NotNull
	private String content;

	@Column(nullable = false, length = 32)
	private String createBy;

	@Column(nullable = false)
	private long createTime;

	@Column(nullable = false, length = 32)
	private String lastUpdBy;

	@Column(nullable = false)
	private long lastUpdTime;
}
