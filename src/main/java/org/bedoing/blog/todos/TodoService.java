package org.bedoing.blog.todos;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * Created by Frank on 8/18/2016.
 */
@Path("/todo")
@Api(value = "/todo")
@Service
public class TodoService {

    @Autowired
    TodoRepository todoRepository;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Todo find(@PathParam("id") Long id) {
        return todoRepository.findOne(id);
    }
}
