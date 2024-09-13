package com.ch09.controller;

import com.ch09.dto.User2DTO;
import com.ch09.entity.User2;
import com.ch09.service.User2Service;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor

//REST API용 컨트롤러 어노테이션
@RestController //무조건 JSON으로 변환 출력 -> ResponseBody는 생략가능
public class User2Controller {

    private final User2Service user2Service;

    @ResponseBody
    @GetMapping("/user2")
    public List<User2DTO> list(){
        List<User2DTO> user2s = user2Service.selectUser2s();
        return user2s;
    }
    @ResponseBody
    @GetMapping("/user2/{uid}")
    public User2DTO user(@PathVariable("uid") String uid){
        User2DTO user2 = user2Service.selectUser2(uid);
        return user2;
    }
    @ResponseBody
    @PostMapping("/user2")
    public ResponseEntity register(@RequestBody User2DTO user2DTO){
        User2 savedUser2 = user2Service.insertUser2(user2DTO);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser2);
    }

    @ResponseBody
    @PutMapping("/user2")
    public ResponseEntity modify(@RequestBody User2DTO user2DTO){
        User2 modifiedUser2 = user2Service.updateUser2(user2DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)
                .body(modifiedUser2);
    }

    @ResponseBody
    @DeleteMapping("/user2/{uid}")
    public ResponseEntity delete(@PathVariable("uid") String uid){

        try{
            user2Service.deleteUser2(uid);
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body("success");
        }catch(EntityNotFoundException e){
            log.error(e);
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }
}
