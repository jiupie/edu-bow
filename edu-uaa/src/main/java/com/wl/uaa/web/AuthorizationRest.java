package com.wl.uaa.web;

import com.wl.common.base.ResponseDTO;
import com.wl.common.enums.ResultCode;
import com.wl.common.exception.ValidCodeException;
import com.wl.uaa.config.bean.ValidCode;
import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.dto.ValidCodeDTO;
import com.wl.uaa.enums.LoginType;
import com.wl.uaa.enums.ValidCodeChannelType;
import com.wl.uaa.granter.ITokenGranter;
import com.wl.uaa.granter.TokenGranterBuilder;
import com.wl.uaa.valid.AbstractValidCode;
import com.wl.uaa.valid.ValidBuilder;
import com.wl.user.domain.User;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@RestController
@RequestMapping("/api/authorize")
@RequiredArgsConstructor
@Api(tags = "认证模块")
public class AuthorizationRest {
    private final ValidBuilder validBuilder;

    @PostMapping
    public ResponseDTO login(@RequestBody LoginDTO loginDTO) {
        String loginType = loginDTO.getLoginType();
        ITokenGranter tokenGranter = TokenGranterBuilder.getGranter(loginType);
        AbstractValidCode valid = validBuilder.createLoginValid(Objects.requireNonNull(LoginType.findValue(loginType)));
        User user = tokenGranter.grant(loginDTO,valid);
        return ResponseDTO.response(ResultCode.SUCCESS,user);
    }

    /**
     * 获取验证码
     * @param validCodeDTO /
     * @return /
     */
    @GetMapping
    public ResponseDTO getCode(ValidCodeDTO validCodeDTO) {
        String channel = validCodeDTO.getChannel();
        ValidCodeChannelType value = ValidCodeChannelType.findValue(channel);
        AbstractValidCode validCode = validBuilder.crateByChannelType(value);
        if (Objects.isNull(validCode)) {
            throw new ValidCodeException(ResultCode.VALID_CHANNEL_NOT_EXIST);
        }
        ValidCode code = validCode.create(validCodeDTO);
        return ResponseDTO.response(ResultCode.SUCCESS,code.getInfo());
    }
}
