package com.wl.user.feign;

import com.wl.common.base.ResponseDTO;
import com.wl.user.domain.SysUser;
import org.springframework.stereotype.Component;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Component
public class UserProviderFallback implements IUserProvider{
    @Override
    public ResponseDTO<SysUser> getUserById(Long id) {
        return ResponseDTO.ofError("error");
    }

    @Override
    public ResponseDTO<SysUser> getUserByUserName(String userName) {
        return null;
    }

    @Override
    public ResponseDTO<SysUser> getUserByMobile(String mobile) {
        return null;
    }

    @Override
    public ResponseDTO<SysUser> getUserByEmail(String email) {
        return null;
    }
}
