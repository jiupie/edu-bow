package com.wl.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.wl.user.dao.UserDao;
import com.wl.user.domain.User;
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
    public User getUserById(Long id) {
        return userDao.selectById(id);
    }

    @Override
    public User getUserByUsername(String userName) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", userName);
        return userDao.selectOne(queryWrapper);
    }
}
