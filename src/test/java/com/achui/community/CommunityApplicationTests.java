package com.achui.community;

import com.achui.community.dao.AlphaDao;
import com.achui.community.service.AlphaService;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	@Qualifier("BetaDaoImpl")
	private AlphaDao alphaDao;

	@Autowired
	private AlphaService alphaService;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	@Ignore
	void contextLoads() {
		System.out.println(applicationContext);
	}

	@Test
	void testApplicationContext() {
		System.out.println(applicationContext);
		System.out.println(alphaDao.select());
	}

	@Test
	void testBeanConfig() {
		System.out.println(simpleDateFormat.format(new Date()));
	}
}
