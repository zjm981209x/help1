package com.help.dao;

import com.help.entity.Trade;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TradeDao {
    int insert(Trade trade);
    List<Trade> selectAll();
    Trade selectById(int id);
    int deleteById(int id);
}
