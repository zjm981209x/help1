package com.help.controller;

import com.help.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @PutMapping("/{id}")
    public String addSubUser(@PathVariable int id, HttpServletRequest request){
        String name = (String) request.getAttribute("username");
        return taskService.updateById(id,name) == 1 ? "success" : "error";
    }



}
