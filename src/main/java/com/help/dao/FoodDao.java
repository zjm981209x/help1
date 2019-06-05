package com.help.dao;

import com.help.entity.Food;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface FoodDao {
    int insert(Food food);
    List<Food> selectAll();
    Food selectById(int id);
    int deleteById(int id);
}
