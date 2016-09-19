package org.bedoing.blog.service.impl;

import org.bedoing.blog.constant.MapperConstant;
import org.bedoing.blog.entity.Article;
import org.bedoing.blog.mybatis.MyBatisDAO;
import org.bedoing.blog.service.ITestArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by ejiggun on 9/18/2016.
 */
@Service
public class TestArticleServiceImpl implements ITestArticleService {
    @Autowired
    private MyBatisDAO myBatisDAO;

    @Override
    public Article findArticleById(int articleId) {
        Article a = myBatisDAO.get(MapperConstant.ARTICLE_findArticleById, articleId);
        return a;
    }
}
