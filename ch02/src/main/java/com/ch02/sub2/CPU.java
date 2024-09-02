package com.ch02.sub2;

import org.springframework.stereotype.Component;

@Component //자동으로 빈 등록
public class CPU {

    public void show(){
        System.out.println("CPU : Inter i7");
    }
}
