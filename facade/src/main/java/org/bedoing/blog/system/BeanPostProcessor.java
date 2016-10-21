package org.bedoing.blog.system;

import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * 
 * @author ken
 *
 */
public class BeanPostProcessor implements BeanFactoryPostProcessor {
	private static final Logger log = Logger.getLogger(BeanPostProcessor.class); 
	
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		log.info("BeanPostProcessor ................, beanFactory.getParentBeanFactory(): " + beanFactory.getParentBeanFactory());
		if(beanFactory.getParentBeanFactory() == null){
			/*SocketUtil.getInstance();
			SocketUtil.getSocket();
			SocketUtil.getInstance();*/
		}
	}

}
