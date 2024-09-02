package com.ch02.config;

import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// 컨테이너가 관리하는 객체들(의존성) 관리
@Configuration
@ComponentScan(basePackages = {"com.ch02"})
public class AppConfig {

    @Bean //컨테이너에 등록 , 반드시 반환타입이 있어야 함
    public Hello hello(){
        return new Hello();
    }
    @Bean(name = "welcome")
    public Welcome welcome(){
        return new Welcome();
    }
    @Bean("greet")
    public Greeting greeting(){
        return new Greeting();
    }

}
