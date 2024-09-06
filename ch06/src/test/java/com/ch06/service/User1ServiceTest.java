package com.ch06.service;

import com.ch06.dto.User1DTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class User1ServiceTest {

    @Autowired
    private User1Service user1Service;


    @Test
    void insertUser1() {
        // 테스트 정의 : given - when - then 패턴

        //given : 테스트를 실행하기 위한 준비단계
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유신")
                .birth("1999-01-01")
                .hp("010-1234-1234")
                .age(23)
                .build();

        //when : 테스트를 진행하는 단계
        user1Service.insertUser1(sample);


        //then : 테스트 결과를 검증하는 단계 , Assert 단정문을 이용해 결과 출력
        User1DTO expected = user1Service.selectUser1(sample.getUid());

        Assertions.assertEquals(expected.toString(), sample.toString());
    }

    @Test
    void selectUser1() {

        //given
        String uid = "a202";

        //when
        User1DTO expected = user1Service.selectUser1(uid);

        //then
        Assertions.assertEquals(expected.getUid(), uid);
    }

    @Test
    void selectUser1s() {

        //given(매개변수 X , 샘플값 필요 x , 생략)
        List<User1DTO> expected = user1Service.selectUser1s();

        //then
        Assertions.assertFalse(expected.isEmpty()); //테스트통과 (false+false)
        //Assertions.assertTrue(expected.isEmpty()); //테스트 실패

    }

    @Test
    void updateUser1() {
        //given : 테스트를 실행하기 위한 준비단계 , 수정하려는 샘플 데이터
        User1DTO sample = User1DTO.builder()
                .uid("a202")
                .name("김유랑")
                .birth("1999-01-22")
                .hp("010-2222-2222")
                .age(23)
                .build();

        user1Service.updateUser1(sample);

        //then
        User1DTO expected = user1Service.selectUser1(sample.getUid());
        Assertions.assertEquals(expected.toString(), sample.toString());
    }


    @Test
    void deleteUser1() {

        String uid = "a202";
        user1Service.deleteUser1(uid);

        User1DTO expected = user1Service.selectUser1(uid);
        Assertions.assertNull(expected);
    }
}