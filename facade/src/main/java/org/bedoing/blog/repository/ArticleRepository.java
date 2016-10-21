package org.bedoing.blog.repository;

import org.bedoing.blog.entity.Article;
import org.bedoing.blog.entity.LoginAccount;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Ken on 2016/9/17.
 */
@Transactional
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Article findByTitle(String title);
}
