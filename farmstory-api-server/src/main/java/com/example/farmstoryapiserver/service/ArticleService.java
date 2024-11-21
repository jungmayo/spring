package com.example.farmstoryapiserver.service;

import com.example.farmstoryapiserver.dto.ArticleDTO;
import com.example.farmstoryapiserver.entity.Article;
import com.example.farmstoryapiserver.entity.User;
import com.example.farmstoryapiserver.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    public int save(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);

        User user = User.builder()
                .uid(articleDTO.getWriter())
                .build();

        article.setUser(user);

        Article savedArticle = articleRepository.save(article);
        return savedArticle.getNo();



    }


}
