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
@Table
public class Comments {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentId")
	private int commentId;

	@Column(name = "articleId")
	private int articleId;

	@Column(nullable = false)
	private String content;

	@NotNull
	private int status;

	@Column(name = "createTime", nullable = false)
	private long createTime;
}
