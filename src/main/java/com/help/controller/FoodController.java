package com.help.controller;

import com.help.entity.Food;
import com.help.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    @PostMapping("/")
    public String insert(@RequestBody Food food){
        return foodService.insert(food) != null ? "success" : "error";
    }

    @GetMapping("/")
    public List<Food> selectAll(){
        return foodService.selectAll();
    }

    @GetMapping("/{id}")
    public Food selectById(@PathVariable int id){
        return foodService.selectById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return foodService.deleteById(id) == 1 ? "success" : "error";
    }
}
