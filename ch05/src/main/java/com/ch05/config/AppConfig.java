package com.ch05.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@EnableWebMvc //MVC 구동 설정
@Configuration //빈등록을 위한 설정 클래스로 컨테이너 설정
@ComponentScan(basePackages = {"com.ch05"}) // 패키지내 빈을 스캔해서 컨테이너에 등록
public class AppConfig implements WebMvcConfigurer {

    @Override //dispatcher servlet에 view의 경로를 알려줌
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // jsp 경로 및 확장자 설정
        registry.jsp("/WEB-INF/views/", ".jsp");
    }

    @Override // 정적 리소스 자원(image 등등)
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("/resources/");
    }
}
