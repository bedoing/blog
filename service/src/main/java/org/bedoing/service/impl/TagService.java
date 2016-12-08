package org.bedoing.service.impl;

import org.apache.log4j.Logger;
import org.bedoing.constant.MapperConstant;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.ArticleTags;
import org.bedoing.entity.Tag;
import org.bedoing.mybatis.MyBatisDAO;
import org.bedoing.repository.*;
import org.bedoing.service.ITagService;
import org.bedoing.util.ValidateUtils;
import org.bedoing.vo.TagsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class TagService implements ITagService {
	private static final Logger log = Logger.getLogger(TagService.class);

	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private ArticleTagsRepository articleTagsRepository;
	@Autowired
	private ClicksRepository clicksRepository;
	@Autowired
	private SubjectRepository subjectRepository;

	@Override
	public Tag saveTag(Tag tag) {
		ValidateUtils.validateObject(TableAttrConstant.TAG, tag);
		ValidateUtils.validateTagName(tag.getTagName());
		return tagRepository.save(tag);
	}

	@Override
	public String findTagById(Integer tagId) {
		Tag tag = tagRepository.findOne(tagId);
		return tag == null? "":tag.getTagName();
	}

	@Override
	public List<Tag> findAllTags() {
		return (List<Tag>) tagRepository.findAll();
	}

	@Override
	public ArticleTags saveArticleTag(ArticleTags articleTags) {
		return articleTagsRepository.save(articleTags);
	}

	@Override
	public List<TagsVO> tagsGroup(int tagType) {
		List<TagsVO> list = new ArrayList<TagsVO>();
		if(tagType != 0 && tagType != -1) {
			list = myBatisDAO.getList("tagsGroupByTagType", tagType);
		}else {
			list = myBatisDAO.getList(MapperConstant.ARTICLE_tagsGroup);
		}
		
		return list;
	}

	@Override
	public void deleteArticleTagByArticleId(Integer articleId) {
		articleTagsRepository.deleteByArticleId(articleId);
	}

	@Override
	public List<Tag> findTagsByType(int tagType) {
		List<Tag> result = new ArrayList<Tag>();
		if(tagType == -1) {
			result = (List<Tag>) tagRepository.findAll();
		}else {
			result = tagRepository.findByTagType(tagType);
		}
		return result;
	}
}
