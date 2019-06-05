package com.help.service;

import com.help.entity.Food;

import java.util.List;

public interface FoodService {
    Food insert(Food food);
    List<Food> selectAll();
    Food selectById(int id);
    int deleteById(int id);
}
