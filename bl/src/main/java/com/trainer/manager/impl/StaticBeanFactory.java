package com.trainer.manager.impl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("StaticFactory")
@Scope("singleton")
public class StaticBeanFactory implements BeanFactoryAware{

	protected static BeanFactory CONTEXT;

	public static <T> T getBean(Class<T> tClass) throws BeansException {
		return CONTEXT == null ? null : CONTEXT.getBean(tClass);
	}

	@Override
	public void setBeanFactory(BeanFactory applicationContext) throws BeansException {
		CONTEXT = applicationContext;
	}
}
