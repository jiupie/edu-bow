package com.wl.ad.service;

import com.wl.ad.dto.PromotionAdDTO;

import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public interface PromotionAdService {

    /**
     * 通过spaceId获取广告信息
     * @param spaceId   /
     * @return  /
     */
    List<PromotionAdDTO> getAdBySpaceId(Integer spaceId);
}
