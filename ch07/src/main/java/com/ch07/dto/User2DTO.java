package com.ch07.dto;

import com.ch07.entity.User2;
import lombok.*;
import org.apache.catalina.User;


@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
@Getter
public class User2DTO {
    private String uid;
    private String name;
    private String birth;
    private String hp;
    private String addr;



    //엔티티 변환 메서드
    public User2 toEntity(){
        //빌드 방식 생성
        return User2.builder()
                .uid(uid)
                .name(name)
                .birth(birth)
                .hp(hp)
                .addr(addr)
                .build();
    }
}
