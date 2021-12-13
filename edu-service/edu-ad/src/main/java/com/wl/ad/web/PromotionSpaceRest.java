package com.wl.ad.web;

import com.wl.ad.domain.PromotionSpace;
import com.wl.ad.service.PromotionSpaceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@RestController
@RequestMapping("/api/ad/space")
@RequiredArgsConstructor
@Api(tags = "广告位")
public class PromotionSpaceRest {

    private final PromotionSpaceService promotionSpaceService;

    @ApiModelProperty(name = "获取所有的广告位")
    @GetMapping("/getAllSpace")
    public List<PromotionSpace> getAllSpace(){
        return promotionSpaceService.list();
    }
}
