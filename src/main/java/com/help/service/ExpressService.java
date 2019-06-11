package com.help.service;

import com.help.entity.*;

import java.util.List;

public interface ExpressService {
    Express insert(Express express);
    List<Express> selectAll();
    Express selectById(int id);
    int deleteById(int id);
    List<Express> selectUngot();
    List<Task> selectFromTask();
}
