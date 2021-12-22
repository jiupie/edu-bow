package com.wl.ad.service;

import com.wl.ad.dto.PromotionAdDTO;

import java.io.IOException;
import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public interface PromotionAdService {

    /**
     * 通过spaceId获取广告信息
     *
     * @param spaceId /
     * @return /
     */
    List<PromotionAdDTO> getAdBySpaceId(Integer spaceId);

    /**
     * 获取所有广告
     *
     * @return /
     */
    List<PromotionAdDTO> getAllAds();

    /**
     * 通过ID获取广告
     *
     * @param id /
     * @return /
     */
    PromotionAdDTO getById(Integer id);

    /**
     * 广告新增或编辑
     *
     * @param promotionAdDTO /
     * @return /
     */
    PromotionAdDTO saveOrUpdateAd(PromotionAdDTO promotionAdDTO);

    /**
     * 通过id删除广告信息
     * @param id /
     */
    void deleteAdById(Integer id);
}
