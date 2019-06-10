package com.help.service;

import com.help.entity.Task;

import java.util.List;

public interface TaskService {
    Task insert(Task task);
    List<Task> selectAll();
    List<Task> selectByName(String name);
    int delete(int id);
    int updateById(int id, String name);
    List<Task> selectByStatus();
}
