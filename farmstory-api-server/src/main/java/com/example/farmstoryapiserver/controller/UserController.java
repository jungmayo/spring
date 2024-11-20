package com.example.farmstoryapiserver.controller;

import com.example.farmstoryapiserver.dto.UserDTO;
import com.example.farmstoryapiserver.entity.User;
import com.example.farmstoryapiserver.jwt.JwtProvider;
import com.example.farmstoryapiserver.security.MyUserDetails;
import com.example.farmstoryapiserver.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.query.named.ResultMemento;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Log4j2
@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;


    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO) {
        try {
            //시큐리티 사용자
            UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass());

            Authentication authentication = authenticationManager.authenticate(token);
            authentication.getPrincipal();

            MyUserDetails userDetails = (MyUserDetails) authentication.getPrincipal();
            User user = userDetails.getUser();
            log.info("user :" + user);

            // JWT 토큰 발행
            String accessToken = jwtProvider.createToken(user, 1);
            String refreshToken = jwtProvider.createToken(user, 7);
            log.info("accessToken :" + user);

            // 리프레쉬 토큰 DB 저장

            //토큰전송
            Map<String, Object> ResultMap = new HashMap<>();
            ResultMap.put("username", user.getUid());
            ResultMap.put("role", user.getRole());
            ResultMap.put("accessToken", accessToken);
            ResultMap.put("refreshToken", refreshToken);
            ResultMap.put("grantType", "Bearer");
            return ResponseEntity.ok(ResultMap);


        }catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("USER NOT FOUND");
        }

    }

    @PostMapping("/user")
    public ResponseEntity register(@RequestBody UserDTO userDTO){

        log.info("userDTO : " + userDTO);

        UserDTO savedUser = userService.save(userDTO);

        log.info("savedUser : " + savedUser);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(savedUser);
    }

}