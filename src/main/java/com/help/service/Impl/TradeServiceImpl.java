package com.help.service.Impl;

import com.help.dao.TradeDao;
import com.help.entity.Trade;
import com.help.service.TradeServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TradeServiceImpl implements TradeServcie {

    @Autowired
    private TradeDao tradeDao;

    @Override
    public Trade insert(Trade trade) {
        tradeDao.insert(trade);
        return trade;
    }

    @Override
    public List<Trade> selectAll() {
        return tradeDao.selectAll();
    }

    @Override
    public Trade selectById(int id) {
        return tradeDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return tradeDao.deleteById(id);
    }
}
