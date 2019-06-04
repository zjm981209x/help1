package com.help.controller;

import com.help.entity.User;
import com.help.service.UserService;
import com.help.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class LogController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public String register(String username, String password){
        User user = userService.selectByName(username);
        if(user != null){
            return "error";
        }else {
            User tmp = new User();
            tmp.setUserName(username);
            tmp.setUserPw(password);
            return userService.insert(tmp) != null ? "success" : "error";
        }
    }

    @RequestMapping("/login")
    public String login(String username, String password){
        User user = userService.selectByName(username);
        if(user != null){
            String pw = user.getUserPw();
            if(pw.equals(password)){
                String token = JWTUtil.getToken(username);
                return token;
            }else {
                return "error";
            }
        }else {
            return "error";
        }
    }


}
