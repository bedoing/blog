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
	private String dictType;
	private String dictCode;
	private int dictKey;
	private String dictValue;
}
