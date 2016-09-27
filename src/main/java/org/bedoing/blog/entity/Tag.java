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
public class Tag {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "tagId")
	private int tagId;

	@Column(name = "tagName")
	private String tagName;

	@Column(name = "tagType")
	private int tagType;
}
