package com.zr.video.dao;

import com.zr.video.dao.po.VideoDo;
import org.apache.ibatis.annotations.*;

/**
 * Description:
 *
 * @author zhangr
 * 2020/10/21 11:07
 */
@Mapper
public interface VideoMapper {
    @Select("select * from video where id=#{id}")
    VideoDo getById(@Param("id") String id);

    @Insert("INSERT INTO `video`(`id`, `title`, `summary`, `cover_img`, `price`, `create_time`, `point`) " +
            "VALUES " +
            "(#{id}, #{title}, #{summary}, #{coverImg}, #{price}, #{createTime}, #{point})")
    int insert(VideoDo videoDo);
}
