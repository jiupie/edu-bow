package com.wl.uaa.web;

import com.wl.common.base.ResponseDTO;
import com.wl.uaa.dto.LoginDTO;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@RestController
@RequestMapping("/api/authorize")
@RequiredArgsConstructor
@Api(tags = "认证模块")
public class AuthorizeRest {
    @PostMapping
    public ResponseDTO login(@RequestBody LoginDTO loginDTO){

        return null;
    }
}
