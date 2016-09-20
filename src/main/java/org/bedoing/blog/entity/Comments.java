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
	private int articleId;
	@NotNull
	private String content;
	@NotNull
	private int status;
	@NotNull
	private long createTime;
}
