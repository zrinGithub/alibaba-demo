package com.zr.user.service;

import com.zr.user.dao.po.UserDo;
import com.zr.video.entity.vo.UserVo;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/17 14:38
 */
public interface UserService {
    int insert(UserVo userVo);
}
