package com.wl.user.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wl.user.domain.SysUser;

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
    SysUser getUserById(Long id);

    /**
     * 通过Id获取用户
     * @param userName 用户
     * @return /
     */
    SysUser getUserByUsername(String userName);

    /**
     * 通过email获取用户
     * @param email 邮件
     * @return /
     */
    SysUser getUserByEmail(String email);

    /**
     * 通过mobile获取用户
     * @param mobile 手机号码
     * @return /
     */
    SysUser getUserByMobile(String mobile);

    /**
     * 通过mobile获取用户
     * @param page /
     * @return /
     */
    IPage<SysUser> getByPages(Page<SysUser> page);
}
