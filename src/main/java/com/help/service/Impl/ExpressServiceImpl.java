package com.help.service.Impl;

import com.help.dao.ExpressDao;
import com.help.entity.Express;
import com.help.service.ExpressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpressServiceImpl implements ExpressService {

    @Autowired
    private ExpressDao expressDao;

    @Override
    public Express insert(Express express) {
        expressDao.insert(express);
        return express;
    }

    @Override
    public List<Express> selectAll() {
        return expressDao.selectAll();
    }

    @Override
    public Express selectById(int id) {
        return expressDao.selectById(id);
    }

    @Override
    public int deleteById(int id) {
        return expressDao.deleteById(id);
    }
}
