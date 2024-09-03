package com.ch03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("myService")
public class MyService {
    //@Autowired
    //private MyAdvice advice;

    public void insert(){
        //advice.beforeAdvice(); -> 객체지향으로 하는 방법
        System.out.println("핵심기능 - insert");
    }
    public void select(String uid){
        System.out.println("핵심기능 - select");

        if(uid.equals("a101")){
            System.out.println("핵심기능 - uid : " + uid);
        }
    }
    public void update(){
        System.out.println("핵심기능 - update");
    }
    public void delete(){
        System.out.println("핵심기능 - delete");
    }

}
