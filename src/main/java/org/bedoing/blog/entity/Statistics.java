package org.bedoing.blog.entity;

import lombok.Data;

/**
 * 
 * @author ken
 *
 */
@Data
public class Statistics extends BaseEntity {

	private int id;
     private String type;
     private int result;
     private long statisticalTime;
}
