package com.zr.order.dao;

import com.zr.order.dao.po.OrderDo;
import org.apache.ibatis.annotations.*;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/16 15:35
 */
@Mapper
public interface OrderMapper {
    @Insert("INSERT INTO `video_order`(`out_trade_no`, `state`, `create_time`, `total_fee`, `video_id`, `video_title`, `video_img`, `user_id`) " +
            "VALUES " +
            "(#{outTradeNo}, #{state}, #{createTime}, #{totalFee}, #{videoId}, #{videoTitle}, #{videoImg}, #{userId})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(OrderDo orderDo);
}
