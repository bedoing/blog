package org.bedoing.blog.controller.admin;

import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.controller.BaseController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author Ken
 * 
 */
//@Controller("adminJumpController")
//@RequestMapping("/admin/place")
public class JumpController extends BaseController {

	@RequestMapping(value = "/adminArticle")
	public ModelAndView toAdminArticle() {
		return new ModelAndView(UriConstant.ADMIN_BLOG_ADD_ARTICLE);
	}

	@RequestMapping(value = "/articleMng")
	public ModelAndView toArticleMng() {
		ModelAndView mv = new ModelAndView(UriConstant.ADMIN_BLOG_ARTICLE_MNG);

		return mv;
	}

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
