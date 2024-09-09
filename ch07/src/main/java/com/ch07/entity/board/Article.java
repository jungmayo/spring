package com.ch07.entity.board;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "board_article")
public class Article {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int no;

    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY) //LAZY 생략가능
    @JoinColumn(name = "writer")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<File> file;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;

}
