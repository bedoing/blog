package org.bedoing.blog.system;

import java.util.List;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.bedoing.blog.commons.DictParam;
import org.bedoing.blog.po.Dict;
import org.bedoing.blog.service.IArticleService;
import org.bedoing.blog.service.ICommonService;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 * @author Ken
 *
 */
@Component
public class SystemListenerProcessor implements ApplicationListener<ContextRefreshedEvent> {
	private static final Logger log = Logger.getLogger(SystemListenerProcessor.class); 
	
	@Resource
	private ICommonService commonService;
	@Resource
	private IArticleService articleService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent context) {
		log.info("SystemProcessor ................, context.getApplicationContext(): " + context.getApplicationContext());
		
		if(context.getApplicationContext().getParent() == null){
			List<Dict> dictList = commonService.findAllDict();
			log.info(dictList.size());
			
			for (Dict d : dictList) {
				DictParam.put(d.getDictType() + d.getDictKey(), d.getDictValue());
			}
			
			initTagsDict();
		}
	}
	
	// TODO Tags Init
	private void initTagsDict(){
		articleService.initTagDict();
	}
}
