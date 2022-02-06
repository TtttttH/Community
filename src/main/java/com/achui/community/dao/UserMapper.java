package com.achui.community.dao;

import com.achui.community.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author Eurus
 */
@Mapper
public interface UserMapper {

    /**
     * 根据id查询用户信息
     * @param id 用户id
     * @return User
     */
    User selectById(int id);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return User
     */
    User selectByName(String username);

    /**
     * 根据邮箱查询用户信息
     * @param email 邮箱
     * @return User
     */
    User selectByEmail(String email);

    /**
     * 新增用户
     * @param user User 对象
     * @return int
     */
    int insertUser(User user);

    /**
     * 更新账户激活状态
     * @param id 用户id
     * @param status 状态
     * @return int
     */
    int updateStatus(int id, int status);

    /**
     * 更新用户头像url
     * @param id 用户id
     * @param headerUrl 头像url
     * @return int
     */
    int updateHeader(int id, String headerUrl);

    /**
     * 更新密码
     * @param id 用户id
     * @param password new password
     * @return int
     */
    int updatePassword(int id, String password);
}
