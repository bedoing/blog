package org.bedoing.blog.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.bedoing.blog.commons.MapFactory;
import org.bedoing.blog.commons.TagsDict;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.po.Clicks;
import org.bedoing.blog.po.Tag;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.util.DateUtils;
import org.bedoing.blog.vo.ArticleVO;
import org.bedoing.blog.vo.ResponseVO;
import org.bedoing.blog.vo.TagsVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(value = "/article")
public class ArticleController extends BaseController{
	private static final Logger log = Logger.getLogger(ArticleController.class);
	
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "/articleList")
	public @ResponseBody Map<String, Object> articleList(HttpServletRequest request, ArticleVO articleVO){
		articleVO.setBeginRow((articleVO.getPageNo() - 1) * articleVO.getPageSize());
		log.info(JSON.toJSONString(articleVO));
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
	
	@RequestMapping(value = "/hotArticles")
	public @ResponseBody Map<String, Object> hotArticles(HttpServletRequest request, ArticleVO articleVO){
		articleVO.setPageSize(10);
		log.info(JSON.toJSONString(articleVO));
		articleVO.setSortColumn("clicks");
		
		// TODO
		List<ArticleVO> list = articleService.findArticlesOrderByClicks(articleVO);
		log.info(JSON.toJSONString(list));
		
		return MapFactory.buildResMap()
			.setResult(list);
	}
	
	@RequestMapping(value = "/countArticles")
	public @ResponseBody ResponseVO countArticles() {
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
	
	@RequestMapping(value = "/addArticle")
	public @ResponseBody ResponseVO addArticle(ArticleVO article) {
		log.info(JSON.toJSONString(article));
		ResponseVO res = new ResponseVO();
		
		if(articleService.findArticleByTitle(article.getTitle()) != null) {
			res.setErrNum(Constant.N_0);
			res.setRetMsg(Constant.ERROR);
		}else{
			// TODO
			article.setCreateBy("Admin");
			int resultId = articleService.addArticle(article);
			
			res.setRetMsg(Constant.SUCCESS);
		}
		
		return res;
	}
	
	@RequestMapping(value = "/deleteArticle")
	public @ResponseBody ResponseVO deleteArticle(int articleId) {
		articleService.deleteArticleById(articleId);
		ResponseVO res = new ResponseVO();
		res.setRetMsg(Constant.SUCCESS);
		
		return res;
	}
	
	@RequestMapping(value = "/updateArticle")
	public @ResponseBody ResponseVO updateArticle(ArticleVO article) {
		articleService.updateArticle(article);
		ResponseVO res = new ResponseVO();
		res.setRetMsg(Constant.SUCCESS);
		
		return res;
	}
	
	@RequestMapping(value = "/articleContent")
	public ModelAndView articleContent(int articleId){
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
	
	@RequestMapping(value = "/tagsGroup")
	public @ResponseBody Map<String, Object> tagsGroup(int tagType){
		List<TagsVO> result = articleService.tagsGroup(tagType);
		log.info(JSON.toJSONString(result));
		
		List<String> tagNameList = new ArrayList<String>();
		List<Integer> articleNumList = new ArrayList<Integer>();
		for (TagsVO t : result) {
			tagNameList.add(t.getTagName());
			articleNumList.add(t.getArticleNum());
		}
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("tagNames", tagNameList);
		map.put("counts", articleNumList);
		map.put("data", result);
		
		return map;
	}
	
	@RequestMapping(value = "/findArticlesByTag")
	public @ResponseBody Map<String, Object> findArticlesByTagId(TagsVO tagsVO) {
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
	
	@RequestMapping(value = "/getAllTagsByType")
	public @ResponseBody List<TagsVO> getTags(int type){
		List<Tag> list = articleService.findTagsByType(type);
		List<TagsVO> result = new ArrayList<TagsVO>();
		for (Tag t : list) {
			TagsVO vo = new TagsVO();
			vo.setTagId(t.getTagId());
			vo.setTagName(t.getTagName());
			vo.setTagType(t.getTagType());
			
			result.add(vo);
		}
		
		return result;
	}
	
	@RequestMapping(value = "/addNewTag")
	public @ResponseBody ResponseVO addNewTag(String tagName, int tagType) {
		ResponseVO vo = new ResponseVO();
		String msg = "";
		// TODO
		if(tagType == -1) {
			msg = "请选择标签类型";
		}
		if(StringUtils.isBlank(tagName)) {
			msg = "空标签";
		}
		
		if(msg == "") {
			tagName = tagName.trim();
			if(TagsDict.getTagIdByName(tagName) != -1) {
				msg = "已存在标签";
			}else {
				Tag t = new Tag();
				t.setTagName(tagName);
				t.setTagType(tagType);
				int tagId = articleService.addTag(t);
				// TODO save error
				if(tagId != -1) {
					TagsDict.tagsDict.put(tagId, tagName);
					
					msg = Constant.SUCCESS;
				}
			}
		}
		vo.setRetMsg(msg);
		
		return vo;
	}
	
	@RequestMapping(value = "/UpdateArticlePage")
	public ModelAndView toUpdateArticle(int articleId) {
		ModelAndView mv = new ModelAndView(UriConstant.ADMIN_BLOG_UPDATE_ARTICLE);
		// TODO
		ArticleVO a = articleService.findArticleById(articleId);
		mv.addObject("article", a);
		
		return mv;
	}
	
	
}
