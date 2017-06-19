package com.transData.business.util;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.creditapp.test.springconfig.TestServiceSpringConfig;

public class BusinessBeanFactory {
	private static AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(TestServiceSpringConfig.class);

	public static <T> T getGenericityBeanFromSpringBean(Class<T> clazz){
		return context.getBean(clazz);
	}
	
	public static Object getBeanFromSpringBean(String beanName){
		return context.getBean(beanName);
	}
}
