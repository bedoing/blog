package org.bedoing.blog.repository;

import org.bedoing.blog.entity.ArticleTags;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Ken on 2016/9/17.
 */
@Transactional
public interface ArticleTagRepository extends CrudRepository<ArticleTags, Integer> {

}
