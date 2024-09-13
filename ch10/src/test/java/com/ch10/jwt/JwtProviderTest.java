package com.ch10.jwt;

import com.ch10.entity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JwtProviderTest {

    @Autowired
    private JwtProvider jwtProvider;

    @Test
    void createToken() {

        User user = User.builder()
                .uid("a133")
                .name("김유신")
                .birth("1999-01-01")
                .role("ADMIN")
                .build();

        String jwt = jwtProvider.createToken(user, 1);
        System.out.println(jwt);
    }

    @Test
    void getClaims() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bGd1czU5NDZAbmF2ZXIuY29tIiwiaWF0IjoxNzI2MTIyOTM5LCJleHAiOjE3MjYyMDkzMzksInVzZXJuYW1lIjoiYTEzMyIsInJvbGUiOiJBRE1JTiJ9.5l9mbnUUZCD2f-127YyL1StfUHuWrFgR2gPoVqMp-XM";
        Claims claims = jwtProvider.getClaims(token);
        String username = (String) claims.get("username");
        String role = (String) claims.get("role");

        System.out.println(username + ", " + role);
    }

    @Test
    void getAuthentication() {
    }

    @Test
    void validateToken() {
        String token = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJ3bGd1czU5NDZAbmF2ZXIuY29tIiwiaWF0IjoxNzI2MTIzNzU1LCJleHAiOjE3MjYxMjM3NTUsInVzZXJuYW1lIjoiYTEzMyIsInJvbGUiOiJBRE1JTiJ9.19MagJgEtCNr26kITzDCgABu5niwLpvFNl-s-Z4qdZo";
        try{
            jwtProvider.validateToken(token);
            System.out.println("토큰 이상 없음");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}