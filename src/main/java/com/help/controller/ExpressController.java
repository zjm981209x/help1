package com.help.controller;

import com.help.entity.Express;
import com.help.entity.Task;
import com.help.service.ExpressService;
import com.help.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @GetMapping("/ungot")
     public List<Map> selectUngotExpress() {
         return getExpressResult(expressService.selectUngot(),expressService.selectFromTask());
     }

    /*返回task和express中未被领取的快递任务，map中一一对应的list

     */
    public List<Map> getExpressResult(List<Express> expressList, List<Task> taskList) {
        List<Map> result = new ArrayList<>();
        for (Task task:taskList) {
            Map<Task,Express> map = new HashMap<>();
            for (Express express:expressList) {
                if(express.getExpressId() == task.getTypeId()) {
                    map.put(task,express);
                }
            }
            result.add(map);

        }

        return result;

    }
}
