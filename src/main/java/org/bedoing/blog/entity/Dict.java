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
	private int dictId;

	@Column
	private String dictType;

	@Column
	private String dictCode;

	@Column
	private int dictKey;

	@Column
	private String dictValue;
}
