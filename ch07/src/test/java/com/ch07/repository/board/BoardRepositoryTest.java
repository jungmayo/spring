package com.ch07.repository.board;

import com.ch07.entity.board.Article;
import com.ch07.entity.board.Comment;
import com.ch07.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BoardRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private FileRepository fileRepository;

    @Autowired
    private UserRepository userRepository;


    //테스트 1 - 사용자 등록
    @Test
    void insertUserTest(){
        User user = User.builder()
                .uid("a102")
                .name("김춘추")
                .nick("춘추102")
                .email("chunchu@naver.com")
                .build();

        userRepository.save(user);
    }
    //테스트 2 - 글 등록
    @Test
    void insertArticleTest(){

        User user = User.builder()
                .uid("a101")
                .build();

        Article article = Article.builder()
                .title("제목1임다")
                .content("내용임다")
                .user(user)
                .build();

        articleRepository.save(article);

    }
    //테스트 3 - 댓글 등록
    @Test
    void insertCommentTest(){
        User user = User.builder()
                .uid("a102")
                .build();
        Article article = Article.builder()
                .no(1)
                .build();

        Comment comment = Comment.builder()
                .content("댓글1입다")
                .user(user)
                .article(article)
                .build();

        commentRepository.save(comment);

    }
}
