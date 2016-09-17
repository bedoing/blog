package org.bedoing.blog.todos;

import lombok.Data;
import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Frank on 8/13/2016.
 */
@Entity
@Data
public class Todo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String description;

	private boolean complete;

}
