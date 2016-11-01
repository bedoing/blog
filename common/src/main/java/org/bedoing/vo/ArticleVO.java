package org.bedoing.vo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleVO extends BaseVO{

	private int articleId;
	private String title;
	private int articleType; // 1.article  2.subject
	private String summary;
	private String content;
	private String createBy;
	private long createTime;
	private String lastUpdBy;
	private long lastUpdTime;
	
	private String createTimeStr;
	private String lastUpdTimeStr;
	
	private String tags;
	private int clicks;
	
	private List<TagsVO> tagList = new ArrayList<TagsVO>();
	SubjectVO subject = new SubjectVO();
}
