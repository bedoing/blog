package org.bedoing.service.impl;

import org.bedoing.constant.MapperConstant;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.Tag;
import org.bedoing.mybatis.MyBatisDAO;
import org.bedoing.repository.TagRepository;
import org.bedoing.service.ITagService;
import org.bedoing.util.ValidateUtils;
import org.bedoing.vo.TagsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class TagService implements ITagService {

	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private TagRepository tagRepository;

	@Override
	public Tag saveTag(Tag tag) {
		ValidateUtils.validateObject(TableAttrConstant.TAG, tag);
		ValidateUtils.validateTagName(tag.getTagName());
		if(tag.getTagId() != null) {
			Tag dbTag = tagRepository.findOne(tag.getTagId());
			validateTagExists(dbTag);
		}
		return tagRepository.save(tag);
	}

	@Override
	public Tag findTagById(Integer tagId) {
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TAG_ID, tagId);
		Tag tag = tagRepository.findOne(tagId);
		validateTagExists(tag);

		return tag;
	}

	@Override
	public String findTagNameById(Integer tagId) {
		ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TAG_ID, tagId);
		Tag tag = tagRepository.findOne(tagId);
		validateTagExists(tag);

		return tag.getTagName();
	}

	@Override
	public List<Tag> findAllTags() {
		return (List<Tag>) tagRepository.findAll();
	}

	@Override
	public List<TagsVO> tagsGroup(int tagType) {
		List<TagsVO> result;
		if(tagType != 0 && tagType != -1) {
			result = myBatisDAO.getList(MapperConstant.ARTICLE_tagsGroupByTagType, tagType);
		}else {
			result = myBatisDAO.getList(MapperConstant.ARTICLE_tagsGroup);
		}

		if(org.apache.cxf.common.util.CollectionUtils.isEmpty(result)) {
			ValidateUtils.recordNotExistException(TableAttrConstant.TAG, String.valueOf(tagType));
		}
		
		return result;
	}

	@Override
	public List<Tag> findTagsByType(int tagType) {
		List<Tag> result;
		if(tagType == -1) {
			result = (List<Tag>) tagRepository.findAll();
		}else {
			result = tagRepository.findByTagType(tagType);
		}

		if(org.apache.cxf.common.util.CollectionUtils.isEmpty(result)) {
			ValidateUtils.recordNotExistException(TableAttrConstant.TAG, String.valueOf(tagType));
		}

		return result;
	}

	private void validateTagExists(Tag tag) {
		if(tag == null) {
			ValidateUtils.recordNotExistException(TableAttrConstant.TAG, tag.toString());
		}
	}
}
