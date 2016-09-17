package org.bedoing.blog.service;

import java.util.List;

import org.bedoing.blog.entity.Statistics;
import org.bedoing.blog.vo.CommentsVO;


public interface ICommentService {

	int addComment(CommentsVO comment);
	int countCommentByArticleId(int articleId);
	List<CommentsVO> findCommentsByArticleId(CommentsVO comment);
	void updateStatusById(CommentsVO comment);
	void deleteCommentsByArticleId(int articleId);
	
	int addStatistics(Statistics statistics);
	int updateStatistics(Statistics statistics);
	Statistics findStatisticsByType(String type);
	Statistics findStatisticsById(int id);
	List<Statistics> findAllStatistics();
}
