package com.wl.uaa.granter;

import com.wl.common.exception.BadRequestException;
import com.wl.common.utils.SpringUtil;
import com.wl.uaa.config.TokenProvider;
import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.enums.LoginType;
import com.wl.uaa.valid.AbstractValidCode;
import com.wl.user.domain.SysUser;
import com.wl.user.feign.IUserProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Objects;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class EmailTokenGranter implements ITokenGranter {
    public static final LoginType GRANT_TYPE = LoginType.EMAIL;

    @Override
    public Authentication grant(LoginDTO loginDTO, AbstractValidCode abstractValidCode) {

        //查询用户表通过邮件
        IUserProvider userProvider = SpringUtil.getBean(IUserProvider.class);
        SysUser user = userProvider.getUserByEmail(loginDTO.getLogin()).getContent();
        if (Objects.isNull(user)) {
            throw new BadRequestException("该用户不存在");
        }
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getName(), loginDTO.getPassword());
        AuthenticationManagerBuilder authenticationManagerBuilder = SpringUtil.getBean(AuthenticationManagerBuilder.class);
        Authentication authenticate = authenticationManagerBuilder.getObject().authenticate(usernamePasswordAuthenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authenticate);

        //生成token
        TokenProvider tokenProvider = SpringUtil.getBean(TokenProvider.class);
        tokenProvider.createToken(authenticate);
        return authenticate;
    }
}
