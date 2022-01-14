package com.wl.user.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wl.common.base.PageDTO;
import com.wl.common.base.ResponseDTO;
import com.wl.user.domain.SysUser;
import com.wl.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@Api(tags = "用户模块")
public class UserRest {
    private final UserService promotionSpaceService;

    @GetMapping("getByPages")
    @ApiOperation("分页获取用户数据")
    public ResponseDTO getByPages(PageDTO page) {
        IPage<SysUser> pages = promotionSpaceService.getByPages(new Page<SysUser>(page.getCurrent(), page.getSize()));
        return ResponseDTO.success(pages);
    }
}
