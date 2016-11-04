package org.bedoing.facade;

import org.apache.log4j.Logger;
import org.bedoing.constant.UriConstant;
import org.bedoing.entity.Clicks;
import org.bedoing.service.IArticleService;
import org.bedoing.vo.ArticleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
@RequestMapping(value = "/subject")
public class SubjectController extends BaseController {
	private static final Logger log = Logger.getLogger(SubjectController.class);
	
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "/{articleId}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
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
