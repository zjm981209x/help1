package com.help.controller;

import com.help.entity.Express;
import com.help.entity.Task;
import com.help.service.ExpressService;
import com.help.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@RestController
@RequestMapping("/express")
public class ExpressController {

    @Autowired
    private ExpressService expressService;

    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public String insert(@RequestBody Express express, HttpServletRequest request){
        String name = (String) request.getAttribute("username");
        Express result = expressService.insert(express);
        Task task = new Task();
        task.setTypeId(result.getExpressId());
        task.setType("express");
        task.setStatus(0);
        task.setPubUser(name);
        task.setSubUser("");
        task.setTime(new Timestamp(System.currentTimeMillis()));
        return taskService.insert(task) != null ? "success" : "error";
    }

}
