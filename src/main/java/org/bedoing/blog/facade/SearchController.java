package org.bedoing.blog.facade;

import org.apache.log4j.Logger;
import org.bedoing.blog.constant.UriConstant;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.vo.ArticleVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

/**
 * Created by Administrator on 2016/9/19.
 */
@RestController
@RequestMapping("/search")
public class SearchController extends BaseController {
    private static final Logger log = Logger.getLogger(TagController.class);

    @Resource
    private IArticleService articleService;

    @RequestMapping(value="/{content}", method = {GET, POST}, produces = MediaType.APPLICATION_JSON_VALUE)
    public ModelAndView search(@PathVariable String content) {
        ModelAndView mv = new ModelAndView(UriConstant.DEFAULT_SEARCH);
        mv.addObject("keywords", content);

        List<ArticleVO> list = articleService.findArticlesByCriteria(new ArticleVO());

        mv.addObject("list", list);

        return mv;
    }
}
