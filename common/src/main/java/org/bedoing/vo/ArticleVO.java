package org.bedoing.vo;

import com.google.common.collect.Lists;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleVO extends BaseVO{

	private Integer articleId;
	private String title;
	private int articleType; // 1.article  2.subject
	private String summary;
	private String content;
	private String createBy;
	private long createTime;
	private String lastUpdBy;
	private long lastUpdTime;
	
	private String tags; // tagId String
	private int clicks;
	
	private List<TagsVO> tagList = Lists.newArrayList();
}
