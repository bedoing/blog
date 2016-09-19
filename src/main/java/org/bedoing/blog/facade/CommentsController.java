package org.bedoing.blog.facade;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.bedoing.blog.commons.MapFactory;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.service.ICommentService;
import org.bedoing.blog.vo.CommentsVO;
import org.bedoing.blog.vo.ResponseVO;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/comment")
public class CommentsController extends BaseController {
	private static final Logger log = Logger.getLogger(CommentsController.class);
	
	@Resource
	private IArticleService articleService;
	@Resource
	private ICommentService commentService;
	
	@RequestMapping(value = "/list")
	public @ResponseBody Map<String, Object> commentList(HttpServletRequest request, CommentsVO comment){
		comment.setPageSize(100);
		comment.setBeginRow((comment.getPageNo() - 1) * comment.getPageSize());
		log.info(JSON.toJSONString(comment));
		comment.setSortColumn("createTime");
		
		int total = commentService.countCommentByArticleId(comment.getArticleId());
		List<CommentsVO> list = commentService.findCommentsByArticleId(comment);
		log.info("total: " + total + ", " + "list.size(): " + list.size());
		log.info(JSON.toJSONString(list));
		
		return MapFactory.buildResMap()
			.setTotal(total)
			.setPageNo(comment.getPageNo())
			.setPageSize(comment.getPageSize())
			.setResult(list);
	}
	
	@RequestMapping(value = "/addComment")
	public @ResponseBody ResponseVO addComment(CommentsVO comment) {
		log.info(JSON.toJSONString(comment));
		ResponseVO res = new ResponseVO();
		if(comment == null || comment.getContent() == null || comment.getContent().trim() == ""){
			res.setErrNum(Constant.N_0);
			res.setRetMsg("提交失败，空评论");
		}else {
			commentService.addComment(comment);
			res.setRetMsg(Constant.SUCCESS);
		}
		
		return res;
	}
	
	@RequestMapping(value = "/updatecomment")
	public @ResponseBody ResponseVO updatecomment(CommentsVO comment) {
		commentService.updateStatusById(comment);
		ResponseVO res = new ResponseVO();
		res.setRetMsg(Constant.SUCCESS);
		
		return res;
	}
}
