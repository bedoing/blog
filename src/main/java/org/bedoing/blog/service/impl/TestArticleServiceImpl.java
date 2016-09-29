package org.bedoing.blog.service.impl;

import org.bedoing.blog.entity.Article;
import org.bedoing.blog.repository.ArticleRepository;
import org.bedoing.blog.service.ITestArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by ejiggun on 9/18/2016.
 */
@Service
@Transactional
public class TestArticleServiceImpl implements ITestArticleService {
    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public Article findArticleById(int articleId) {
        Article a = articleRepository.findOne(articleId);
        return a;
    }
}
