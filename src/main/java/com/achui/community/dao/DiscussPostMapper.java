package com.achui.community.dao;

import com.achui.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author achui
 */
@Mapper
public interface DiscussPostMapper {

    /**
     * 查询评论列表
     * @param userId 用户id
     * @param offset 其实行号
     * @param limit 每页多少行
     * @return List<DiscussPost>
     */
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    /**
     * 查询评论条数
     * @param userId 用户id
     * @return int
     */
    int selectDiscussPostRows(@Param("userId") int userId); //@Param注解用于给参数取别名，如果只有一个参数，且在mapperXml中有动态查询<if>，则必须加别名
}
