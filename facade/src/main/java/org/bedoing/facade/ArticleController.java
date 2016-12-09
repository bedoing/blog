package org.bedoing.facade;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import org.apache.log4j.Logger;
import org.bedoing.commons.MapFactory;
import org.bedoing.commons.TagsDict;
import org.bedoing.constant.Constant;
import org.bedoing.constant.UriConstant;
import org.bedoing.entity.Clicks;
import org.bedoing.service.IArticleService;
import org.bedoing.service.IClicksService;
import org.bedoing.util.DateUtils;
import org.bedoing.vo.ArticleVO;
import org.bedoing.vo.ResponseVO;
import org.bedoing.vo.TagsVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@Api("Artilce Controller")
@RestController
@RequestMapping("/article")
public class ArticleController extends BaseController {
	private static final Logger log = Logger.getLogger(ArticleController.class);
	
	@Resource
	private IArticleService articleService;
	@Resource
	private IClicksService clicksService;
	
	@RequestMapping(value = "/list", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> articleList(@RequestBody ArticleVO articleVO){
		articleVO.setBeginRow((articleVO.getPageNo() - 1) * articleVO.getPageSize());
		articleVO.setSortColumn("create_time");
		
		// TODO
		int total = articleService.countArticlesByCriteria(articleVO);
		List<ArticleVO> list = articleService.findSimpleArticlesByCriteria(articleVO);
		log.info("total: " + total + ", " + "list.size(): " + list.size());
		log.info(JSON.toJSONString(list));
		
		return MapFactory.buildResMap()
			.setTotal(total)
			.setPageNo(articleVO.getPageNo())
			.setPageSize(articleVO.getPageSize())
			.setResult(list);
	}
	
	@RequestMapping(value = "/hot", method = {GET, POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> hotArticles(@RequestBody ArticleVO articleVO){
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
		int click = clicksService.getClicks(article.getArticleId());
		Clicks c = new Clicks();
		c.setArticleId(article.getArticleId());
		c.setClicks(++click);
		clicksService.updateClicks(c);
		article.setClicks(click);
		mv.addObject("article", article);
		
		return mv;
	}
	
	@RequestMapping(value = "/list/tag", method = {GET, POST}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object> findArticlesByTagId(@RequestBody TagsVO tagsVO) {
		tagsVO.setBeginRow((tagsVO.getPageNo() - 1) * tagsVO.getPageSize());
		tagsVO.setTagId(TagsDict.getTagIdByName(tagsVO.getTagName()));
		tagsVO.setSortColumn("create_time");
		
		int total = articleService.countArticlesByTagId(tagsVO);
		List<ArticleVO> list = articleService.findArticlesByTagId(tagsVO);
		
		log.info(total + " - " + list.size());
		
		return MapFactory.buildResMap()
				.setTotal(total)
				.setPageNo(tagsVO.getPageNo())
				.setPageSize(tagsVO.getPageSize())
				.setResult(list);
	}


	/******************* admin *********************/
	@RequestMapping(value = "/admin", method = POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO addArticle(@RequestBody ArticleVO article) {
		log.info(JSON.toJSONString(article));
		ResponseVO res = new ResponseVO();

		if(articleService.findArticleByTitle(article.getTitle()) != null) {
			res.setErrNum(Constant.N_0);
			res.setRetMsg(Constant.ERROR);
		}else{
			// TODO
			article.setCreateBy("Ken");
			articleService.addArticle(article);

			res.setRetMsg(Constant.SUCCESS);
		}

		return res;
	}

	@RequestMapping(value = "/admin/{articleId}", method = DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO deleteArticle(@PathVariable int articleId) {
		articleService.deleteArticleById(articleId);
		ResponseVO res = new ResponseVO();
		res.setRetMsg(Constant.SUCCESS);

		return res;
	}

	@RequestMapping(value = "/admin", method = PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseVO updateArticle(@RequestBody ArticleVO article) {
		articleService.updateArticle(article);
		ResponseVO res = new ResponseVO();
		res.setRetMsg(Constant.SUCCESS);

		return res;
	}

	@RequestMapping(value = "/admin/updateArticlePage/{articleId}")
	public ModelAndView updateArticlePage(@PathVariable int articleId) {
		ModelAndView mv = new ModelAndView(UriConstant.ADMIN_BLOG_UPDATE_ARTICLE);
		// TODO
		ArticleVO a = articleService.findArticleById(articleId);
		mv.addObject("article", a);

		return mv;
	}
}
