package com.help.service.Impl;

import com.help.dao.TaskDao;
import com.help.entity.Task;
import com.help.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskDao taskDao;

    @Override
    public Task insert(Task task) {
        taskDao.insert(task);
        return task;
    }

    @Override
    public List<Task> selectAll() {
        return taskDao.selectAll();
    }

    @Override
    public int delete(int id) {
        return taskDao.delete(id);
    }

    @Override
    public int updateById(int id, String name) {
        return taskDao.updateById(id,name);
    }
}
