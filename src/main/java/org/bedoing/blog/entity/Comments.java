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
	private int commentId;

	@Column(nullable = false)
	private int articleId;

	@Column(nullable = false)
	private String content;

	@NotNull
	private int status;

	@Column(nullable = false)
	private long createTime;
}
