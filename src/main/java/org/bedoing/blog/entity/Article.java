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
	@NotNull
	private String title;
	@NotNull
	private int articleType; // 1.article  2.subject
	@NotNull
	private String summary;
	@NotNull
	private String content;
	@NotNull
	private String createBy;
	@NotNull
	private long createTime;
	@NotNull
	private String lastUpdBy;
	@NotNull
	private long lastUpdTime;
}
