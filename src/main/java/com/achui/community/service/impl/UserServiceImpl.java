package com.achui.community.service.impl;

import com.achui.community.dao.UserMapper;
import com.achui.community.entity.User;
import com.achui.community.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author achui
 */
@Service
public class UserServiceImpl implements UserService {

    private UserMapper userMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User findUserById(int id) {
        return userMapper.selectById(id);
    }
}
