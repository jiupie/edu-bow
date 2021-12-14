package com.wl.ad.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wl.ad.dao.PromotionAdDao;
import com.wl.ad.domain.PromotionAd;
import com.wl.ad.dto.PromotionAdDTO;
import com.wl.ad.service.PromotionAdService;
import com.wl.ad.service.mapstruct.PromotionAdMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Service
@RequiredArgsConstructor
public class PromotionAdServiceImpl implements PromotionAdService {
    private final PromotionAdDao promotionAdDao;
    private final PromotionAdMapper promotionAdMapper;

    @Override
    public List<PromotionAdDTO> getAdBySpaceId(Integer spaceId) {
        QueryWrapper<PromotionAd> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("space_id", spaceId);
        queryWrapper.eq("status",1);
        Date date = new Date();
        queryWrapper.gt("start_time",date);
        queryWrapper.lt("end_time",date);

        List<PromotionAd> promotionAdList = promotionAdDao.selectList(queryWrapper);
        return promotionAdMapper.toDto(promotionAdList);
    }
}
