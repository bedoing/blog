package org.bedoing.blog.controller;

import org.bedoing.blog.entity.Article;
import org.bedoing.blog.entity.LoginAccount;
import org.bedoing.blog.repository.UserRepository;
import org.bedoing.blog.service.impl.TestArticleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Frank on 8/13/2016.
 */
@RestController
@RequestMapping("/test/")
public class TestController {

    @Autowired
    UserRepository userRepository;
    @Autowired
    TestArticleServiceImpl articleService;

    @RequestMapping(value = "user/{accountName}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public LoginAccount findByAccountName(@PathVariable String accountName){
        LoginAccount user = userRepository.findByAccountName(accountName);
        return user;
    }

    @RequestMapping(value = "test.html",  method = GET, produces = MediaType.TEXT_HTML_VALUE )
    public ModelAndView todo_html(){
        return new ModelAndView("test").addObject("userList", userRepository.findAll());
    }

    @RequestMapping(value = "article/{articleId}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE )
    public Article getArticle(@PathVariable int articleId){
        Article article = articleService.findArticleById(articleId);
        return article;
    }
}
