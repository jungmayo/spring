package com.ch07.repository.shop;

import com.ch07.dto.CustomerDTO;
import com.ch07.dto.ProductAggDTO;
import com.ch07.entity.shop.*;

import com.querydsl.core.Tuple;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class ShopQueryTest {

    /*
    QueryDSL 설정
      1) 의존성
        -build.gradle 의존성 추가
        -implementation 'com.querydsl:querydsl-jpa:5.1.0:jakarta'
        -annotationProcessor "com.querydsl:querydsl-apt:5.1.0:jakarta"
        -annotationProcessor "jakarta.annotation:jakarta.annotation-api"
        -annotationProcessor "jakarta.persistence:jakarta.persistence-api"

        -build.gradle 파일 QueryDSL 경로 및 환경 설정
        -Q 도메인 클래스 생성 확인(어플리케이션 실행 상태 확인)

       2) QueryDSL 구현
         -개별 Repository 확장 Custom 인터페이스 생성
         -Custom 인터페이스를 구현하는 IMPL 클래스 생성
         -Impl 클래스에서 QueryDSL 쿼리메서드 정의
         -개별 repository에 Custom 인터페이스 상속 추가

     */




    @Autowired
    private JPAQueryFactory queryFactory;

    private QCustomer qCustomer = QCustomer.customer;
    private QProduct qProduct = QProduct.product;
    private QOrder qOrder = QOrder.order;
    @Autowired
    private JPAQueryFactory jpaQueryFactory;

    @Test
    void test01(){
        List<Product> products = jpaQueryFactory
                                    .selectFrom(qProduct)
                                    .fetch();
    }
    @Test
    void test02(){
         List<Product> products = jpaQueryFactory
                .select(
                                Projections.fields(
                                        Product.class,
                                        qProduct.prodId,
                                        qProduct.prodName,
                                        qProduct.price
                                )
                )
                .from(qProduct)
                .fetch(); // fetch결과는 List

        System.out.println();
    }
    @Test
    void test03(){
        List< Customer> customers1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.eq("김유신")).fetch();
        List< Customer> customers2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.name.ne("김유신")).fetch();

        System.out.println(customers1);
        System.out.println(customers2);
    }
    @Test
    void test04(){
        List< Customer> customer1 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.gt(30)).fetch();
        List< Customer> customer2 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.goe(30)).fetch();
        List< Customer> customer3 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.lt(30)).fetch();
        List< Customer> customer4 = jpaQueryFactory.selectFrom(qCustomer).where(qCustomer.age.loe(30)).fetch();

        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println(customer3);
        System.out.println(customer4);
    }
    @Test
    void test05(){
        List< Customer> customer1 = jpaQueryFactory
                                            .selectFrom(qCustomer)
                                            .where(qCustomer.addr.in("서울","김해"))
                                            .fetch();
        System.out.println(customer1);

    }
    @Test
    void test06(){
        List< Customer> customer1 = jpaQueryFactory
                                        .selectFrom(qCustomer)
                                        .where(qCustomer.name.like("%신"))
                                        .fetch();

        System.out.println(customer1);
    }
    @Test
    void test07(){
        List<Product> products = jpaQueryFactory
                                        .selectFrom(qProduct)
                                        .where(qProduct.stock.gt(0))
                                        .orderBy(qProduct.price.desc())
                                        .fetch();
        System.out.println(products);
    }
    @Test
    void test08(){
      List<Product> products =  jpaQueryFactory
                                      .selectFrom(qProduct)
                                      .where(qProduct.stock.gt(0))
                                      .orderBy(qProduct.price.asc())
                                      .offset(0)
                                      .limit(3)
                                      .fetch();
      System.out.println(products);
    }
    @Test
    void test09(){
       ProductAggDTO productAggDTO =  jpaQueryFactory.select(
                Projections.fields(
                            ProductAggDTO.class,
                            qProduct.price.sum().as("priceSum"),
                            qProduct.price.avg().as("priceAvg"),
                            qProduct.price.max().as("priceMax"),
                            qProduct.price.min().as("priceMin")
                        )
                )
                .from(qProduct)
                .fetchOne();
        System.out.println(productAggDTO);


    }
    @Test
    void test10(){
        List<CustomerDTO> customerDTOs = jpaQueryFactory
                                            .select(
                                                    Projections.fields(
                                                            CustomerDTO.class,
                                                            qOrder.customer.custId,
                                                            qOrder.customer.name,
                                                            qOrder.customer.custId.count().as("orderCount")
                                                    )
                                            )
                                            .from(qOrder)
                                            .where(qOrder.orderStatus.eq(1))
                                            .groupBy(qOrder.customer.custId)
                                            .having(qOrder.customer.custId.count().goe(2))
                                            .fetch();

        System.out.println(customerDTOs);

    }
    @Transactional
    @Test
    void test11(){
        List<Tuple> result = jpaQueryFactory
                .select(qOrder, qCustomer)
                .from(qOrder)
                .join(qCustomer)
                .on(qOrder.customer.eq(qCustomer))
                .fetch();
        System.out.println(result);
    }

}
