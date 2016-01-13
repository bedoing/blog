package org.bedoing.blog.service;

import java.util.List;

import org.bedoing.blog.po.Article;
import org.bedoing.blog.po.ArticleTags;
import org.bedoing.blog.po.Clicks;
import org.bedoing.blog.po.Subject;
import org.bedoing.blog.po.Tag;
import org.bedoing.blog.vo.ArticleVO;
import org.bedoing.blog.vo.TagsVO;

public interface IArticleService {

	// article
	public int addArticle(ArticleVO article);
	public int deleteArticleById(int articleId);
	public int updateArticle(ArticleVO article);
	public int countArticlesByCriteria(ArticleVO articleVo);
	public List<ArticleVO> findArticlesByCriteria(ArticleVO articleVo);
	public ArticleVO findArticleById(int articleId);
	public Article findArticleByTitle(String title);
	public List<ArticleVO> findArticlesOrderByClicks(ArticleVO articleVo);
	
	public int countArticlesByTagId(TagsVO tagVO);
	public List<ArticleVO> findArticlesByTagId(TagsVO tagVO);
	
	// subject 
	public Subject findSubjectById(int subjectId);
	public Subject  findSubjectByArticleId(int articleId);
	public void deleteSubjectByArticleId(int articleId);
	public int addSubject(Subject subject);
	public int updateSubject(Subject subject);
	
	// tags
	public int addTag(Tag tags);
	public String findTagById(int tagId);
	public List<Tag> findAllTags();
	public int addArticleTag(ArticleTags articleTags);
	public List<ArticleTags> findArticleTagsByArticleId(int articleId);
	public List<TagsVO> tagsGroup(int tagType);
	public List<Tag> findTagsByType(int tagType);
	public void initTagDict();
	
	// article tags
	public void deleteArticleTagByArticleId(int articleId);
	
	// clicks
	public void addClicks(Clicks click);
	public int getClicks(int articleId);
	public void updateClicks(Clicks click);
	public void deleteClicksByArticleId(int articleId);
}
