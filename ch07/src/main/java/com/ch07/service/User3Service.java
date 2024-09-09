package com.ch07.service;

import com.ch07.dto.User3DTO;
import com.ch07.entity.User3;
import com.ch07.repository.User3Repository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class User3Service {

    private final User3Repository user3Repository;

    public void insertUser3(User3DTO user3DTO){
        User3 entity = user3DTO.toEntity();
        user3Repository.save(entity);
    }
    public User3DTO selectUser3(String uid){
        Optional<User3> opt = user3Repository.findById(uid);
        if(opt.isPresent()){
            User3 user3 = opt.get();
            return user3.toDTO();
        }
        return null;
    }
    public List<User3DTO> selectUser3s(){
        List<User3> user3s = user3Repository.findAll();
        List<User3DTO> users = user3s.stream().map(entity -> entity.toDTO()).collect(Collectors.toList());
        return users;
    }
    public void updateUser3(User3DTO user3DTO){
        boolean result = user3Repository.existsById(user3DTO.getUid());

        if(result){
            User3 entity = user3DTO.toEntity();
            user3Repository.save(entity);
        }
    }
    public void deleteUser3(String uid){
        user3Repository.deleteById(uid);

    }

}
