package com.wl.ad.service;

import com.wl.ad.dto.PromotionSpaceDTO;

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
    List<PromotionSpaceDTO> list();

    /**
     * 通过spaceKey获取广告位广告
     * @param spaceKey /
     * @return /
     */
    List<PromotionSpaceDTO> getAdBySpaceKey(String[] spaceKey);

    /**
     * 更新或者新增广告位
     * @param promotionSpaceDTO /
     * @return /
     */
    PromotionSpaceDTO saveOrUpdateSpace(PromotionSpaceDTO promotionSpaceDTO);

    /**
     * 删除
     * @param id /
     */
    void deleteSpace(Integer id);
}
