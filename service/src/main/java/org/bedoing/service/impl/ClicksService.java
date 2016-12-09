package org.bedoing.service.impl;

import org.apache.log4j.Logger;
import org.bedoing.constant.TableAttrConstant;
import org.bedoing.entity.Clicks;
import org.bedoing.mybatis.MyBatisDAO;
import org.bedoing.repository.ClicksRepository;
import org.bedoing.service.IClicksService;
import org.bedoing.util.ValidateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class ClicksService implements IClicksService {
	private static final Logger log = Logger.getLogger(ArticleService.class);

	@Autowired
	private MyBatisDAO myBatisDAO;
	@Autowired
	private ClicksRepository clicksRepository;

	@Override
	public int getClicks(Integer articleId) {
		ValidateUtils.validateArticleId(articleId);
		Clicks clicks = clicksRepository.findByArticleId(articleId);
		return clicks == null? 0:clicks.getClicks();
	}

	@Override
	public Clicks updateClicks(Clicks click) {
		ValidateUtils.validateObject(TableAttrConstant.CLICKS, click);
		ValidateUtils.validateId(click.getId());
		ValidateUtils.validateArticleId(click.getArticleId());
		return clicksRepository.save(click);
	}

	@Override
	public Clicks saveClicks(Clicks click) {
		ValidateUtils.validateObject(TableAttrConstant.CLICKS, click);
		return clicksRepository.save(click);
	}

	@Override
	public void deleteClicksByArticleId(Integer articleId) {
		ValidateUtils.validateArticleId(articleId);
		clicksRepository.deleteByArticleId(articleId);
	}
}
