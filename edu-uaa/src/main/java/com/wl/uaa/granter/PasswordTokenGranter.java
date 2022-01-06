package com.wl.uaa.granter;

import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.enums.LoginType;
import com.wl.uaa.valid.AbstractValidCode;
import com.wl.user.domain.SysUser;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class PasswordTokenGranter implements ITokenGranter {
    public static final LoginType GRANT_TYPE = LoginType.PASSWORD;

    @Override
    public SysUser grant(LoginDTO loginDTO, AbstractValidCode abstractValidCode) {
        return null;
    }
}
