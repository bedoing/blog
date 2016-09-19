package org.bedoing.blog.service;

import org.bedoing.blog.entity.Article;

/**
 * Created by ejiggun on 9/18/2016.
 */
public interface ITestArticleService {
    Article findArticleById(int articleId);
}
