package org.bedoing.blog.constant;

public class MapperConstant {

	private MapperConstant(){}
	
	public static final String ARTICLE_addArticle = "article.addArticle";
	public static final String ARTICLE_deleteArticleById = "article.deleteArticleById";
	public static final String ARTICLE_updateArticle = "article.updateArticle";
	public static final String ARTICLE_countArticlesByCriteria = "article.countArticlesByCriteria";
	public static final String ARTICLE_findArticleByCriteria = "article.findArticlesByCriteria";
	public static final String ARTICLE_findSubjectsByCriteria = "article.findSubjectsByCriteria";
	public static final String ARTICLE_addTag = "article.addTag";
	public static final String ARTICLE_findTagById = "article.findTagById";
	public static final String ARTICLE_findAllTags = "article.findAllTags";
	public static final String ARTICLE_addArticleTag = "article.addArticleTag";
	public static final String ARTICLE_findArticleTagsByArticleId =  "article.findArticleTagsByArticleId";
	public static final String ARTICLE_findArticleById =  "article.findArticleById";
	public static final String ARTICLE_tagsGroup =  "article.tagsGroup";
	public static final String ARTICLE_countArticlesByTagId = "article.countArticlesByTagId";
	public static final String ARTICLE_findArticlesByTag = "article.findArticlesByTagId";
	public static final String ARTICLE_deleteArticleTagByArticleId = "article.deleteArticleTagByArticleId";
	
	// subject
	public static final String ARTICLE_findSubjectById = "article.findSubjectById";
	public static final String ARTICLE_findSubjectByArticleId = "article.findSubjectByArticleId";
	
	// clicks
	public static final String ARTICLE_getClicks = "article.getClicks";
	public static final String ARTICLE_updateClicks = "article.updateClicks";
	public static final String ARTICLE_addClicks = "article.addClicks";
	
	// ************

	public static final String LOGINLOG_saveLoginLog = "loginLog.saveLoginLog";
	public static final String LOGINACCOUNT_saveLoginAccount = "loginAccount.saveLoginAccount";
	public static final String LOGINACCOUNT_countByLoginAccount = "loginAccount.countByLoginAccount";
	public static final String LOGINACCOUNT_findUserByLoginAccount= "loginAccount.findUserByLoginAccount";
	public static final String LOGINACCOUNT_findUserByCriteria= "loginAccount.findUserByCriteria";
	
	// comments
	public static final String COMMENTS_addComment = "comments.addComment";
	public static final String COMMENTS_countCommentByArticleId = "comments.countCommentByArticleId";
	public static final String COMMENTS_findCommentsByArticleId = "comments.findCommentsByArticleId";
	public static final String COMMENTS_updateStatusById = "comments.updateStatusById";
	
	public static final String COMMON_findAllDict= "common.findAllDict";
	
}
