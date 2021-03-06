package com.help.dao;

import com.help.entity.Express;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ExpressDao {
    int insert(Express express);
    List<Express> selectAll();
    Express selectById(int id);
    int deleteById(int id);
}
