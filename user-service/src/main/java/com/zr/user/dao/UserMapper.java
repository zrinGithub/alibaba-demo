package com.zr.user.dao;

import com.zr.user.dao.po.UserDo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/17 14:40
 */
@Mapper
public interface UserMapper {
    @Insert("INSERT INTO `user` ( `id`, `phone`, `pwd`, `sex`, `img`, `create_time`, `role`, `username`, `wechat` )\n" +
            "VALUES" +
            "( #{id}, #{phone}, #{pwd}, #{sex}, #{img}, #{createTime}, #{role}, #{username}, #{wechat} )")
    int insert(UserDo videoDo);
}
