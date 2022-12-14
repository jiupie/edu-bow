package com.wl.ad.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.wl.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author 南顾北衫
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PromotionAd extends BaseEntity {

    @TableId(type = IdType.AUTO)
    @ApiModelProperty("主键")
    private Integer id;
    /**
     * 广告名
     */
    @ApiModelProperty("广告名")
    private String name;
    /**
     * 广告位id
     */
    @ApiModelProperty("广告位id")
    private Integer spaceId;
    /**
     * 精确搜索关键词
     */
    @ApiModelProperty("精确搜索关键词")
    private String keyword;
    /**
     * 静态广告的内容
     */
    @ApiModelProperty("静态广告的内容")
    private String htmlContent;
    /**
     * 文字
     */
    @ApiModelProperty("文字")
    private String text;
    /**
     * 链接
     */
    @ApiModelProperty("链接")
    private String link;
    /**
     * 开始时间
     */
    @ApiModelProperty("开始时间")
    private Date startTime;
    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    private Date endTime;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    private Integer status;
    /**
     * 优先级
     */
    @ApiModelProperty("优先级")
    private Integer priority;
    /**
     * 图片地址
     */
    @ApiModelProperty("图片地址")
    private String img;

}
