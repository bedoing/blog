package org.bedoing.entity;

import lombok.Data;

import javax.persistence.*;

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

	@Column
	private String tagName;

	@Column
	private int tagType;
}
