package co.kr.wlgus.service;

import co.kr.wlgus.dto.User1;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@RequiredArgsConstructor
@Service
public class User1Service {

    private static final String KEY = "user1";

    private final RedisTemplate<String, User1> redisTemplate;

    // Create or Update
    public void save(User1 user) {
        redisTemplate.opsForHash().put(KEY, user.getUid(), user);
    }

    // Read
    @Cacheable(value="user1", key = "#uid")
    public User1 findByUid(String uid) {

        System.out.println("캐싱 후 해당 출력문은 출력안됨 ..."); //원래는 db에서 조회하는 것인데 redis로 읽어갔기때문에 출력문은 출력안됨
        return (User1) redisTemplate.opsForHash().get(KEY, uid);
    }

    // Read all
    public Map<Object, Object> findAll() {
        return redisTemplate.opsForHash().entries(KEY);
    }

    // Delete
    public void delete(String id) {
        redisTemplate.opsForHash().delete(KEY, id);
    }

}