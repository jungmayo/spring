package com.ch07.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity
@Table (name = "user5")
public class User5 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 해당 필드(컬럼)값이 자동으로 1 증가(auto_increments 어노테이션)
    private int seq;

    private String name;
    private String gender;
    private int age;
    private String addr;
}
