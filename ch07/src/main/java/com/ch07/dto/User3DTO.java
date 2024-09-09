package com.ch07.dto;

import com.ch07.entity.User3;
import lombok.*;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User3DTO {

    private String uid;
    private String name;
    private String birth;
    private String hp;
    private String addr;

    public User3 toEntity(){
        return User3.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }

}
