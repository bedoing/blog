package org.bedoing.blog.facade;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.bedoing.blog.commons.MapFactory;
import org.bedoing.blog.commons.TagsDict;
import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.entity.Clicks;
import org.bedoing.blog.entity.Tag;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.util.DateUtils;
import org.bedoing.blog.vo.ArticleVO;
import org.bedoing.blog.vo.ResponseVO;
import org.bedoing.blog.vo.TagsVO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
	private static final Logger log = Logger.getLogger(ArticleController.class);
	
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "/list", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> articleList(HttpServletRequest request, ArticleVO articleVO){
		articleVO.setBeginRow((articleVO.getPageNo() - 1) * articleVO.getPageSize());
		articleVO.setSortColumn("createTime");
		
		// TODO
		int total = articleService.countArticlesByCriteria(articleVO);
		List<ArticleVO> list = articleService.findArticlesByCriteria(articleVO);
		log.info("total: " + total + ", " + "list.size(): " + list.size());
		log.info(JSON.toJSONString(list));
		
		return MapFactory.buildResMap()
			.setTotal(total)
			.setPageNo(articleVO.getPageNo())
			.setPageSize(articleVO.getPageSize())
			.setResult(list);
	}
	
	@RequestMapping(value = "/hot", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> hotArticles(HttpServletRequest request, ArticleVO articleVO){
		articleVO.setPageSize(10);
		log.info(JSON.toJSONString(articleVO));
		articleVO.setSortColumn("clicks");
		
		// TODO
		List<ArticleVO> list = articleService.findArticlesOrderByClicks(articleVO);
		log.info(JSON.toJSONString(list));
		
		return MapFactory.buildResMap()
			.setResult(list);
	}
	
	@RequestMapping(value = "/counts", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO countArticles() {
		ResponseVO res = new ResponseVO();
		ArticleVO vo = new ArticleVO();
		// TODO
		vo.setArticleType(1);
		int countArticles = articleService.countArticlesByCriteria(vo);
		vo.setArticleType(2);
		int countSubjects = articleService.countArticlesByCriteria(vo);
		Map<String, Integer> map = new HashMap<String, Integer>();
		int countDays = DateUtils.getIntervalDays("20151212", DateUtils.formatCalendar(Calendar.getInstance(), "yyyyMMdd"));
		map.put("articleCount", countArticles);
		map.put("subjectCount", countSubjects);
		map.put("dayCount", countDays);
		res.setRetData(map);
		
		return res;
	}
	
	@RequestMapping(value = "/{articleId}", method = GET)
	public ModelAndView articleContent(@PathVariable int articleId){
		ModelAndView mv = new ModelAndView(UriConstant.DEFAULT_ARTICLE_CONTENT);
		ArticleVO article = articleService.findArticleById(articleId);
		int click = articleService.getClicks(article.getArticleId());
		Clicks c = new Clicks();
		c.setArticleId(article.getArticleId());
		c.setClicks(++click);
		articleService.updateClicks(c);
		article.setClicks(click);
		mv.addObject("article", article);
		
		return mv;
	}
	
	@RequestMapping(value = "/list/tag={tagsVO}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findArticlesByTagId(@PathVariable TagsVO tagsVO) {
		tagsVO.setBeginRow((tagsVO.getPageNo() - 1) * tagsVO.getPageSize());
		tagsVO.setTagId(TagsDict.getTagIdByName(tagsVO.getTagName()));
		tagsVO.setSortColumn("createTime");
		
		int total = articleService.countArticlesByTagId(tagsVO);
		List<ArticleVO> list = articleService.findArticlesByTagId(tagsVO);
		
		log.info(total + " - " + list.size());
		
		return MapFactory.buildResMap()
				.setTotal(total)
				.setPageNo(tagsVO.getPageNo())
				.setPageSize(tagsVO.getPageSize())
				.setResult(list);
	}
}
