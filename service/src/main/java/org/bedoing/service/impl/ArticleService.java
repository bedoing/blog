package org.bedoing.service.impl;

import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.bedoing.constant.MapperConstant;
import org.bedoing.entity.*;
import org.bedoing.mybatis.MyBatisDAO;
import org.bedoing.repository.*;
import org.bedoing.service.IArticleService;
import org.bedoing.service.utils.Convertor;
import org.bedoing.util.CollectionUtils;
import org.bedoing.util.DateUtils;
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
	private static final Logger log = Logger.getLogger(ArticleService.class);

	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private TagRepository tagRepository;
	@Autowired
	private ArticleTagsRepository articleTagsRepository;
	@Autowired
	private ClicksRepository clicksRepository;
	@Autowired
	private SubjectRepository subjectRepository;
	@Autowired
	private TagService tagService;

	@Override
	public Article addArticle(ArticleVO articleVO) {
		Article a = Convertor.articleVo2Po(articleVO);
		a.setCreateTime(DateUtils.getTimeImMillis(new Date()));
		a.setLastUpdTime(a.getCreateTime());

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
				tagService.saveArticleTag(at);
			}
		}
		
		Clicks c = new Clicks();
		c.setArticleId(a.getArticleId());
		c.setClicks(1);
		saveClicks(c);
		
		return a;
	}

	@Override
	public void deleteArticleById(int articleId) {
		tagService.deleteArticleTagByArticleId(articleId);
		deleteClicksByArticleId(articleId);
		
		articleRepository.delete(articleId);
	}

	@Override
	public Article updateArticle(ArticleVO articleVO) {
		Article a = Convertor.getArticleUpdateFromVo(articleVO);
		
		myBatisDAO.update(MapperConstant.ARTICLE_updateArticle, articleVO);

		tagService.deleteArticleTagByArticleId(a.getArticleId());
		
		if(StringUtils.isNotBlank(articleVO.getTags())) {
			String[] tags = articleVO.getTags().split(",");
			Arrays.stream(tags).forEach(id -> {
				if(StringUtils.isNotBlank(id)) {
					int tagId = Integer.parseInt(id);
					tagService.saveArticleTag(new ArticleTags(a.getArticleId(), tagId));
				}
			});
		}
		return articleVO.getArticleId();
	}

	@Override
	public int countArticlesByCriteria(ArticleVO articleVo) {
		Object count = myBatisDAO.get(MapperConstant.ARTICLE_countArticlesByCriteria, articleVo);
		return (Integer) (count== null || (Integer)count == 0? 0:count);
	}
	
	@Override
	public List<ArticleVO> findArticlesByCriteria(ArticleVO articleVo) {
		List<Article> list = myBatisDAO.getList(MapperConstant.ARTICLE_findArticleByCriteria, articleVo);
		
		return convertArticles2SimpleVOList(list);
	}

	@Override
	public ArticleVO findArticleById(int articleId) {
		ArticleVO vo = new ArticleVO();
		vo.setArticleId(articleId);
		Article a = articleRepository.findOne(articleId);
		if(a == null) {
			return null;
		}else{
			return convertArticleVo2Po(a);
		}
	}

	@Override
	public int countArticlesByTagId(TagsVO tagVO) {
		Object count = myBatisDAO.get(MapperConstant.ARTICLE_countArticlesByTagId, tagVO);
		return (Integer) (count== null || (Integer)count == 0? 0:count);
	}
	
	@Override
	public List<ArticleVO> findArticlesByTagId(TagsVO tagVO) {
		List<Article> list = myBatisDAO.getList(MapperConstant.ARTICLE_findArticlesByTag, tagVO);
		
		return convertArticles2SimpleVOList(list);
	}
	
	private ArticleVO convertArticleVo2Po(Article a) {
		if(a == null) {
			throw new NullPointerException("空对象不能转换。");
		}
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
//		vo.setCreateTimeStcountArticlesByCriteriatr(DateUtils.toBeijinDate(a.getLastUpdTime(), Constant.YYYY_MM_DD));
		
		List<ArticleTags> tags = findArticleTagsByArticleId(a.getArticleId());
		if(a.getArticleType() == 2) {
			// subject
//			Subject s = findSubjectByArticleId(a.getArticleId());

			// TODO
//			vo.setSubject(s);
		}
		
		String tagIdStr = "";
		/*for (ArticleTags articleTags : tags) {
			tagIdStr += articleTags.getTagId() + ",";
		}
		vo.setTags(tagIdStr);*/
		for (ArticleTags articleTags : tags) {
			Tag t = new Tag();
			t.setTagId(articleTags.getTagId());
			// TODO
			Tag tag = tagRepository.findOne(t.getTagId());
			t.setTagName(tag == null? "NULL":tag.getTagName());

			// TODO
//			vo.getTagList().add(t);
		}
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

			List<ArticleTags> tags = findArticleTagsByArticleId(a.getArticleId());

			if(CollectionUtils.isNotEmpty(tags)) {
				tags.forEach(at -> {
					Tag tag = tagRepository.findOne(at.getTagId());
					if(tag != null) {
						vo.getTagList().add(Convertor.tagPo2Vo(tag));
					}
				});
			}

			result.add(vo);
		});

		return result;
	}

	// TODO
	private List<ArticleVO> convertArticles2FullVOList(List<Article> list) {
		List<ArticleVO> result = Lists.newArrayList();

		list.forEach(a -> {
			ArticleVO vo = new ArticleVO();
			vo.setArticleId(a.getArticleId());
			vo.setTitle(a.getTitle());
			vo.setArticleType(a.getArticleType());
			vo.setSummary(a.getSummary());
//			vo.setContent(a.getContent());
			vo.setCreateBy(a.getCreateBy());
			vo.setCreateTime(a.getCreateTime());
			vo.setLastUpdBy(a.getLastUpdBy());
			vo.setLastUpdTime(a.getLastUpdTime());
//			vo.setCreateTimeStr(DateUtils.toBeijinDate(a.getCreateTime(), Constant.YYYY_MM_DD));
//			vo.setLastUpdTimeStr(DateUtils.toBeijinDate(a.getLastUpdTime(), Constant.YYYY_MM_DD));

			List<ArticleTags> tags = findArticleTagsByArticleId(a.getArticleId());
			if(a.getArticleType() == 2) {
				// subject
//				Subject s = findSubjectByArticleId(a.getArticleId());
				// TODO
//				vo.setSubject(s);
			}

			String tagIdStr = "";
			/*for (ArticleTags articleTags : tags) {
				tagIdStr += articleTags.getTagId() + ",";
			}
			vo.setTags(tagIdStr);*/
			for (ArticleTags articleTags : tags) {
				Tag t = new Tag();
				t.setTagId(articleTags.getTagId());
				// TODO
				Tag tag = tagRepository.findOne(t.getTagId());
				t.setTagName(tag == null? "NULL":tag.getTagName());

				// TODO
//				vo.getTagList().add(t);
			}

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

	@Override
	public Article findArticleByTitle(String title) {
		if(StringUtils.isBlank(title)) {
			// TODO
			return null;
		}
		return articleRepository.findByTitle(title);
	}

	@Override
	public List<ArticleVO> findArticlesOrderByClicks(ArticleVO articleVo) {
		List<Article> list = myBatisDAO.getList("findArticlesOrderByClicks", articleVo);
		
		return convertArticle2VOListSimple(list);
	}

	@Override
	public List<ArticleTags> findArticleTagsByArticleId(int articleId) {
		return articleTagsRepository.findByArticleId(articleId);
	}

}
