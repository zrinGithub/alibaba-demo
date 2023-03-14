package com.zr.video.service.impl;

import com.zr.video.dao.VideoMapper;
import com.zr.video.dao.po.VideoDo;
import com.zr.video.entity.vo.UserVo;
import com.zr.video.entity.vo.VideoVo;
import com.zr.video.service.UserService;
import com.zr.video.service.VideoService;
import com.zr.video.util.SpringBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2020/10/21 11:11
 */
@Service
public class VideoServiceImpl implements VideoService {
    @Resource
    private VideoMapper videoMapper;
    @Resource
    private UserService userService;

    @Override
    public VideoVo getById(String id) {
        return SpringBeanUtils.copyProperties(videoMapper.getById(id), VideoVo.class);
    }

    @Override
    public int insert(VideoVo videoVo) {
        int insert = videoMapper.insert(SpringBeanUtils.copyProperties(videoVo, VideoDo.class));
        UserVo userVo = new UserVo();
        userVo.setId(videoVo.getId());
        userVo.setPhone("12345678901");
        userService.insert(userVo);

        return insert;
    }
}
