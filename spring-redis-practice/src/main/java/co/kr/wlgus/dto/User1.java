package co.kr.wlgus.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User1 implements Serializable {
    private String uid;
    private String name;
    private int age;
    private String addr;
}