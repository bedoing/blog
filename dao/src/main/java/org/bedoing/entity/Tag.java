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
	private Integer tagId;

	@Column
	private String tagName;

	@Column
	private int tagType;

	public Tag(){}

	public Tag(Integer tagId, String tagName) {
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public Tag(String tagName, int tagType) {
		this.tagName = tagName;
		this.tagType = tagType;
	}
}
