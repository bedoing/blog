package org.bedoing.blog.repository;

import org.bedoing.blog.entity.Clicks;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

/**
 * Created by Ken on 2016/9/17.
 */
@Transactional
public interface ClicksRepository extends CrudRepository<Clicks, Integer> {
    void deleteByArticleId(int articleId);
    Clicks findByArticleId(int articleId);
}
