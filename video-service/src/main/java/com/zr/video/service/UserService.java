package com.zr.video.service;

import com.zr.video.entity.vo.UserVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/17 14:54
 */
@FeignClient(value = "user-service")
public interface UserService {
    @PostMapping("/user/insert")
    int insert(@RequestBody UserVo userVo);
}
