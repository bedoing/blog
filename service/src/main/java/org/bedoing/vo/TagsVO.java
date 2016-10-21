package org.bedoing.vo;

import lombok.Data;

@Data
public class TagsVO extends BaseVO {

	private int articleNum;
	private int tagId;
	private String tagName;
	private int tagType;
}
