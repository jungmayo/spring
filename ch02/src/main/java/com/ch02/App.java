package com.ch02;

import com.ch02.config.AppConfig;
import com.ch02.sub1.Greeting;
import com.ch02.sub1.Hello;
import com.ch02.sub1.Welcome;
import com.ch02.sub2.Computer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.naming.Name;

/**
 * 날짜 : 2024.09.02
 * 이름 : 정지현
 * 내용 : 2장 Spring Ioc/Di 실습하기
 *
 * @Configuration
 * - 어플리케이션을 구성하는 빈을 등록하기 위한 설정 클래스
 * - XML, 설정파일 대신 java 클래스를 사용해 스프링 컨테이너 설정
 *
 * @Bean
 * - 컨테이너에 등록하기 위한 빈 설정
 * - 사용자 정의 클래스, 외부 라이브러리 빈 등록
 *
 * @ComponentScan
 * -basePackges로 시작하는 패키지내의 빈을 스캔해서 컨테이너에 등록
 * - 스캔 대상 컴포넌트는 @Component 선언
 *
 * @Autowired
 * -컨테이너의 빈을 주입
 * -이름 또는 클래스 타입으로 매칭된 빈을 주입
 *
 */
public class App 
{
    public static void main( String[] args ) {

        // 스프링 컨테이너 생성
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 빈 가져오기
        Hello hello = context.getBean(Hello.class);
        hello.show();

        Welcome welcome = (Welcome) context.getBean("welcome");
        welcome.show();

        Greeting greeting =(Greeting) context.getBean("greet");
        greeting.show();


        //Ioc/DI 실습 context -> container 객체임
        Computer com = (Computer) context.getBean("com");
        com.show();
    }
}
