package com.help.service;

import com.help.entity.User;

public interface UserService {
    User insert(User user);
    User selectByName(String name);
}
