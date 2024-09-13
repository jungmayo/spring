package com.ch09.controller;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.service.User1Service;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.juli.logging.Log;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Controller
public class User1Controller {

    private final User1Service user1Service;
//요청 메서드로 구분한 Get POST PUT DELETE로

    @ResponseBody// 자바객체를 JSON으로 자동변환 /html 화면을 띄우는 것이 아니라 데이터를 클라이언트로 보내기 위해서
    @GetMapping("/user1")
    public List<User1DTO> list(){
        List<User1DTO> users = user1Service.selectUser1s();
        //view forward 불가 -> 클라이언트로 바로 보내줘야함
        return users; //이 리스트가 JSON 배열로 변환+리스트 형식으로 클라이언트에 전송됨
    }

    @ResponseBody
    @GetMapping("/user1/{uid}")
    public User1DTO user(@PathVariable("uid") String uid){
        User1DTO user = user1Service.selectUser1(uid);
        return user;
    }


    @ResponseBody
    @PostMapping("/user1") //데이터를 서버에 제출하거나 변경하는 용도, 화면에 출력하지 않음
    public ResponseEntity register(@RequestBody @Valid User1DTO user1DTO){ //JSON객체를 JAVA객체로 변환+ valid를 붙여줘야 유효성 검사가 제대로 들어감
        log.info(user1DTO);
        User1 savedUser1 = user1Service.insertUser1(user1DTO);

        //http 요청의 200번대는 성공 , 400번대는 클라이언트 에러, 500번대 서버 에러
        //응답개체 ResponseEntity.status(HttpStatus.CREATED).body(savedUser1);
        // ResponseEntity로 변환할 경우 @ResponseBody 생략가능
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedUser1);//savedUser1;
    }
    @ResponseBody
    @PutMapping("/user1") //화면 출력 X, 데이터를 제출 변경하는 용도
    public ResponseEntity modify(@RequestBody @Valid User1DTO user1DTO){
        log.info(user1DTO);
        User1 modifiedUser1 = user1Service.updateUser1(user1DTO);

        return ResponseEntity
                .status(HttpStatus.ACCEPTED) // 202
                .body(modifiedUser1);
    }

    @ResponseBody
    @DeleteMapping("/user1/{uid}") // 화면 출력 X, 데이터를 제출, 변경하는 용도
    public ResponseEntity delete(@PathVariable("uid")String uid){ //직접 추출된 값, 별도의 변환 필요 X
        //사용자 찾지 못함에 대한 예외를 발생시켜서 처리하기
        try{
            user1Service.deleteUser1(uid);
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
