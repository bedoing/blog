package org.bedoing.blog.service.impl;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.bedoing.blog.commons.TagsDict;
import org.bedoing.blog.constant.Constant;
import org.bedoing.blog.constant.MapperConstant;
import org.bedoing.blog.entity.*;
import org.bedoing.blog.mybatis.MyBatisDAO;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.service.ICommentService;
import org.bedoing.blog.util.DateUtils;
import org.bedoing.blog.vo.ArticleVO;
import org.bedoing.blog.vo.TagsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Service
public class ArticleService implements IArticleService {
	private static final Logger log = Logger.getLogger(ArticleService.class);

	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private ICommentService commentService;

	@Override
	public int addArticle(ArticleVO articleVO) {
		Article a = new Article();
		a.setTitle(articleVO.getTitle());
		a.setArticleType(articleVO.getArticleType());
		a.setSummary(articleVO.getSummary());
		a.setContent(articleVO.getContent());
		a.setCreateBy(articleVO.getCreateBy());
		a.setLastUpdBy(articleVO.getCreateBy());
		a.setCreateTime(DateUtils.getTimeImMillis(new Date()));
		a.setLastUpdTime(a.getCreateTime());
		a.setArticleType(articleVO.getArticleType());
		
		log.info(JSON.toJSONString(a));
		myBatisDAO.save(MapperConstant.ARTICLE_addArticle, a);
		log.info("articleId: " + a.getArticleId());
		
		if(a.getArticleType() == 2) {
			Subject s = new Subject();
			s.setArticleId(articleVO.getArticleId());
			s.setDifficulty(articleVO.getSubject().getDifficulty());
			s.setTimeLimit(articleVO.getSubject().getTimeLimit());
			s.setMemoryLimit(articleVO.getSubject().getMemoryLimit());
			s.setOtherLimit(articleVO.getSubject().getOtherLimit());
			
			addSubject(s);
		}
		
		ArticleTags at = new ArticleTags();
		at.setArticleId(a.getArticleId());
		String tagStr = articleVO.getTags();
		if(StringUtils.isNotBlank(tagStr)) {
			tagStr = tagStr.substring(0, tagStr.length() - 1);
			for (String tagId : tagStr.split(",")) {
				at.setTagId(Integer.parseInt(tagId));
				addArticleTag(at);
			}
		}
		
		Clicks c = new Clicks();
		c.setArticleId(a.getArticleId());
		c.setClicks(1);
		addClicks(c);
		
		return a.getArticleId();
	}

	@Override
	public int deleteArticleById(int articleId) {
		// TODO articleTag,clicks,comment,subject
		deleteArticleTagByArticleId(articleId);
		deleteClicksByArticleId(articleId);
		commentService.deleteCommentsByArticleId(articleId);
		deleteSubjectByArticleId(articleId);
		
		return myBatisDAO.delete(MapperConstant.ARTICLE_deleteArticleById, articleId);
	}

	@Override
	public int updateArticle(ArticleVO article) {
		Article a = new Article();
		a.setArticleId(article.getArticleId());
		a.setTitle(article.getTitle());
		a.setSummary(article.getSummary());
		a.setContent(article.getContent());
		
		myBatisDAO.update(MapperConstant.ARTICLE_updateArticle, article);
		// TODO 
		deleteArticleTagByArticleId(a.getArticleId());
		
		if(StringUtils.isNotBlank(article.getTags())) {
			String[] tags = article.getTags().split(",");
			for (String tagId : tags) {
				if(StringUtils.isNotBlank(tagId)) {
					// TODO
					int id = Integer.parseInt(tagId);
					
					addArticleTag(new ArticleTags(a.getArticleId(), id));
				}
			}
		}
		return article.getArticleId();
	}

	@Override
	public int countArticlesByCriteria(ArticleVO articleVo) {
		Object count = myBatisDAO.get(MapperConstant.ARTICLE_countArticlesByCriteria, articleVo);
		return (Integer) (count== null || (Integer)count == 0? 0:count);
	}
	
	@Override
	public List<ArticleVO> findArticlesByCriteria(ArticleVO articleVo) {
		List<Article> list = myBatisDAO.getList(MapperConstant.ARTICLE_findArticleByCriteria, articleVo);
		
		return convertArticle2VOList(list);
	}

	@Override
	public int addTag(Tag tags) {
		myBatisDAO.save(MapperConstant.ARTICLE_addTag, tags);
		initTagDict();
		return tags.getTagId();
	}

	@Override
	public String findTagById(int tagId) {
		String tagName = myBatisDAO.get(MapperConstant.ARTICLE_findTagById, tagId);
		return tagName;
	}

	@Override
	public List<Tag> findAllTags() {
		return myBatisDAO.getList(MapperConstant.ARTICLE_findAllTags);
	}

	@Override
	public int addArticleTag(ArticleTags articleTags) {
		myBatisDAO.save(MapperConstant.ARTICLE_addArticleTag, articleTags);
		// TODO
		return articleTags.getTagId();
	}

	@Override
	public List<ArticleTags> findArticleTagsByArticleId(int articleId) {
		return myBatisDAO.getList(MapperConstant.ARTICLE_findArticleTagsByArticleId, articleId);
	}

	@Override
	public ArticleVO findArticleById(int articleId) {
		ArticleVO vo = new ArticleVO();
		vo.setArticleId(articleId);
		Article a = myBatisDAO.get(MapperConstant.ARTICLE_findArticleById, articleId);
		if(a == null) {
			return null;
		}else{
			return convertArticleVo2Po(a);
		}
	}

