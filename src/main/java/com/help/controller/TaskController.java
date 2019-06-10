package com.help.controller;

import com.help.entity.Express;
import com.help.entity.Food;
import com.help.entity.Task;
import com.help.entity.Trade;
import com.help.service.ExpressService;
import com.help.service.FoodService;
import com.help.service.TaskService;
import com.help.service.TradeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    private TaskService taskService;

    @Autowired
    private FoodService foodService;

    @Autowired
    private ExpressService expressService;

    @Autowired
    private TradeServcie tradeServcie;

    /**
     *  添加领取任务者
     *
     * @param id
     * @param request
     * @return
     */
    @PutMapping("/{id}")
    public String addSubUser(@PathVariable int id, HttpServletRequest request){
        String name = (String) request.getAttribute("username");
        return taskService.updateById(id,name) == 1 ? "success" : "error";
    }

    /**
     * 返回所有未领取的任务信息
     *
     * @return Map<String,Object>
     */
    @GetMapping("/status")
    public List<Map> selectByStatus() {
        List<Task> list = taskService.selectByStatus();
        return getResult(list);
    }

    /**
     * 返回和当前登录用户相关的所有任务信息
     *
     * @param request
     * @return List<Map>
     */
    @GetMapping("/name")
    public List<Map> selectByName(HttpServletRequest request){
        String name = (String) request.getAttribute("username");
        List<Task> list = taskService.selectByName(name);
        return getResult(list);
    }







    /**
     * 封装查询的任务信息
     * @param list
     * @return
     */
    public List<Map> getResult(List<Task> list) {
        List<Map> result = new ArrayList<>();
        for (Task task : list) {
            Map<String,Object> map = new HashMap<>();
            map.put("task",task);
            String type = task.getType();
            int typeId = task.getTypeId();
            if("food".equals(type)){
                Food food = foodService.selectById(typeId);
                map.put(type,food);
            }else if("express".equals(type)){
                Express express = expressService.selectById(typeId);
                map.put(type,express);
            }else{
                Trade trade = tradeServcie.selectById(typeId);
                map.put(type,trade);
            }
            result.add(map);
        }
        return result;
    }
}
