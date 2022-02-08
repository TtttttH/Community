package com.achui.community.service;

import com.achui.community.entity.DiscussPost;

import java.util.List;

/**
 * @author achui
 */
public interface DiscussPostService {
    /**
     * 查询帖子列表
     * @param usedId 用户id
     * @param offset 起始行
     * @param limit 查询条数限制
     * @return List
     */
    List<DiscussPost> findDiscussPosts(int usedId, int offset, int limit);

    /**
     * 查询帖子数
     * @param userId 用户id
     * @return rows count
     */
    int findDiscussPostRows(int userId);
}
