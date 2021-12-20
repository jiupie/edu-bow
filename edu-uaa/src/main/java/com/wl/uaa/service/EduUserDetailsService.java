package com.wl.uaa.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author 南顾北衫
 */
public interface EduUserDetailsService extends UserDetailsService {

    /**
     * 通过手机号码登录
     *
     * @param principal /
     * @return /
     */
    UserDetails loadUserByMobile(String principal);

    /**
     * 通过社交账号
     * @param username /
     * @return /
     */
    UserDetails loadUserBySocial(String username);

}
