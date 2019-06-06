package com.help.controller;

import com.help.entity.User;
import com.help.service.Impl.MailService;
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
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

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
        if(!user.getEmail().isEmpty()){
            ExecutorService executor = Executors.newSingleThreadExecutor();
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    String to = user.getEmail();
                    String subject = "message";
                    String content = "您已成功将邮箱绑定到西邮帮帮帮！";
                    mailService.send(to,subject,content);
                }
            });
        }
        return userService.update(user) == 1 ? "success" : "error";
    }
}
