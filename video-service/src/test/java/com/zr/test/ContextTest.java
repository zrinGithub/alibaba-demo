package com.zr.test;

import com.zr.video.VideoApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.Resource;

/**
 * Description:
 *
 * @author zhangr
 * 2023/2/21 14:42
 */
@SpringBootTest(classes = {VideoApplication.class})
public class ContextTest {
    @Resource
    private ConfigurableApplicationContext context;

    @Test
    public void test1() {
        context.refresh();
    }
}
