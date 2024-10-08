package co.kr.wlgus.controller;


import co.kr.wlgus.document.User1Document;
import co.kr.wlgus.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class User1Controller {

    private final User1Service user1Service;

    @GetMapping("/user1")
    public ResponseEntity<List<User1Document>> findAllUser1(){
        List<User1Document> user1List = user1Service.findAllUser1();
        return ResponseEntity.status(HttpStatus.OK).body(user1List);
    }

    @GetMapping("/user1/{uid}")
    public ResponseEntity<User1Document> findUser1(@PathVariable("uid") String uid){
        User1Document user1 = user1Service.findUser1(uid);
        if(user1 != null) {
            return ResponseEntity.ok().body(user1);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/user1")
    public ResponseEntity<User1Document> insertUser1(User1Document user1){
        User1Document savedUser1 = user1Service.insertUser1(user1);
        return ResponseEntity.ok().body(savedUser1);
    }

    @PutMapping("/user1")
    public ResponseEntity<User1Document> updateUser1(User1Document user1){
        User1Document modifyUser1 = user1Service.updateUser1(user1);

        return ResponseEntity.ok().body(modifyUser1);

    }

    @DeleteMapping("/user1/{uid}")
    public ResponseEntity<Boolean> deleteUser1(@PathVariable("uid") String uid){
        boolean result = user1Service.deleteUser1(uid);
        return ResponseEntity.ok().body(result);
    }
}
