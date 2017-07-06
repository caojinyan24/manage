package swa.manage.controller;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jinyan on 7/3/17.
 */
@RestController//标识controller里面的方法都以json格式输出
@EnableAutoConfiguration
public class ViewController {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ViewController.class, args);
    }

//    @RequestMapping("/")
//    String home() {
//        return "Hello World!";
//    }

}