	@Override
	public List<TagsVO> tagsGroup(int tagType) {
		List<TagsVO> list = new ArrayList<TagsVO>();
		if(tagType != 0 && tagType != -1) {
			list = myBatisDAO.getList("tagsGroupByTagType", tagType);
		}else {
			list = myBatisDAO.getList(MapperConstant.ARTICLE_tagsGroup);
		}
		
		for (TagsVO r : list) {
			r.setTagName(TagsDict.getTagNameById(r.getTagId()));
		}
		
		return list;
	}

	@Override
	public int countArticlesByTagId(TagsVO tagVO) {
		Object count = myBatisDAO.get(MapperConstant.ARTICLE_countArticlesByTagId, tagVO);
		return (Integer) (count== null || (Integer)count == 0? 0:count);
	}
	
	@Override
	public List<ArticleVO> findArticlesByTagId(TagsVO tagVO) {
		List<Article> list = myBatisDAO.getList(MapperConstant.ARTICLE_findArticlesByTag, tagVO);
		
		return convertArticle2VOList(list);
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
		vo.setCreateTimeStr(DateUtils.toBeijinDate(a.getCreateTime(), Constant.YYYY_MM_DD));
		vo.setLastUpdTimeStr(DateUtils.toBeijinDate(a.getLastUpdTime(), Constant.YYYY_MM_DD));
		
		List<ArticleTags> tags = findArticleTagsByArticleId(a.getArticleId());
		if(a.getArticleType() == 2) {
			// subject
			Subject s = findSubjectByArticleId(a.getArticleId());
			vo.setSubject(s);
		}
		
		String tagIdStr = "";
		/*for (ArticleTags articleTags : tags) {
			tagIdStr += articleTags.getTagId() + ",";
		}
		vo.setTags(tagIdStr);*/
		for (ArticleTags articleTags : tags) {
			Tag t = new Tag();
			t.setTagId(articleTags.getTagId());
			t.setTagName(TagsDict.getTagNameById(t.getTagId()));
			
			vo.getTagList().add(t);
		}
		return vo;
	}
	
	private List<ArticleVO> convertArticle2VOList(List<Article> list) {
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
			vo.setCreateTimeStr(DateUtils.toBeijinDate(a.getCreateTime(), Constant.YYYY_MM_DD));
			vo.setLastUpdTimeStr(DateUtils.toBeijinDate(a.getLastUpdTime(), Constant.YYYY_MM_DD));
			
			List<ArticleTags> tags = findArticleTagsByArticleId(a.getArticleId());
			if(a.getArticleType() == 2) {
				// subject
				Subject s = findSubjectByArticleId(a.getArticleId());
				vo.setSubject(s);
			}
			
			String tagIdStr = "";
			/*for (ArticleTags articleTags : tags) {
				tagIdStr += articleTags.getTagId() + ",";
			}
			vo.setTags(tagIdStr);*/
			for (ArticleTags articleTags : tags) {
				Tag t = new Tag();
				t.setTagId(articleTags.getTagId());
				t.setTagName(TagsDict.getTagNameById(t.getTagId()));
				
				vo.getTagList().add(t);
			}
			
			result.add(vo);
		}
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
			vo.setCreateTimeStr(DateUtils.toBeijinDate(a.getCreateTime(), Constant.YYYY_MM_DD));
			vo.setLastUpdTimeStr(DateUtils.toBeijinDate(a.getLastUpdTime(), Constant.YYYY_MM_DD));
			
			result.add(vo);
		}
		return result;
	}

	@Override
	public void deleteArticleTagByArticleId(int articleId) {
		myBatisDAO.delete(MapperConstant.ARTICLE_deleteArticleTagByArticleId, articleId);
	}

	@Override
	public int getClicks(int articleId) {
		return myBatisDAO.get(MapperConstant.ARTICLE_getClicks, articleId);
	}

	@Override
	public void updateClicks(Clicks click) {
		myBatisDAO.update(MapperConstant.ARTICLE_updateClicks, click);
	}

	@Override
	public void addClicks(Clicks click) {
		myBatisDAO.save(MapperConstant.ARTICLE_addClicks, click);
	}

	@Override
	public Subject findSubjectById(int subjectId) {
		return myBatisDAO.get(MapperConstant.ARTICLE_findSubjectById, subjectId);
	}

	@Override
	public Subject findSubjectByArticleId(int articleId) {
		return myBatisDAO.get(MapperConstant.ARTICLE_findSubjectByArticleId);
	}

	@Override
	public Article findArticleByTitle(String title) {
		return myBatisDAO.get("article.findArticleByTitle", title);
	}

	@Override
	public void deleteClicksByArticleId(int articleId) {
		myBatisDAO.delete("article.deleteClicksByArticleId", articleId);
	}

	@Override
	public List<Tag> findTagsByType(int tagType) {
		List<Tag> result = new ArrayList<Tag>();
		if(tagType == -1) {
			result = myBatisDAO.getList("article.findAllTags");
		}else {
			result = myBatisDAO.getList("article.findTagsByType", tagType);
		}
		return result;
	}

	@Override
	public void deleteSubjectByArticleId(int articleId) {
		myBatisDAO.delete("deleteSubjectByArticleId", articleId);
	}

	@Override
	public int addSubject(Subject subject) {
		myBatisDAO.save("addSubject", subject);
		return subject.getSubjectId();
	}

	@Override
	public int updateSubject(Subject subject) {
		myBatisDAO.update("updateSubject", subject);
		
		return subject.getArticleId();
	}

	@Override
	public void initTagDict() {
		List<Tag> list = findAllTags();
		for (Tag t : list) {
			TagsDict.tagsDict.put(t.getTagId(), t.getTagName());
		}
	}

	@Override
	public List<ArticleVO> findArticlesOrderByClicks(ArticleVO articleVo) {
		List<Article> list = myBatisDAO.getList("findArticlesOrderByClicks", articleVo);
		
		return convertArticle2VOListSimple(list);
	}

}
