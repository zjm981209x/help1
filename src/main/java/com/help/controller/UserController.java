package com.help.controller;

import com.help.entity.User;
import com.help.service.UserService;
import com.help.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PutMapping("/")
    public String update(User user,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request){
        String name = (String)request.getAttribute("username");
        User tmp = userService.selectByName(name);
        user.setUserId(tmp.getUserId());
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            user.setImage(filename);
            try {
                FileUtil.upload(file.getBytes(),path,filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return userService.update(user) == 1 ? "success" : "error";
    }
}
