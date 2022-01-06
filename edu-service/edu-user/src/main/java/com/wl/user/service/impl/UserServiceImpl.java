package com.wl.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wl.user.dao.UserDao;
import com.wl.user.domain.SysUser;
import com.wl.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author 南顾北衫
 * @email 17674641491@163.com
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserDao userDao;

    @Override
    public SysUser getUserById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public SysUser getUserByUsername(String userName) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userName);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public SysUser getUserByEmail(String email) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("email", email);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public SysUser getUserByMobile(String mobile) {
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("phone", mobile);
        return userDao.selectOne(queryWrapper);
    }

    @Override
    public IPage<SysUser> getByPages(Page<SysUser> page) {
        return userDao.selectPage(page, null);
    }
}
