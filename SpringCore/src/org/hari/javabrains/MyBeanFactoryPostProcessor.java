package org.hari.javabrains;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) 
			throws BeansException { //this method gets called before bean factory itself gets initialized

		System.out.println("My Bean Factory Post Processor is called");
		
	}

}
