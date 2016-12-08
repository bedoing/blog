package org.bedoing.service;

import org.bedoing.entity.Clicks;

public interface IClicksService {

	Clicks saveClicks(Clicks click);

	int getClicks(Integer articleId);

	Clicks updateClicks(Clicks click);

	void deleteClicksByArticleId(Integer articleId);
}
