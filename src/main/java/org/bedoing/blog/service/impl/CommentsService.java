package org.bedoing.blog.service.impl;

import org.apache.log4j.Logger;
import org.bedoing.blog.constant.MapperConstant;
import org.bedoing.blog.entity.Comments;
import org.bedoing.blog.entity.Statistics;
import org.bedoing.blog.mybatis.MyBatisDAO;
import org.bedoing.blog.service.ICommentService;
import org.bedoing.blog.util.DateUtils;
import org.bedoing.blog.vo.CommentsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CommentsService implements ICommentService{
	private static final Logger log = Logger.getLogger(CommentsService.class);

	@Autowired
	private MyBatisDAO myBatisDAO;

	@Override
	public int addComment(CommentsVO comment) {
		Comments c = new Comments();
		c.setArticleId(comment.getArticleId());
		c.setContent(comment.getContent());
		c.setStatus(1);
		c.setCreateTime(DateUtils.getTimeImMillis(new Date()));
		
		myBatisDAO.save(MapperConstant.COMMENTS_addComment, c);
		return c.getCommentId();
	}

	@Override
	public int countCommentByArticleId(int articleId) {
		return myBatisDAO.get(MapperConstant.COMMENTS_countCommentByArticleId, articleId);
	}

	@Override
	public List<CommentsVO> findCommentsByArticleId(CommentsVO comment) {
		List<Comments> cList = myBatisDAO.getList(MapperConstant.COMMENTS_findCommentsByArticleId, comment);
		List<CommentsVO> result = new ArrayList<CommentsVO>();
		for (Comments c : cList) {
			CommentsVO v = new CommentsVO();
			v.setCommentId(c.getCommentId());
			v.setArticleId(c.getArticleId());
			v.setContent(c.getContent().trim());
			v.setStatus(c.getStatus());
			v.setCreateTime(c.getCreateTime());
			v.setCreateTimeStr(DateUtils.getDateStrByTimiMillis("yyyy-MM-dd HH:mm:ss", c.getCreateTime()));
		
			result.add(v);
		}
		
		return result;
	}

	@Override
	public void updateStatusById(CommentsVO comment) {
		myBatisDAO.update(MapperConstant.COMMENTS_updateStatusById, comment);
	}

	@Override
	public int addStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStatistics(Statistics statistics) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Statistics findStatisticsByType(String type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Statistics findStatisticsById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Statistics> findAllStatistics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCommentsByArticleId(int articleId) {
		myBatisDAO.delete("deleteCommentsByArticleId", articleId);
	}
}
