package com.help.service.Impl;

import com.help.dao.FoodDao;
import com.help.entity.Food;
import com.help.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {

    @Autowired
    private FoodDao foodDao;

    @Override
    public Food insert(Food food) {
        foodDao.insert(food);
        return food;
    }

    @Override
    public List<Food> selectAll() {
        return foodDao.selectAll();
    }

    @Override
    public Food selectById(int id) {
        return foodDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return foodDao.deleteById(id);
    }
}
