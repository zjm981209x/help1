package com.help;

import com.help.service.Impl.MailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelpApplicationTests {

    @Autowired
    private MailService service;
    @Test
    public void contextLoads(){
        service.send("1685813197@qq.com","hello","您已绑定");
    }

}
