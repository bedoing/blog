package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author ken
 *
 */
@Data
public class Subject extends BaseEntity {

	private int subjectId;
	private int articleId;
	private int difficulty;
	private int timeLimit;
	private int memoryLimit;
	private String otherLimit;
}
