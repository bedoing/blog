package org.bedoing.service.utils;

import org.bedoing.entity.Article;
import org.bedoing.entity.Tag;
import org.bedoing.vo.ArticleVO;
import org.bedoing.vo.TagsVO;

public class Convertor {

    public static Article articleVo2Po(ArticleVO vo) {
        Article a = new Article();

        if(vo.getArticleId() != null) {
            a.setArticleId(vo.getArticleId());
        }
        a.setTitle(vo.getTitle());
        a.setArticleType(vo.getArticleType());
        a.setSummary(vo.getSummary());
        a.setContent(vo.getContent());
        a.setCreateBy(vo.getCreateBy());
        a.setCreateTime(vo.getCreateTime());
        a.setLastUpdBy(vo.getCreateBy());
        a.setLastUpdTime(vo.getCreateTime());

        return a;
    }

    public static Article getArticleUpdateFromVo(ArticleVO vo) {
        Article a = new Article();
        a.setArticleId(vo.getArticleId());
        a.setTitle(vo.getTitle());
        a.setSummary(vo.getSummary());
        a.setContent(vo.getContent());

        return a;
    }

    public static Tag tagVo2Po(TagsVO vo) {
        Tag tag = new Tag();
        tag.setTagId(vo.getTagId());
        tag.setTagName(vo.getTagName());
        tag.setTagType(vo.getTagType());

        return tag;
    }

    public static TagsVO tagPo2Vo(Tag tag) {
        TagsVO vo = new TagsVO();
        vo.setTagId(tag.getTagId());
        vo.setTagName(tag.getTagName());
        vo.setTagType(tag.getTagId());

        return vo;
    }

    private Convertor(){}
}
