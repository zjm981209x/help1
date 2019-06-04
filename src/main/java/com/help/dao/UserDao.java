package com.help.dao;

import com.help.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
    int insert(User user);
    User selectByName(String name);
}
