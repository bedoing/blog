package org.bedoing.blog.todos;

import org.bedoing.blog.aspect.AroundLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Frank on 8/13/2016.
 */
@AroundLog(level = "debug")
@RestController
@RequestMapping("/rest/")
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

    @RequestMapping(value = "todoes", method = GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Iterable<Todo> findAll(){
        return todoRepository.findAll();
    }

    @AroundLog
    @RequestMapping(value = "todoes/{id}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Todo findOne(@PathVariable Long id){
        return todoRepository.findOne(id);
    }

    @RequestMapping(value = "todofind/{id}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public List<Todo> find(@PathVariable Boolean id){
        return todoRepository.findByComplete(id);
    }

    /**
     * a example using {@link ModelAndView }
     * @return
     */
    @RequestMapping(value = "todo.html",  method = GET, produces = MediaType.TEXT_HTML_VALUE )
    public ModelAndView todo_html(){
        return new ModelAndView("todo").addObject("todoList", todoRepository.findAll());
    }
}
