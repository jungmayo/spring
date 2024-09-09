package com.ch07.entity;

import com.ch07.dto.User3DTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Entity
@Table (name = "user3")
public class User3 {

    @Id
    private String uid;

    private String name;

    private String birth;

    private String hp;

    private String addr;



    public User3DTO toDTO(){

        return User3DTO.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
}
