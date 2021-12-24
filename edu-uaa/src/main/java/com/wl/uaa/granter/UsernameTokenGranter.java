package com.wl.uaa.granter;

import com.wl.uaa.dto.LoginDTO;
import com.wl.uaa.enums.LoginType;
import com.wl.user.domain.User;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public class UsernameTokenGranter implements ITokenGranter{
    public static final LoginType GRANT_TYPE = LoginType.USERNAME;

    @Override
    public User grant(LoginDTO loginDTO) {

        return null;
    }
}
