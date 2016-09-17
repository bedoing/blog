package org.bedoing.blog.controller;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.entity.Clicks;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.vo.ArticleVO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RestController
//@RequestMapping(value = "/subject")
public class SubjectController extends BaseController{
	private static final Logger log = Logger.getLogger(SubjectController.class);
	
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
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
}
