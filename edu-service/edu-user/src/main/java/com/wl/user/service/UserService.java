package com.wl.user.service;

import com.wl.user.domain.User;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
public interface UserService {
    /**
     * 通过Id获取用户
     * @param id /
     * @return /
     */
    User getUserById(Long id);

    /**
     * 通过Id获取用户
     * @param userName 用户
     * @return /
     */
    User getUserByUsername(String userName);
}
