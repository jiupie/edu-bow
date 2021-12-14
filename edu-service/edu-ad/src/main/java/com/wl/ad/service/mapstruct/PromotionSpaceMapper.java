package com.wl.ad.service.mapstruct;

import com.wl.ad.domain.PromotionSpace;
import com.wl.ad.dto.PromotionSpaceDTO;
import com.wl.common.base.BaseMapper;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PromotionSpaceMapper  extends BaseMapper<PromotionSpaceDTO, PromotionSpace> {


}
