package org.bedoing.service.impl;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.bedoing.constant.MapperConstant;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.Article;
import org.bedoing.entity.ArticleTags;
import org.bedoing.entity.Clicks;
import org.bedoing.entity.Tag;
import org.bedoing.mybatis.MyBatisDAO;
import org.bedoing.repository.ArticleRepository;
import org.bedoing.service.IArticleService;
import org.bedoing.service.utils.Convertor;
import org.bedoing.util.DateUtils;
import org.bedoing.util.ValidateUtils;
import org.bedoing.vo.ArticleVO;
import org.bedoing.vo.TagsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class ArticleService implements IArticleService {

	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private ArticleRepository articleRepository;

	@Autowired
	private TagService tagService;
    @Autowired
    private ArticleTagsService articleTagsService;
    @Autowired
    private ClicksService clicksService;

	@Override
	public Article addArticle(ArticleVO articleVO) {
        ValidateUtils.validateObject(TableAttrConstant.ARTICLE, articleVO);
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TITLE, articleVO.getTitle());
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_TYPE, articleVO.getArticleType());
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.CONTENT, articleVO.getContent());

        articleVO.setArticleId(null);
		Article a = Convertor.articleVo2Po(articleVO);
		a.setCreateTime(DateUtils.getTimeImMillis(new Date()));
		a.setLastUpdTime(a.getCreateTime());
        // TODO
        a.setCreateBy("ken");
        a.setLastUpdBy("ken");

		a = articleRepository.save(a);
		
		ArticleTags at = new ArticleTags();
		at.setArticleId(a.getArticleId());
		String tagStr = articleVO.getTags();
		if(StringUtils.isNotBlank(tagStr)) {
			tagStr = tagStr.trim();
			if(tagStr.lastIndexOf(",") == tagStr.length() - 1) {
				tagStr = tagStr.substring(0, tagStr.length() - 1);
			}
			for (String tagId : tagStr.split(",")) {
				at.setTagId(Integer.parseInt(tagId));
                articleTagsService.saveArticleTag(at);
			}
		}
		
		Clicks c = new Clicks();
		c.setArticleId(a.getArticleId());
		c.setClicks(1);
        clicksService.saveClicks(c);
		
		return a;
	}

	@Override
	public void deleteArticleById(Integer articleId) {
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleId);

		articleTagsService.deleteArticleTagByArticleId(articleId);
		clicksService.deleteClicksByArticleId(articleId);
		articleRepository.delete(articleId);
	}

	@Override
	public ArticleVO updateArticle(ArticleVO articleVO) {
        ValidateUtils.validateObject(TableAttrConstant.ARTICLE, articleVO);
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleVO.getArticleId());
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TITLE, articleVO.getTitle());
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_TYPE, articleVO.getArticleType());
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.CONTENT, articleVO.getContent());

		Article a = Convertor.getArticleUpdateFromVo(articleVO);
		
		myBatisDAO.update(MapperConstant.ARTICLE_updateArticle, articleVO);

		articleTagsService.deleteArticleTagByArticleId(a.getArticleId());
		
		if(StringUtils.isNotBlank(articleVO.getTags())) {
			String[] tags = articleVO.getTags().split(",");
			Arrays.stream(tags).forEach(id -> {
				if(StringUtils.isNotBlank(id)) {
					Integer tagId = Integer.parseInt(id);
					articleTagsService.saveArticleTag(new ArticleTags(a.getArticleId(), tagId));
				}
			});
		}
		return articleVO;
	}

	@Override
	public int countArticlesByCriteria(ArticleVO articleVO) {
        ValidateUtils.validateObject(TableAttrConstant.ARTICLE, articleVO);

		Object count = myBatisDAO.get(MapperConstant.ARTICLE_countArticlesByCriteria, articleVO);
		return (Integer) (count== null || (Integer)count == 0? 0:count);
	}
	
	@Override
	public List<ArticleVO> findSimpleArticlesByCriteria(ArticleVO articleVO) {
        ValidateUtils.validateObject(TableAttrConstant.ARTICLE, articleVO);

		List<Article> result = myBatisDAO.getList(MapperConstant.ARTICLE_findArticleByCriteria, articleVO);
        if(org.apache.cxf.common.util.CollectionUtils.isEmpty(result)) {
            ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE, articleVO.toString());
        }
		return convertArticles2SimpleVOList(result);
	}

	@Override
	public ArticleVO findArticleById(Integer articleId) {
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_ID, articleId);

		Article a = articleRepository.findOne(articleId);

        ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE, String.valueOf(articleId));

        return convertArticleVo2Po(a);
	}

	@Override
	public int countArticlesByTagId(TagsVO tagVO) {
        ValidateUtils.validateObject(TableAttrConstant.TAG, tagVO);
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TAG_ID, tagVO.getTagId());

		Object count = myBatisDAO.get(MapperConstant.ARTICLE_countArticlesByTagId, tagVO);
		return count== null || (Integer)count == 0? 0: (int) count;
	}
	
	@Override
	public List<ArticleVO> findArticlesByTagId(TagsVO tagVO) {
		List<Article> result = myBatisDAO.getList(MapperConstant.ARTICLE_findArticlesByTag, tagVO);

        if(org.apache.cxf.common.util.CollectionUtils.isEmpty(result)) {
            ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE, tagVO.toString());
        }

		return convertArticles2SimpleVOList(result);
	}

    @Override
    public Article findArticleByTitle(String title) {
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.TITLE, title);

        Article article = articleRepository.findByTitle(title);
        if(article == null) {
            ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE, title);
        }
        return article;
    }

    @Override
    public List<ArticleVO> findArticlesOrderByClicks(ArticleVO articleVO) {
        ValidateUtils.validateObject(TableAttrConstant.ARTICLE, articleVO);
        ValidateUtils.validateRequestParameterIsRequired(TableAttrConstant.ARTICLE_TYPE, articleVO.getArticleType());
        List<Article> result = myBatisDAO.getList(MapperConstant.ARTICLE_findArticlesOrderByClicks, articleVO);

        if(org.apache.cxf.common.util.CollectionUtils.isEmpty(result)) {
            ValidateUtils.recordNotExistException(TableAttrConstant.ARTICLE, articleVO.toString());
        }

        return convertArticle2VOListSimple(result);
    }
	
	private ArticleVO convertArticleVo2Po(Article a) {
		ArticleVO vo = new ArticleVO();
		vo.setArticleId(a.getArticleId());
		vo.setTitle(a.getTitle());
		vo.setArticleType(a.getArticleType());
		vo.setSummary(a.getSummary());
		vo.setContent(a.getContent());
		vo.setCreateBy(a.getCreateBy());
		vo.setCreateTime(a.getCreateTime());
		vo.setLastUpdBy(a.getLastUpdBy());
		vo.setLastUpdTime(a.getLastUpdTime());
		
		List<ArticleTags> articleTagses = articleTagsService.findArticleTagsByArticleId(a.getArticleId());

        articleTagses.forEach(articleTag -> {
            Tag tag = tagService.findTagById(articleTag.getTagId());

            vo.getTagList().add(new TagsVO(articleTag.getTagId(), tag.getTagName(), tag.getTagType()));
        });

		return vo;
	}
	
	private List<ArticleVO> convertArticles2SimpleVOList(List<Article> list) {
		List<ArticleVO> result = Lists.newArrayList();

		list.forEach(a -> {
			ArticleVO vo = new ArticleVO();
			vo.setArticleId(a.getArticleId());
			vo.setTitle(a.getTitle());
			vo.setArticleType(a.getArticleType());
			vo.setSummary(a.getSummary());
			vo.setCreateBy(a.getCreateBy());
			vo.setCreateTime(a.getCreateTime());
			vo.setLastUpdBy(a.getLastUpdBy());
			vo.setLastUpdTime(a.getLastUpdTime());

			List<ArticleTags> tags = articleTagsService.findArticleTagsByArticleId(a.getArticleId());

            tags.forEach(at -> {
                Tag tag = tagService.findTagById(at.getTagId());
                vo.getTagList().add(new TagsVO(tag.getTagId(), tag.getTagName(), tag.getTagType()));
            });

			result.add(vo);
		});

		return result;
	}
	
	private List<ArticleVO> convertArticle2VOListSimple(List<Article> list) {
		List<ArticleVO> result = new ArrayList<ArticleVO>();
		
		for (Article a : list) {
			ArticleVO vo = new ArticleVO();
			vo.setArticleId(a.getArticleId());
			vo.setTitle(a.getTitle());
			vo.setArticleType(a.getArticleType());
			vo.setSummary(a.getSummary());
			vo.setContent(a.getContent());
			vo.setCreateBy(a.getCreateBy());
			vo.setCreateTime(a.getCreateTime());
			vo.setLastUpdBy(a.getLastUpdBy());
			vo.setLastUpdTime(a.getLastUpdTime());
			
			result.add(vo);
		}
		return result;
	}
}
