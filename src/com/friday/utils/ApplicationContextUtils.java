package com.friday.utils;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
	private static ClassPathXmlApplicationContext cpxac = new ClassPathXmlApplicationContext("applicationContext.xml");

	public static Object getBean(String beanName) {

		return cpxac.getBean(beanName);
	}
}