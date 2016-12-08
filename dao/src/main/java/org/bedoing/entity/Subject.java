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
//@Entity
//@Table
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer subjectId;

	@Column
	private Integer articleId;

	@NotNull
	private int difficulty;

	@Column
	private int timeLimit;

	@Column
	private int memoryLimit;

	@Column
	private String otherLimit;
}
