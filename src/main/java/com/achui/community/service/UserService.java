package com.achui.community.service;

import com.achui.community.entity.User;

/**
 * @author achui
 */
public interface UserService {

    /**
     * 根据用户id查询用户
     * @param id Primary key
     * @return User
     */
    User findUserById(int id);

}
