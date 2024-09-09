package com.ch07.repository;

import com.ch07.entity.Child;
import com.ch07.entity.Parent;
import com.ch07.entity.User1;
import jakarta.persistence.Id;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class User1RepositoryTest {

    @Autowired
    private User1Repository user1Repository;


    @Test
    void findUser1ByUid() {
        User1 entity = user1Repository.findUser1ByUid("ㅎㅎ");
        System.out.println(entity);
    }

    @Test
    void findUser1ByName() {
        List<User1> users = user1Repository.findUser1ByName("ㅎㅎ");
        System.out.println(users);

    }

    @Test
    void findUser1ByNameNot() {
        List<User1> users = user1Repository.findUser1ByNameNot("ㅎㅎ");
        System.out.println(users);
    }

    //uid와name이 공통적으로 존재하는 값
    @Test
    void findUser1ByUidAndName() {
        User1 entity = user1Repository.findUser1ByUidAndName("ㅎㅎ","김유신");
        System.out.println(entity);
    }

    //입력한 uid 또는 name의 값
    @Test
    void findUser1ByUidOrName() {
        List<User1> users = user1Repository.findUser1ByUidOrName("ㅎㅎ","김유신");
        System.out.println(users);
    }

    //입력한 값보다 큰 값들 모두
    @Test
    void findUser1ByAgeGreaterThan() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThan(18);
        System.out.println(users);
    }

    //입력한 값과 동일하거나 큰 값들 모두
    @Test
    void findUser1ByAgeGreaterThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeGreaterThanEqual(18);
        System.out.println(users);
    }

    //입력한 값보다 작은 값
    @Test
    void findUser1ByAgeLessThan() {
        List<User1> users = user1Repository.findUser1ByAgeLessThan(18);
        System.out.println(users);
    }

    //입력한 값보다 작거나 같은
    @Test
    void findUser1ByAgeLessThanEqual() {
        List<User1> users = user1Repository.findUser1ByAgeLessThanEqual(18);
        System.out.println(users);
    }
    //작은값에서 큰값까지
    @Test
    void findUser1ByAgeBetween() {
        List<User1> users = user1Repository.findUser1ByAgeBetween(24,32);
        System.out.println(users);
    }

    //입력한 값과 동일한 값
    @Test
    void findUser1ByNameLike() {
        List<User1> users = user1Repository.findUser1ByNameLike("김");
        System.out.println(users);
    }

    //입력한 값을 포함하는 쿼리
    @Test
    void findUser1ByNameContains() {
        List<User1> users = user1Repository.findUser1ByNameContains("김");
        System.out.println(users);
    }
    //입력한값으로 시작하는 쿼리
    @Test
    void findUser1ByNameStartsWith() {
        List<User1> users = user1Repository.findUser1ByNameStartsWith("김");
        System.out.println(users);
    }
    //입력한 값으로 끝나는 쿼리
    @Test
    void findUser1ByNameEndsWith() {
        List<User1> users = user1Repository.findUser1ByNameEndsWith("신");
        System.out.println(users);
    }

    @Test
    void selectUser1UnderAge30() {
    }

    @Test
    void selectUser1WhereName() {
    }

    @Test
    void selectUser1WhereNameParam() {
    }

    @Test
    void selectFromParentJoinChild() {
        List<Object[]> list = user1Repository.selectFromParentJoinChild("p101");

        System.out.println(list.toString());

        for(Object[] obj : list) {
            Parent parent = (Parent) obj[0];
            Child child = (Child) obj[1];

            System.out.println(parent);
            System.out.println(child);
        }
    }
}