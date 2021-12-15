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
import java.util.Objects;

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
        queryWrapper.eq("status", 1);
        Date date = new Date();
        queryWrapper.gt("start_time", date);
        queryWrapper.lt("end_time", date);

        List<PromotionAd> promotionAdList = promotionAdDao.selectList(queryWrapper);
        return promotionAdMapper.toDto(promotionAdList);
    }

    @Override
    public List<PromotionAdDTO> getAllAds() {
        return promotionAdMapper.toDto(promotionAdDao.selectList(null));
    }

    @Override
    public PromotionAdDTO getById(Integer id) {
        return promotionAdMapper.toDto(promotionAdDao.selectById(id));
    }

    @Override
    public PromotionAdDTO saveOrUpdateAd(PromotionAdDTO promotionAdDTO) {
        PromotionAd promotionAd = promotionAdMapper.toEntity(promotionAdDTO);
        if(Objects.isNull(promotionAd.getId())){
            promotionAdDao.insert(promotionAd);
        }else {
            promotionAdDao.updateById(promotionAd);
        }
        return promotionAdMapper.toDto(promotionAd);
    }
}
