package org.bedoing.blog.facade;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.bedoing.blog.commons.MapFactory;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.service.ICommentService;
import org.bedoing.blog.vo.CommentsVO;
import org.bedoing.blog.vo.ResponseVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import static org.springframework.web.bind.annotation.RequestMethod.PUT;

@RestController
@RequestMapping(value = "/comment")
public class CommentsController extends BaseController {
	private static final Logger log = Logger.getLogger(CommentsController.class);
	
	@Resource
	private IArticleService articleService;
	@Resource
	private ICommentService commentService;
	
	@RequestMapping(value = "/list", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> commentList(@PathVariable CommentsVO comment){
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
	
	@RequestMapping(value = "/{comment}", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO addComment(@PathVariable CommentsVO comment) {
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
	
	@RequestMapping(value = "/{comment}", method = PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO updatecomment(@PathVariable CommentsVO comment) {
		commentService.updateStatusById(comment);
		ResponseVO res = new ResponseVO();
		res.setRetMsg(Constant.SUCCESS);
		
		return res;
	}
}
