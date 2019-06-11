package com.help.dao;

import com.help.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
@Mapper
public interface CommentDao {

    int insert(Comment comment);

    List<Comment> selectById(int taskId);

    int deleteById(int commentId);

}
