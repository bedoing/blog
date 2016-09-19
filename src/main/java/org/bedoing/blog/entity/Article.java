package org.bedoing.blog.entity;

import lombok.Data;

@Data
public class Article extends BaseEntity{

	private int articleId;
	private String title;
	private int articleType; // 1.article  2.subject
	private String summary;
	private String content;
	private String createBy;
	private long createTime;
	private String lastUpdBy;
	private long lastUpdTime;
}
