package com.help.service.Impl;

import com.help.dao.UserDao;
import com.help.entity.User;
import com.help.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User insert(User user) {
        userDao.insert(user);
        return user;
    }

    @Override
    public User selectByName(String name) {
        return userDao.selectByName(name);
    }

    @Override
    public int update(User user) {
        return userDao.update(user);
    }
}
