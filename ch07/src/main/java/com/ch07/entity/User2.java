package com.ch07.entity;

import com.ch07.dto.User2DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table (name = "user2")
public class User2 {

    @Id
    private String uid;

    private String name;

    private String birth;

    private String hp;

    private String addr;


    //DTO 변환 메서드
    public User2DTO toDTO(){
        return User2DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
}
