package com.wl.ad.service;

import com.wl.ad.domain.PromotionSpace;

import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */

public interface PromotionSpaceService {
    /**
     * 显示所有的广告位
     *
     * @return /
     */
    List<PromotionSpace> list();
}
