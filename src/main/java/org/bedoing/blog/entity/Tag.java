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
	private int tagId;
	@NotNull
	private String tagName;
	@NotNull
	private int tagType;
}
