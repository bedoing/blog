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
	@Column(name = "subjectId")
	private int subjectId;

	@Column(name = "articleId")
	private int articleId;

	@NotNull
	private int difficulty;

	@Column(name = "timeLimit")
	private int timeLimit;

	@Column(name = "memoryLimit")
	private int memoryLimit;

	@Column(name = "otherLimit")
	private String otherLimit;
}
