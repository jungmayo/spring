package com.ch09.service;

import com.ch09.dto.User1DTO;
import com.ch09.entity.User1;
import com.ch09.repository.User1Repository;
import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User1Service {

    // 생성자 주입
    private final User1Repository user1Repository;

    public User1 insertUser1(User1DTO user1DTO) {

        // DTO를 Entity로 변환
        User1 entity = user1DTO.toEntity();

        // Entity 저장(데이터베이스 Insert)
        // insert함과 동시에 select값도 함께
        //User1 savedEntity = user1Repository.save(entity);
        return user1Repository.save(entity);

    }

    public User1DTO selectUser1(String uid){
        /*
            Optional
             - null 체크 검정을 손쉽고 안전하게 처리하기 위한 클래스
             - Spring JPA find~ 메서드의 결과 타입
         */
        Optional<User1> opt = user1Repository.findById(uid);

        // Entity 존재 여부 확인
        if(opt.isPresent()){
            // Optional 타입으로 정의된 Entity 가져오기
            User1 user1 = opt.get();

            // Entity를 DTO로 변환해서 반환
            return user1.toDTO();
        }
        return null;
    }

    public List<User1DTO> selectUser1s(){

        // Entity 전체 조회
        List<User1> user1s = user1Repository.findAll();

        // for(외부 반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        /*
        List<User1DTO> user1DTOS = new ArrayList<>();

        for(User1 user1 : user1s){
            user1DTOS.add(user1.toDTO());
        }
        */

        // List stream(내부 반복자)를 이용한 Entity 리스트를 DTO 리스트로 변환
        //stream : 각 요소를 하나한 처리하기 위해서
        //map : 스트림의 각 요소를 DTO로 변환
        //collect : DTO를 다시 리스트로 변환
        List<User1DTO> users = user1s
                .stream()
                .map(entity -> entity.toDTO())
                .collect(Collectors.toList());
        return users;
    }

    public User1 updateUser1(User1DTO user1DTO) {

        // Entity 존재여부 확인
        boolean result = user1Repository.existsById(user1DTO.getUid());

        if(result){
            // DTO를 Entity로 변환
            User1 entity = user1DTO.toEntity();

            // Entity 수정(데이터베이스 Update)
            return user1Repository.save(entity);
        }
        return null;
    }

    public void deleteUser1(String uid) {
        // Entity 삭제(데이터베이스 Delete)

        if (!user1Repository.existsById(uid)) {
            throw new EntityNotFoundException("user not found"); //요청한 곳으로 예외 던지기
        }
            user1Repository.deleteById(uid);
        }
    }
