package com.wl.uaa.web;

import com.wl.common.base.ResponseDTO;
import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.granter.ITokenGranter;
import com.wl.uaa.granter.TokenGranterBuilder;
import com.wl.user.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
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
public class AuthorizationRest {

    @ApiModelProperty
    @PostMapping
    public ResponseDTO login(@RequestBody LoginDTO loginDTO){
        String loginType = loginDTO.getLoginType();
        ITokenGranter tokenGranter = TokenGranterBuilder.getGranter(loginType);
        User user = tokenGranter.grant(loginDTO);

        return null;
    }
}
