package org.bedoing.repository;

import org.bedoing.entity.Article;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Ken on 2016/9/17.
 */
@Transactional
public interface ArticleRepository extends CrudRepository<Article, Integer> {
    Article findByTitle(String title);
}
