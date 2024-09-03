package com.ch04.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller //component 대신
public class MainController {

    // 요청 메서드 정의
    // 주소 매핑
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public void hello(){
        System.out.println("hello...");

    }

    //위와 동일
    @GetMapping("/welcome")
    public void welcome(){
        System.out.println("welcome...");

    }
    @GetMapping("/greeting")
    public void greeting(){
        System.out.println("greeting...");

    }
}
