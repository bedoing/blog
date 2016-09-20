package org.bedoing.blog.entity;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 * 
 * @author ken
 *
 */
@Data
/*@Entity
@Table*/
public class Clicks {
	@NotNull
	private int articleId;
	@NotNull
	private int clicks;
}
