package com.help.controller;

import com.help.entity.Comment;
import com.help.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping("/")
    public String insert(@RequestBody Comment comment){
        return commentService.insert(comment) != null ? "success" : "error";
    }

    @GetMapping("/{taskId}")
    public List<Comment> selectById(@PathVariable int taskId){
        return commentService.selectById(taskId);
    }

    @DeleteMapping("/{commentId}")
    public String deleteById(@PathVariable int commentId){
        return commentService.deleteById(commentId) == 1 ? "success" : "error";
    }
}
