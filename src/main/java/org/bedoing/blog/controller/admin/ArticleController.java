package org.bedoing.blog.controller.admin;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.bedoing.blog.commons.TagsDict;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.controller.BaseController;
import org.bedoing.blog.entity.Tag;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.vo.ArticleVO;
import org.bedoing.blog.vo.ResponseVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;

//@Controller("adminArticleController")
//@RequestMapping(value = "/admin/article12")
public class ArticleController extends BaseController{
	private static final Logger log = Logger.getLogger(ArticleController.class);
	
	@Resource
	private IArticleService articleService;
	
	@RequestMapping(value = "/addArticle")
	public @ResponseBody ResponseVO addArticle(ArticleVO article) {
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
