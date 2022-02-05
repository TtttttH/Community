package com.achui.community.service.impl;

import com.achui.community.dao.AlphaDao;
import com.achui.community.service.AlphaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaServiceImpl implements AlphaService {

    @Autowired
    @Qualifier("alphaMybatis")
    private AlphaDao alphaDao;

    public AlphaServiceImpl() {
        System.out.println("实例化AlphaService");
    }

    @Override
    @PostConstruct
    public void init() {
        System.out.println("初始化AlphaService");
    }

    @Override
    @PreDestroy
    public void destroy() {
        System.out.println("摧毁AlphaService");
    }

    @Override
    public String find() {
        return alphaDao.select();
    }
}
