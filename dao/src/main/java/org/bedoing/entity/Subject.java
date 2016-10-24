package org.bedoing.entity;

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

	@Column
	private int articleId;

	@NotNull
	private int difficulty;

	@Column
	private int timeLimit;

	@Column
	private int memoryLimit;

	@Column
	private String otherLimit;
}
