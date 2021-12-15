package com.wl.ad.web;

import com.wl.ad.dto.PromotionSpaceDTO;
import com.wl.ad.service.PromotionSpaceService;
import com.wl.common.base.ResponseDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@RestController
@RequestMapping("/api/ad/space")
@RequiredArgsConstructor
@Api(tags = "广告模块")
public class PromotionAdRest {

    private final PromotionSpaceService promotionSpaceService;

    @ApiOperation("获取所有的广告位")
    @GetMapping("/getAllSpace")
    public ResponseDTO getAllSpace() {
        return ResponseDTO.success(promotionSpaceService.list());
    }


    @ApiOperation("通过spaceKey获取所有的广告信息")
    @GetMapping("/getAdBySpaceKey")
    public ResponseDTO getAdBySpaceKey(String[] spaceKey) {
        if (spaceKey == null || spaceKey.length == 0) {
            return ResponseDTO.success();
        }
        return ResponseDTO.success(promotionSpaceService.getAdBySpaceKey(spaceKey));
    }

    @ApiOperation("新增或者修改广告位")
    @PostMapping("/saveOrUpdateSpace")
    public ResponseDTO saveOrUpdateSpace(@RequestBody PromotionSpaceDTO promotionSpaceDTO) {
        return ResponseDTO.success(promotionSpaceService.saveOrUpdateSpace(promotionSpaceDTO));
    }

    @ApiOperation("删除广告位")
    @DeleteMapping("/{id}")
    public ResponseDTO saveOrUpdateSpace(@PathVariable(name = "id") @NotNull Integer id) {
        promotionSpaceService.deleteSpace(id);
        return ResponseDTO.success();
    }

}
