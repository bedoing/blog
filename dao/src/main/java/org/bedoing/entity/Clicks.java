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
public class Clicks {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(nullable = false)
	private Integer articleId;

	@Column(nullable = false)
	private int clicks;
}
