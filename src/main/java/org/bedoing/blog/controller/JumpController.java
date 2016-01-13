package org.bedoing.blog.controller;

import javax.servlet.http.HttpServletRequest;

import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.po.LoginAccount;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Ken
 * 
 */
@Controller
@RequestMapping("/place")
public class JumpController extends BaseController {

	// 菜单
	@RequestMapping(value = "/default")
	public ModelAndView toDefault() {
		return new ModelAndView(UriConstant.DEFAULT_DEFAULT);
	}

	@RequestMapping(value = "/portfolio")
	public ModelAndView toPortfolio() {
		return new ModelAndView(UriConstant.DEFAULT_PORTFOLIO);
	}

	@RequestMapping(value = "/blog")
	public ModelAndView toBlog() {
		return new ModelAndView(UriConstant.DEFAULT_BLOG);
	}
	
	@RequestMapping(value = "/subject")
	public ModelAndView toSubject() {
		return new ModelAndView("default/subject");
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
		if (user != null) {
			return new ModelAndView(UriConstant.ADMIN_INDEX);
		}
		return new ModelAndView(UriConstant.ADMIN_LOGIN);
	}

	@RequestMapping(value = "/adminArticle")
	public ModelAndView toAdminArticle() {
		return new ModelAndView(UriConstant.ADMIN_BLOG_ADD_ARTICLE);
	}

	@RequestMapping(value = "/articleByTag")
	public ModelAndView toArtidcleByTag(String tagName) {
		return new ModelAndView(UriConstant.DEFAULT_BLOG_ARTICLE_BY_TAG)
				.addObject("tagName", tagName);
	}

	@RequestMapping(value = "/articleMng")
	public ModelAndView toArticleMng() {
		ModelAndView mv = new ModelAndView(UriConstant.ADMIN_BLOG_ARTICLE_MNG);

		return mv;
	}

	// TODO
	@RequestMapping(value = "/comment")
	public ModelAndView toComment() {
		ModelAndView mv = new ModelAndView(UriConstant.DEFAULT_COMMENT);

		return mv;
	}

	/*
	 * @RequestMapping(value = "/login") public ModelAndView
	 * toLogin(HttpServletRequest request){ LoginAccount user =
	 * getUserInfo(request); if(user != null){ return new
	 * ModelAndView(UriConstant.ADMIN_INDEX); } return new
	 * ModelAndView(UriConstant.ADMIN_LOGIN); }
	 */

	// admin
	@RequestMapping(value = "/adminIndex")
	public ModelAndView toAdminIndex() {
		return new ModelAndView(UriConstant.ADMIN_INDEX);
	}

	@RequestMapping(value = "/adminForm")
	public ModelAndView toAdminForm() {
		return new ModelAndView(UriConstant.ADMIN_FORM);
	}

	@RequestMapping(value = "/adminSalaryMark")
	public ModelAndView toAdminSalaryMark() {
		return new ModelAndView(UriConstant.ADMIN_SALARY_MARK);
	}

	@RequestMapping(value = "/adminUserMng")
	public ModelAndView toAdminUserMng() {
		return new ModelAndView(UriConstant.ADMIN_USER_MNG);
	}

	@RequestMapping(value = "/adminGrid")
	public ModelAndView toAdminGrid() {
		return new ModelAndView(UriConstant.ADMIN_GRID);
	}

	@RequestMapping(value = "/adminUi")
	public ModelAndView toAdminUi() {
		return new ModelAndView(UriConstant.ADMIN_UI);
	}

	@RequestMapping(value = "/adminChart")
	public ModelAndView toAdminChart() {
		return new ModelAndView(UriConstant.ADMIN_CHART);
	}

	@RequestMapping(value = "/adminTypography")
	public ModelAndView toAdminTypography() {
		return new ModelAndView(UriConstant.ADMIN_TYPOGRAPHY);
	}

	@RequestMapping(value = "/adminPublish")
	public ModelAndView toAdminPublish() {
		return new ModelAndView(UriConstant.ADMIN_PUBLISH);
	}
}
