package com.wl.ad.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Data
public class PromotionSpaceDTO {
    private Integer id;
    private String name;
    private String spaceKey;
    private Date createTime;
    private Date updateTime;
    private Integer isDel;
    private List<PromotionAdDTO> promotionAdDTOList;
}
