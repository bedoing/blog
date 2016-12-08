package org.bedoing.service;

import org.bedoing.entity.*;
import org.bedoing.vo.ArticleVO;
import org.bedoing.vo.TagsVO;

import java.util.List;

public interface IArticleService {

	// article
	Article addArticle(ArticleVO article);
	void deleteArticleById(int articleId);
	Article updateArticle(ArticleVO article);
	int countArticlesByCriteria(ArticleVO articleVo);
	/**
	 * 不包括content
	 * @param articleVo
	 * @return
	 */
	List<ArticleVO> findArticlesByCriteria(ArticleVO articleVo);
	ArticleVO findArticleById(int articleId);
	Article findArticleByTitle(String title);
	List<ArticleVO> findArticlesOrderByClicks(ArticleVO articleVo);
	
	int countArticlesByTagId(TagsVO tagVO);
	List<ArticleVO> findArticlesByTagId(TagsVO tagVO);

	List<ArticleTags> findArticleTagsByArticleId(int articleId);
}
