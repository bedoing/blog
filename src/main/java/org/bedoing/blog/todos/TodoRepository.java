package org.bedoing.blog.todos;

import org.bedoing.blog.todos.Todo;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by Frank on 8/13/2016.
 */
public interface TodoRepository extends CrudRepository<Todo, Long> {

    List<Todo> findByComplete(boolean complete);

}
