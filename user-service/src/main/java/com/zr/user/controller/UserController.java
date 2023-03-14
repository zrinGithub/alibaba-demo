package com.zr.user.controller;

import com.zr.user.service.UserService;
import com.zr.video.entity.vo.UserVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/17 14:50
 */
@RestController
@RequestMapping("user")
public class UserController {
    @Resource
    private UserService userService;

    @PostMapping("insert")
    public int insert(@RequestBody UserVo userVo) {
        return userService.insert(userVo);
    }
}
