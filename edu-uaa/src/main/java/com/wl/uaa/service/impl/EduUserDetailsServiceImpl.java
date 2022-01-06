package com.wl.uaa.service.impl;

import com.wl.uaa.service.EduUserDetailsService;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * 用户详情获取
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Service
public class EduUserDetailsServiceImpl implements EduUserDetailsService {


    @Override
    public UserDetails loadUserByMobile(String principal) {
        //通过手机号码获取用户
        return null;
    }

    @Override
    public UserDetails loadUserBySocial(String username) {
        return null;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}
