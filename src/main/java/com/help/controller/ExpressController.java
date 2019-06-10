package com.help.controller;

import com.help.entity.Express;
import com.help.entity.Task;
import com.help.service.ExpressService;
import com.help.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

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

    @GetMapping("/{id}")
    public Express selectById(@PathVariable int id){
        return expressService.selectById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return expressService.deleteById(id) == 1 ? "success" : "error";
    }

    @GetMapping("/")
    public List<Express> selectAll(){
        return expressService.selectAll();
    }
}
