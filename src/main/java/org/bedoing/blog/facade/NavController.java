package org.bedoing.blog.facade;

import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.entity.LoginAccount;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * 
 * @author Ken
 * 
 */
@RestController
public class NavController extends BaseController {

	// 菜单
	@RequestMapping(value = "/index")
	public ModelAndView toDefault() {
		return new ModelAndView(UriConstant.DEFAULT_DEFAULT);
	}

	@RequestMapping(value = "/portfolio")
	public ModelAndView toPortfolio() {
		return new ModelAndView(UriConstant.DEFAULT_PORTFOLIO);
	}

	@RequestMapping(value = "/articles")
	public ModelAndView toBlog() {
		return new ModelAndView(UriConstant.DEFAULT_ARTICLES);
	}
	
	@RequestMapping(value = "/subjects")
	public ModelAndView toSubject() {
		return new ModelAndView("blog/default/subject");
	}

	@RequestMapping(value = "/services")
	public ModelAndView toServices() {
		return new ModelAndView(UriConstant.DEFAULT_SERVICES);
	}

	@RequestMapping(value = "/about")
	public ModelAndView toAbout() {
		return new ModelAndView(UriConstant.DEFAULT_ABOUT);
	}

	@RequestMapping(value = "/contact")
	public ModelAndView toContact() {
		return new ModelAndView(UriConstant.DEFAULT_CONTACT);
	}

	@RequestMapping(value = "/registe")
	public ModelAndView toRegiste() {
		return new ModelAndView(UriConstant.DEFAULT_REGISTE);
	}

	@RequestMapping(value = "/login")
	public ModelAndView toLogin(HttpServletRequest request) {
		LoginAccount user = getUserInfo(request);
		if (null != user) {
			return new ModelAndView(UriConstant.ADMIN_INDEX);
		}
		return new ModelAndView(UriConstant.ADMIN_LOGIN);
	}

	@RequestMapping(value = "/articles/tag={tagName}", method = GET)
	public ModelAndView toArticlesByTag(@PathVariable String tagName) {
		return new ModelAndView(UriConstant.DEFAULT_BLOG_ARTICLE_BY_TAG).addObject("tagName", tagName);
	}

	@RequestMapping(value = "/subjects/tag={tagName}", method = GET)
	public ModelAndView toSubjectsByTag(@PathVariable String tagName) {
		return new ModelAndView(UriConstant.DEFAULT_BLOG_ARTICLE_BY_TAG).addObject("tagName", tagName);
	}

	// TODO
	@RequestMapping(value = "/comment")
	public ModelAndView toComment() {
		ModelAndView mv = new ModelAndView(UriConstant.DEFAULT_COMMENT);

		return mv;
	}
}
