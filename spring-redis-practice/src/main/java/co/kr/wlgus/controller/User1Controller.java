package co.kr.wlgus.controller;

import co.kr.wlgus.dto.User1;
import co.kr.wlgus.service.User1Service;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
public class User1Controller {

    private final User1Service user1Service;

    @PostMapping("/user1")
    public void insertUser(User1 user) {
        user1Service.save(user);
    }

    @GetMapping("/user1/{uid}")
    public ResponseEntity<User1> findByUid(@PathVariable("uid") String uid) {
        User1 user = user1Service.findByUid(uid);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/user1")
    public ResponseEntity<Map<Object, Object>> findAll() {
        Map<Object, Object> userMap = user1Service.findAll();
        return ResponseEntity.ok().body(userMap);
    }

    @PutMapping("/user1")
    public void updateUser(User1 user) {
        user1Service.save(user);
    }

    @DeleteMapping("/user1/{uid}")
    public void deleteUser(@PathVariable("uid") String uid) {
        user1Service.delete(uid);
    }


}