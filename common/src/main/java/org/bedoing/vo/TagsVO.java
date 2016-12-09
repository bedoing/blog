package org.bedoing.vo;

import lombok.Data;

@Data
public class TagsVO extends BaseVO {

	private int articleNum;
	private Integer tagId;
	private String tagName;
	private int tagType;

	public TagsVO () {

	}

	public TagsVO(Integer tagId, String tagName) {
		this.tagId = tagId;
		this.tagName = tagName;
	}

	public TagsVO(Integer tagId, String tagName, int tagType) {
		this.tagId = tagId;
		this.tagName = tagName;
		this.tagType = tagType;
	}
}
