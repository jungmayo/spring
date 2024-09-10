package com.ch07.entity.board;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = {"file","comment"})
@Builder
@Entity
@Table(name = "board_article")
public class Article {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int no;

    private String title;
    private String content;

    /*
        @ManyToOne
          - N : 1 관계설정
          - Article 엔티티와 User 엔티티간의 관계와 방향성을 고려해서 연관관계를 설정
          - Article 엔티티가 조회될 때 User 엔티티도 함께 조회
        @JoinColumn
          - User 엔티티가 참조되는 테이블 칼럼 설정
          - name 속성은 컬럼명
    */
    @ManyToOne(fetch = FetchType.LAZY) //LAZY 생략가능
    @JoinColumn(name = "writer")
    private User user;

    /*
        @OnetoMany
          - 1 : N 관계설정 , 일반적으로 양방향 관계 설정 , 참조 타입이 List인 엔티티
          - Article 엔티티와 File 엔티티간의 관계와 방향성을 고려해서 연관관계를 설정
          - Article 엔티티가 조회될 때 File 엔티티도 함께 조회
          - mappedBy 속성은 양방향 관계에서 기준이 되는 속성을 설정, FK(외래키)가 되는 엔티티 속성


         @Transactional
           - 양방향으로 처리되는 연관관계에서 다수의 SELECT를 트랜잭션으로 수행
           - 하나의 SELECT는 한번의 세션 처리로 트랜잭션 처리를 하지 않으면 no session 에러 발생
           - 하나 실행하고 꺼지는 느낌이라 트랜잭션 있어야 함
           - 트랜잭션으로 처리하기 위해서 처리 메서드에 @transational 선언

         @ToString(exclude="제외할 속성")
           - 엔티티간 양방향 관계설정에서 toString()을 호출할 경우 무한순환 호출이 실행되기때문에 제외를 시켜주어야 한다.
           - 무한순환 호출이 발생하면 StackOverFlow 에러 발생
           - 양방향으로 관계설정된 엔티티에서 어느 한쪽을 toString에서 제외

    */


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<File> file;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "article")
    private List<Comment> comment;

    @CreationTimestamp
    private LocalDateTime rdate;

}
