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
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int subjectId;
	@NotNull
	private int articleId;
	@NotNull
	private int difficulty;
	@NotNull
	private int timeLimit;
	@NotNull
	private int memoryLimit;
	private String otherLimit;
}
