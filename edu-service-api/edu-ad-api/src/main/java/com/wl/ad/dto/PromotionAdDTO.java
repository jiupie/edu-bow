package com.wl.ad.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class PromotionAdDTO {
    private Integer id;
    /**
     * 广告名
     */
    private String name;
    /**
     * 广告位id
     */
    private Integer spaceId;
    /**
     * 精确搜索关键词
     */
    private String keyword;
    /**
     * 静态广告的内容
     */
    private String htmlContent;
    /**
     * 文字
     */
    private String text;
    /**
     * 链接
     */
    private String link;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private Date endTime;

    private Date createTime;

    private Date updateTime;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 优先级
     */
    private Integer priority;
    /**
     * 图片地址
     */
    private String img;

}
