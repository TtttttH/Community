package com.achui.community.dao;

import com.achui.community.CommunityApplication;
import com.achui.community.entity.DiscussPost;
import com.achui.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MapperTests {

    private UserMapper userMapper;

    private DiscussPostMapper discussPostMapper;

    @Autowired
    public void setUserMapper(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Autowired
    public void setDiscussPostMapper(DiscussPostMapper discussPostMapper) {this.discussPostMapper = discussPostMapper;}

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(101);
        System.out.println(user);

        user = userMapper.selectByName("liubei");
        System.out.println(user);

        user = userMapper.selectByEmail("nowcoder101@sina.com");
        System.out.println(user);
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("Eurus");
        user.setPassword("12141025");
        user.setSalt("abc");
        user.setEmail("htong10@sheffield.ac.uk");
        user.setHeaderUrl("http://images.nowcoder.com/head/100t.png");
        user.setCreateTime(new Date());

        int row = userMapper.insertUser(user);
        System.out.println(row);
        System.out.println(user.getId());
    }

    @Test
    public void testSelectDiscussPost() {
        int userId = 101;
//        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(101, 0, 10);
        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0 ,10);
        for (DiscussPost post : list) {
            System.out.println(post);
        }
    }

    @Test
    public void testSelectDiscussPostRows() {
//        int userId = 101;
        int userId = 0;
        int rows = discussPostMapper.selectDiscussPostRows(userId);
        System.out.println(rows);
    }
}
