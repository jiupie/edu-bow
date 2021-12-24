package com.wl.user.feign;

import com.wl.common.base.ResponseDTO;
import com.wl.user.domain.User;
import org.springframework.stereotype.Component;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Component
public class UserProviderFallback implements IUserProvider{
    @Override
    public ResponseDTO<User> getUserById(Long id) {
        return ResponseDTO.ofError("error");
    }

    @Override
    public ResponseDTO<User> getUserByUserName(String userName) {
        return null;
    }

    @Override
    public ResponseDTO<User> getUserByMobile(String mobile) {
        return null;
    }
}
