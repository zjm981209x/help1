package com.help.controller;

import com.help.entity.Task;
import com.help.entity.Trade;
import com.help.service.TaskService;
import com.help.service.TradeServcie;
import com.help.util.FileUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("trade")
public class TradeController {

    @Autowired
    private TradeServcie tradeServcie;

    @Autowired
    private TaskService taskService;

    @PostMapping("/")
    public String insert(Trade trade,
                         @RequestParam("file") MultipartFile file,
                         HttpServletRequest request){
        String name = (String)request.getAttribute("username");
        if(!file.isEmpty()){
            String filename = file.getOriginalFilename();
            String path = ClassUtils.getDefaultClassLoader().getResource("").getPath() + "static/";
            trade.setImage(filename);
            try {
                FileUtil.upload(file.getBytes(),path,filename);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Trade result = tradeServcie.insert(trade);
        Task task = new Task();
        task.setType("trade");
        task.setStatus(0);
        task.setPubUser(name);
        task.setTypeId(result.getTradeId());
        task.setTime(new Timestamp(System.currentTimeMillis()));
        task.setSubUser("");
        return taskService.insert(task) != null ? "success" : "error";
    }

    @GetMapping("/{id}")
    public Trade selectById(@PathVariable int id){
        return tradeServcie.selectById(id);
    }

    @GetMapping("/")
    public List<Trade> selectAll(){
        return tradeServcie.selectAll();
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable int id){
        return tradeServcie.deleteById(id) == 1 ? "success" : "error";
    }

}
