package org.bedoing.blog.service;

import org.bedoing.blog.entity.*;
import org.bedoing.blog.vo.ArticleVO;
import org.bedoing.blog.vo.TagsVO;

import java.util.List;

public interface IArticleService {

	// article
	int addArticle(ArticleVO article);
	int deleteArticleById(int articleId);
	int updateArticle(ArticleVO article);
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
	
	// subject 
	Subject findSubjectById(int subjectId);
	Subject  findSubjectByArticleId(int articleId);
	void deleteSubjectByArticleId(int articleId);
	int addSubject(Subject subject);
	int updateSubject(Subject subject);
	
	// tags
	int addTag(Tag tags);
	String findTagById(int tagId);
	List<Tag> findAllTags();
	int addArticleTag(ArticleTags articleTags);
	List<ArticleTags> findArticleTagsByArticleId(int articleId);
	List<TagsVO> tagsGroup(int tagType);
	List<Tag> findTagsByType(int tagType);
	void initTagDict();
	
	// article tags
	void deleteArticleTagByArticleId(int articleId);
	
	// clicks
	void addClicks(Clicks click);
	int getClicks(int articleId);
	void updateClicks(Clicks click);
	void deleteClicksByArticleId(int articleId);
}
