package com.ch07.repository.board;

import com.ch07.entity.board.Article;
import com.ch07.entity.board.Comment;
import com.ch07.entity.board.File;
import com.ch07.entity.board.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    // 테스트 4 - 파일 등록
    @Test
    void insertFileTest(){
        Article article = Article.builder()
                .no(1)
                .build();

        File file = File.builder()
                .oName("테스트")
                .sName("xptmxm")
                .article(article)
                .build();
        fileRepository.save(file);
    }

    // 테스트 5 - 글 조회 // 연관설정된 엔티티를 조회할 때 트랜잭션을 사용해주어야 함
    @Transactional
    @Test
    void selectArticlesTest(){
        List<Article> articles = articleRepository.findAll();
        //System.out.println(articles);
        for(Article article : articles){
            List<Comment> comments = article.getComment();
            List<File> files = article.getFile();

            System.out.println(files);
            System.out.println(comments);
        }
    }

}
