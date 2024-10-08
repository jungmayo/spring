package co.kr.wlgus.dto;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User1DTO {

    private String uid;
    private String name;
    private int age;
    private String addr;
}
