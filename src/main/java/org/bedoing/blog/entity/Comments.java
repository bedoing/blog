package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author ken
 *
 */
@Data
public class Comments extends BaseEntity {

	private int commentId;
	private int articleId;
	private String content;
	private int status;
	private long createTime;
}
