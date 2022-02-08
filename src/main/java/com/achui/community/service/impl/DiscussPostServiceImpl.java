package com.achui.community.service.impl;

import com.achui.community.dao.DiscussPostMapper;
import com.achui.community.entity.DiscussPost;
import com.achui.community.service.DiscussPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author achui
 */
@Service
public class DiscussPostServiceImpl implements DiscussPostService {

    private DiscussPostMapper discussPostMapper;

    @Autowired
    public void setDiscussPostServiceImpl(DiscussPostMapper discussPostMapper) {
        this.discussPostMapper = discussPostMapper;
    }

    @Override
    public List<DiscussPost> findDiscussPosts(int usedId, int offset, int limit) {
        return discussPostMapper.selectDiscussPosts(usedId, offset, limit);
    }

    @Override
    public int findDiscussPostRows(int userId) {
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
