package com.zr.user.service.impl;

import com.zr.user.dao.UserMapper;
import com.zr.user.dao.po.UserDo;
import com.zr.user.service.UserService;
import com.zr.video.entity.vo.UserVo;
import com.zr.video.util.SpringBeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/17 14:48
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public int insert(UserVo userVo) {
        if (userVo.getId().equals(1))
            throw new RuntimeException();
        return userMapper.insert(SpringBeanUtils.copyProperties(userVo, UserDo.class));
    }
}
