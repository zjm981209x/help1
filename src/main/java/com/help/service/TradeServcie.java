package com.help.service;

import com.help.entity.Trade;

import java.util.List;

public interface TradeServcie {
    Trade insert(Trade trade);
    List<Trade> selectAll();
    Trade selectById(int id);
    int deleteById(int id);
}
