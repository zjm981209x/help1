package com.help.service;

import com.help.entity.Express;

import java.util.List;

public interface ExpressService {
    Express insert(Express express);
    List<Express> selectAll();
    Express selectById(int id);
    int deleteById(int id);
}
