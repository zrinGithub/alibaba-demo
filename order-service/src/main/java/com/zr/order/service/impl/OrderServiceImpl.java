package com.zr.order.service.impl;

import com.zr.order.dao.OrderMapper;
import com.zr.order.dao.po.OrderDo;
import com.zr.order.service.OrderService;
import com.zr.order.service.VideoService;
import com.zr.video.entity.vo.VideoVo;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

/**
 * Description:
 *
 * @author zhangr
 * 2020/10/21 11:36
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Resource
    private RestTemplate restTemplate;

    @Resource
    private DiscoveryClient discoveryClient;

    @Resource
    private VideoService videoService;

    @Resource
    private OrderMapper orderMapper;

    @Override
    public VideoVo create(String videoId) {
        VideoVo videoVo = restTemplate.getForObject("http://video-service/video/getById?id=" + videoId, VideoVo.class);

        List<ServiceInstance> instances = discoveryClient.getInstances("video-service");
        List<String> services = discoveryClient.getServices();
        return videoVo;
    }

    @Override
    @GlobalTransactional
    public int commit(Integer videoId) {
        OrderDo orderDo = new OrderDo();
        orderDo.setOutTradeNo(UUID.randomUUID().toString().replace("-", ""));
        orderDo.setVideoId(videoId);
        int insert = orderMapper.insert(orderDo);
        VideoVo videoVo = new VideoVo();
        videoVo.setId(videoId);
        videoVo.setTitle("用户自定义商品");
        videoService.insert(videoVo);
        return insert;
    }
}
