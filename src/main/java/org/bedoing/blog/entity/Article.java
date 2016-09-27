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
	@Column(name = "articleId")
	private int articleId;

	@Column(nullable = false, length = 128)
	private String title;

	@Column(name = "articleType", nullable = false, length = 11)
	private int articleType; // 1.article  2.subject

	@Column(nullable = true, length = 1024)
	private String summary;

	@NotNull
	private String content;

	@Column(name = "createBy", nullable = false, length = 32)
	private String createBy;

	@Column(name = "createTime", nullable = false)
	private long createTime;

	@Column(name = "lastUpdBy", nullable = false, length = 32)
	private String lastUpdBy;

	@Column(name = "lastUpdTime", nullable = false)
	private long lastUpdTime;
}
