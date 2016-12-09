package org.bedoing.service.impl;

import org.apache.cxf.common.util.CollectionUtils;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.ArticleTags;
import org.bedoing.repository.ArticleTagsRepository;
import org.bedoing.service.IArticleTagsService;
import org.bedoing.util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ArticleTagsService implements IArticleTagsService {
	@Autowired
	private ArticleTagsRepository articleTagsRepository;

	@Override
	public ArticleTags saveArticleTag(ArticleTags articleTags) {
		ValidateUtils.validateObject(TableAttrConstant.ARTICLE_TAGS, articleTags);
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleTags.getArticleId());
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TAG_ID, articleTags.getTagId());
		if(articleTags.getId() != null) {
			ArticleTags at = articleTagsRepository.findOne(articleTags.getId());
			validateArticleTagsExists(at);
		}

		return articleTagsRepository.save(articleTags);
	}

	@Override
	public void deleteArticleTagByArticleId(Integer articleId) {
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleId);
		// should validate db?
		articleTagsRepository.deleteByArticleId(articleId);
	}

	@Override
	public List<ArticleTags> findArticleTagsByArticleId(Integer articleId) {
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleId);

		List<ArticleTags> result = articleTagsRepository.findByArticleId(articleId);
		if(CollectionUtils.isEmpty(result)) {
			ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE_TAGS, String.valueOf(articleId));
		}
		return result;
	}

	private void validateArticleTagsExists(ArticleTags articleTags) {
		if(articleTags == null) {
			ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE_TAGS, articleTags.toString());
		}
	}
}
