package org.bedoing.service;

import org.bedoing.entity.ArticleTags;

import java.util.List;

public interface IArticleTagsService {

	ArticleTags saveArticleTag(ArticleTags articleTags);

	List<ArticleTags> findArticleTagsByArticleId(Integer articleId);

	void deleteArticleTagByArticleId(Integer articleId);
}
