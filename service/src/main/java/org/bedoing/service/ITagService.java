package org.bedoing.service;

import org.bedoing.entity.ArticleTags;
import org.bedoing.entity.Tag;
import org.bedoing.vo.TagsVO;

import java.util.List;

public interface ITagService {
	// tags
	Tag saveTag(Tag tags);

	String findTagById(Integer tagId);

	List<Tag> findAllTags();

	ArticleTags saveArticleTag(ArticleTags articleTags);

	List<TagsVO> tagsGroup(int tagType);

	List<Tag> findTagsByType(int tagType);
	
	// article tags
	void deleteArticleTagByArticleId(Integer articleId);
}
