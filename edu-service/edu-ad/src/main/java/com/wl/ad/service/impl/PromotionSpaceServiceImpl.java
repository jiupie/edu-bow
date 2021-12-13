package com.wl.ad.service.impl;

import com.wl.ad.dao.PromotionSpaceDao;
import com.wl.ad.domain.PromotionSpace;
import com.wl.ad.service.PromotionSpaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Service
@RequiredArgsConstructor
public class PromotionSpaceServiceImpl implements PromotionSpaceService {
    private final PromotionSpaceDao promotionSpaceDao;

    @Override
    public List<PromotionSpace> list() {
        return promotionSpaceDao.selectList(null);
    }

}
