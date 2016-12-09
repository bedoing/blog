package org.bedoing.service;

import org.bedoing.entity.*;
import org.bedoing.vo.ArticleVO;
import org.bedoing.vo.TagsVO;

import java.util.List;

public interface IArticleService {

	Article addArticle(ArticleVO article);

	void deleteArticleById(Integer articleId);

	ArticleVO updateArticle(ArticleVO article);

	int countArticlesByCriteria(ArticleVO articleVO);

	/**
	 * 不包括content
	 * @param articleVO
	 * @return
	 */
	List<ArticleVO> findSimpleArticlesByCriteria(ArticleVO articleVO);

	ArticleVO findArticleById(Integer articleId);

	Article findArticleByTitle(String title);

	List<ArticleVO> findArticlesOrderByClicks(ArticleVO articleVO);
	
	int countArticlesByTagId(TagsVO tagVO);

	List<ArticleVO> findArticlesByTagId(TagsVO tagVO);
}
