package com.wl.ad.service.mapstruct;

import com.wl.ad.domain.PromotionAd;
import com.wl.ad.dto.PromotionAdDTO;
import com.wl.common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PromotionAdMapper extends BaseMapper<PromotionAdDTO, PromotionAd> {
}
