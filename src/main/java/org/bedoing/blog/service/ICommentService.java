package org.bedoing.blog.service;

import java.util.List;

import org.bedoing.blog.po.Statistics;
import org.bedoing.blog.vo.CommentsVO;


public interface ICommentService {

	public int addComment(CommentsVO comment);
	public int countCommentByArticleId(int articleId);
	public List<CommentsVO> findCommentsByArticleId(CommentsVO comment);
	public void updateStatusById(CommentsVO comment);
	public void deleteCommentsByArticleId(int articleId);
	
	public int addStatistics(Statistics statistics);
	public int updateStatistics(Statistics statistics);
	public Statistics findStatisticsByType(String type);
	public Statistics findStatisticsById(int id);
	public List<Statistics> findAllStatistics();
}
