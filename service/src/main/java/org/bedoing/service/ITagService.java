package org.bedoing.service;

import org.bedoing.entity.Tag;
import org.bedoing.vo.TagsVO;

import java.util.List;

public interface ITagService {

	Tag saveTag(Tag tags);

	Tag findTagById(Integer tagId);

	String findTagNameById(Integer tagId);

	List<Tag> findAllTags();

	List<TagsVO> tagsGroup(int tagType);

	List<Tag> findTagsByType(int tagType);
}
