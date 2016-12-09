package org.bedoing.service.utils;

import org.bedoing.entity.Article;
import org.bedoing.entity.LoginAccount;
import org.bedoing.entity.Tag;
import org.bedoing.security.EndecryptUtil;
import org.bedoing.vo.ArticleVO;
import org.bedoing.vo.LoginAccountVO;
import org.bedoing.vo.TagsVO;
import org.bedoing.vo.UserRegVO;

import java.util.Date;

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

    public static LoginAccount userRegVo2Po(UserRegVO vo) {
        LoginAccount loginAccount = new LoginAccount();

        loginAccount.setAccountName(vo.getLoginAccount());
        loginAccount.setPassword(EndecryptUtil.decrypt(vo.getPassword()));
        loginAccount.setRole(vo.getRole());
        loginAccount.setMobilePhone(vo.getMobilePhone());
        loginAccount.setSex(vo.getSex());
        loginAccount.setNickname(vo.getNickname());
        loginAccount.setHeadImgUrl(vo.getHeadimgurl());
        loginAccount.setCountry(vo.getCountry());
        loginAccount.setCity(vo.getCity());
        loginAccount.setProvince(vo.getProvince());
        loginAccount.setCreateTime(vo.getCreateTime());
        loginAccount.setStatus(vo.getStatus());

        return loginAccount;
    }

    private Convertor(){}
}
