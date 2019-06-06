package com.help;

import com.help.filter.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HelpApplication {

    @Bean
    public FilterRegistrationBean jwtFilter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new JwtFilter());
        bean.addUrlPatterns("/user/*");
        bean.addUrlPatterns("/food/*");
        bean.addUrlPatterns("/trade/*");
        bean.addUrlPatterns("/express/*");
        bean.addUrlPatterns("/task/*");
        return bean;
    }

    public static void main(String[] args) {
        SpringApplication.run(HelpApplication.class, args);
    }

}
