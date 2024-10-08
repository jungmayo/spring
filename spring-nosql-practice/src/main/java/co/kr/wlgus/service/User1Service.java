package co.kr.wlgus.service;

import co.kr.wlgus.document.User1Document;
import co.kr.wlgus.repository.User1Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class User1Service {

    private final User1Repository user1Repository;


    public List<User1Document> findAllUser1(){ //변환하기
        List<User1Document> user1List = user1Repository.findAll();
        return user1List;
    }

    public User1Document findUser1(String uid){
        Optional<User1Document> optuser1 = user1Repository.findByUid(uid);

        if(optuser1.isPresent()){
            User1Document user1 = optuser1.get();
            return user1;
        }
        return null;
    }


    public User1Document insertUser1(User1Document user1){
        user1Repository.save(user1);
        return user1;
    }


    public User1Document updateUser1(User1Document user1){
        Optional<User1Document> exuser1= user1Repository.findByUid(user1.getUid());
        if(exuser1.isPresent()){
            User1Document user1s = exuser1.get();
            user1s.setName(user1.getName());
            user1s.setAge(user1.getAge());
            user1s.setAddr(user1.getAddr());
            return user1Repository.save(user1s);
        }
       return null;
    }


    public boolean deleteUser1(String uid){
        Optional<User1Document> optUser1 = user1Repository.deleteByUid(uid);

        if(optUser1.isPresent()){
            return true;
        }
        return false;
    }
}


