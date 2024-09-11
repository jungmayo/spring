package com.ch09.dto;

import com.ch09.entity.User1;
import lombok.*;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User1DTO {
    private String uid;
    private String name;
    private String hp;
    private String birth;
    private int age;

    public User1 toEntity(){
        return User1.builder()
                .uid(uid)
                .name(name)
                .hp(hp)
                .birth(birth)
                .age(age)
                .build();
    }
}
