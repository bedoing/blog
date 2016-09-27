package org.bedoing.blog.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * 
 * @author Ken
 *
 */
@Data
@Entity
@Table
public class Dict {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "dictId")
	private int dictId;

	@Column(name = "dictType")
	private String dictType;

	@Column(name = "dictCode")
	private String dictCode;

	@Column(name = "dictKey")
	private int dictKey;

	@Column(name = "dictValue")
	private String dictValue;
}
