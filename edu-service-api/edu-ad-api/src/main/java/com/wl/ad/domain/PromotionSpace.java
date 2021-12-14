package com.wl.ad.domain;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wl.common.base.BaseEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author 南顾北衫
 */
@EqualsAndHashCode(callSuper = true)
@TableName(value = "promotion_space")
@Data
public class PromotionSpace extends BaseEntity {
    /**
     *
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 广告位key
     */
    @ApiModelProperty("广告位key")
    private String spaceKey;

    /**
     * 是否删除
     */
    @TableLogic
    @ApiModelProperty("是否删除")
    private Integer isDel;

}