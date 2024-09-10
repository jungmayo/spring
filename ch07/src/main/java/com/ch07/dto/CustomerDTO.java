package com.ch07.dto;

import lombok.Data;

@Data
public class CustomerDTO {

    private String custId;
    private String name;
    private String hp;
    private int age;
    private String addr;
    private String regDate;

    // 추가 필드
    private long orderCount;
}
