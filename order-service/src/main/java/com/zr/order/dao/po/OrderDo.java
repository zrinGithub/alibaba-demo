package com.zr.order.dao.po;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * Description:
 *
 * @author zhangr
 * 2020/11/16 15:38
 */
@Data
public class OrderDo implements Serializable {
    private static final long serialVersionUID = -9058783162516863807L;

    /**
     * 视频ID
     */
    private Integer id;
    /**
     * 订单唯一标识
     */
    private String outTradeNo;
    /**
     * 0表示未支付，1表示已支付
     */
    private Integer state;
    /**
     * 订单生成时间
     */
    private LocalDateTime createTime;
    /**
     * 支付金额，单位分
     */
    private Integer totalFee;
    /**
     * 视频主键
     */
    private Integer videoId;
    /**
     * 视频标题
     */
    private String videoTitle;
    /**
     * 视频图片
     */
    private String videoImg;
    /**
     * 用户id
     */
    private Integer userId;
}
