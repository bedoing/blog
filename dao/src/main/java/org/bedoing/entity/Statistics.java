package org.bedoing.entity;

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
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

    @NotNull
    private String type;

    @NotNull
    private int result;

    @Column
    private long statisticalTime;
}
