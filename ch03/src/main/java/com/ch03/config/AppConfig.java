package com.ch03.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"com.ch03"})
@EnableAspectJAutoProxy //aop관련 어노테이션 작동가능하게 하는
public class AppConfig {


}
