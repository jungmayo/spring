package com.ch06.service;

import com.ch06.dto.User2DTO;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class User2ServiceTest {

    @Autowired
    private User2Service user2Service;

    @Test
    @Order(1)
    void insertUser2() {
        //테스트 정의 : given when then

        //given
        User2DTO sample = User2DTO.builder()
                .uid("b101")
                .name("김춘추")
                .birth("1999-01-01")
                .hp("010-1234-1234")
                .addr("경남 진주")
                .build();
        //when
        user2Service.insertUser2(sample);

        //then
        User2DTO expected = user2Service.selectUser2(sample.getUid());

        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    @Order(2)
    void selectUser2() {
    }

    @Test
    @Order(3)
    void selectUser2s() {
    }

    @Test
    @Order(4)
    void updateUser2() {
    }

    @Test
    @Order(5)
    void deleteUser2() {
    }
}