package org.bedoing.blog.facade;

import com.alibaba.fastjson.JSON;
import org.apache.log4j.Logger;
import org.bedoing.blog.entity.Tag;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.vo.TagsVO;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by Administrator on 2016/9/19.
 */
@RestController
@RequestMapping("/tag")
public class TagController extends BaseController {
    private static final Logger log = Logger.getLogger(TagController.class);

    @Resource
    private IArticleService articleService;

    @RequestMapping(value = "/tagsGroup/{tagType}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Map<String, Object> tagsGroup(@PathVariable int tagType){
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

    @RequestMapping(value = "/tags/{type}", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TagsVO> getTags(@PathVariable int type){
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
}
