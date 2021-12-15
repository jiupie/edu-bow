package com.wl.ad.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wl.ad.dao.PromotionSpaceDao;
import com.wl.ad.domain.PromotionSpace;
import com.wl.ad.dto.PromotionSpaceDTO;
import com.wl.ad.service.PromotionAdService;
import com.wl.ad.service.PromotionSpaceService;
import com.wl.ad.service.mapstruct.PromotionSpaceMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Service
@RequiredArgsConstructor
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    private final PromotionSpaceDao promotionSpaceDao;
    private final PromotionAdService promotionAdService;
    private final PromotionSpaceMapper promotionSpaceMapper;

    @Override
    public List<PromotionSpaceDTO> list() {
        return promotionSpaceMapper.toDto(promotionSpaceDao.selectList(null));
    }

    @Override
    public List<PromotionSpaceDTO> getAdBySpaceKey(String[] spaceKey) {
        ArrayList<PromotionSpaceDTO> list = new ArrayList<>();
        for (String key : spaceKey) {
            QueryWrapper<PromotionSpace> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("space_key", key);
            //获取广告位
            PromotionSpace promotionSpace = promotionSpaceDao.selectOne(queryWrapper);
            if (Objects.isNull(promotionSpace)) {
                continue;
            }
            //注入DTO中
            PromotionSpaceDTO promotionSpaceDTO = promotionSpaceMapper.toDto(promotionSpace);
            //获取广告位广告
            promotionSpaceDTO.setPromotionAdDTOList(promotionAdService.getAdBySpaceId(promotionSpace.getId()));
            list.add(promotionSpaceDTO);
        }
        return list;
    }

    @Override
    public PromotionSpaceDTO saveOrUpdateSpace(PromotionSpaceDTO promotionSpaceDTO) {
        PromotionSpace promotionSpace = promotionSpaceMapper.toEntity(promotionSpaceDTO);
        if (Objects.isNull(promotionSpaceDTO.getId())) {
            promotionSpaceDao.insert(promotionSpace);
        } else {
            promotionSpaceDao.updateById(promotionSpace);
        }
        return promotionSpaceMapper.toDto(promotionSpace);
    }

    @Override
    public void deleteSpace(Integer id) {
        promotionSpaceDao.deleteById(id);
    }

    @Override
    public PromotionSpaceDTO getById(Integer id) {
       return promotionSpaceMapper.toDto(promotionSpaceDao.selectById(id));
    }
}
