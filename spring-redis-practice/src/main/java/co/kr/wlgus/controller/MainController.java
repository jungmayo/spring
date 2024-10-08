package co.kr.wlgus.controller;


import co.kr.wlgus.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RequiredArgsConstructor
@RestController
public class MainController {

    private final MainService mainService;

    @PostMapping("/redis/string")
    public void setValue(String key, String value) {
        mainService.setValue(key, value);
    }

    @GetMapping("/redis/string/{key}")
    public ResponseEntity<String> getValue(@PathVariable ("key") String key){
        String value = mainService.getValue(key);
        return ResponseEntity.ok().body(value);
    }

    @PostMapping("/redis/list-right")
    public void addToListFromRight(String key, String value) {
        mainService.addToListFromRight(key, value);
    }

    @PostMapping("/redis/list-left")
    public void addToListFromLeft(String key, String value) {
        mainService.addToListFromLeft(key, value);
    }

    @GetMapping("/redis/list/{key}/{index}")
    public ResponseEntity<String> getFromList(@PathVariable("key") String key, @PathVariable("index") int index){
        String value = mainService.getFromList(key, index);
        return ResponseEntity.ok().body(value);
    }


    @GetMapping("/redis/list/{key}/{start}/{end}")
    public ResponseEntity<List<String>> getRangeList(@PathVariable("key") String key,
                             @PathVariable("start") int start,
                             @PathVariable("end") int end){
        List<String> values = mainService.getRangeList(key, start, end);
        return ResponseEntity.ok().body(values);
    }

    @PostMapping("/redis/set")
    public void addToSet(String key, String[] value) {
        mainService.addToSet(key, value);
    }

    @GetMapping("/redis/set/{key}")
    public ResponseEntity<Set<String>> getFromSet(@PathVariable("key") String key){
        Set<String> values = mainService.getFromSet(key);
        return ResponseEntity.ok().body(values);
    }

    @PostMapping("/redis/hash")
    public void addToHash(String key, String hashKey, String value) {
        mainService.addToHash(key, hashKey, value);
    }

    @GetMapping("/redis/hash/{key}/{hashKey}")
    public ResponseEntity<String> getFromHash(@PathVariable("key") String key, @PathVariable("hashKey") String hashKey){
        String values = mainService.getFromHash(key, hashKey);
        return ResponseEntity.ok().body(values);
    }
}
