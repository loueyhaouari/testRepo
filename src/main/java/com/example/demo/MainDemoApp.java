package com.example.demo;

import com.example.demo.config.DemoConfig;
import com.example.demo.dao.AccountDAO;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication()
public class MainDemoApp {
    public static void main(String[] args) {
        SpringApplication.run(MainDemoApp.class, args);
//        AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(DemoConfig.class);
//        AccountDAO theDAO=context.getBean("accountDAO",AccountDAO.class);
//        theDAO.addAccount();
//        context.close();
    }
}
