package com.example.farmstoryapiserver.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int no;

    private String cate;

    @Builder.Default
    private int comment = 0;
    private String title;
    private String content;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="writer", referencedColumnName = "uid")
    private User user;

    @Builder.Default
    private int file = 0;
    @Builder.Default
    private int hit = 0;

    @CreationTimestamp
    private LocalDateTime regDate;

    private String regip;
}
