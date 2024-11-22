package com.example.farmstoryapiserver.service;

import com.example.farmstoryapiserver.dto.ArticleDTO;
import com.example.farmstoryapiserver.dto.PageRequestDTO;
import com.example.farmstoryapiserver.dto.PageResponseDTO;
import com.example.farmstoryapiserver.entity.Article;
import com.example.farmstoryapiserver.entity.User;
import com.example.farmstoryapiserver.repository.ArticleRepository;
import jakarta.persistence.Tuple;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ModelMapper modelMapper;
    private final ArticleRepository articleRepository;

    //글등록
    public int save(ArticleDTO articleDTO) {
        Article article = modelMapper.map(articleDTO, Article.class);

        User user = User.builder()
                .uid(articleDTO.getWriter())
                .build();

        article.setUser(user);

        Article savedArticle = articleRepository.save(article);
        return savedArticle.getNo();



    }

    // 글 목록
    public PageResponseDTO<ArticleDTO> findAll(PageRequestDTO pageRequestDTO){


        Pageable pageable = pageRequestDTO.getPageable("no"); //pg-1 , size , no의 내림차순 정렬

        Page<Article> pageArticle = articleRepository.findAllByCate(pageRequestDTO.getCate(), pageable);

        // 튜플 리스트 -> DTO 리스트 변환 // 1개의 리스트에 10개의 튜플이 있고, 튜플안에 여러개의 키밸류가있음(no=1,title=머시기)-> 이 값은 article이고 뒤의 따로 정의한 Nick은 String으로 , 따라서 0은 article, 1은 nick이 된다.
        List<ArticleDTO> articleList = pageArticle.getContent().stream()
                .map(entity -> {
                    ArticleDTO articleDTO = modelMapper.map(entity, ArticleDTO.class);
                    articleDTO.setWriter(entity.getUser().getNick());

                    return articleDTO;
                }).toList();

        int total = (int) pageArticle.getTotalElements(); // 튜플이 몇개있는지 (10개) 한페이지에 보여지는 글 갯수

        return PageResponseDTO.<ArticleDTO>builder()
                .pageRequestDTO(pageRequestDTO)
                .dtoList(articleList)
                .total(total)
                .build();

//        List<Article> articles = articleRepository.findAll();
//
//        List<ArticleDTO> dtoList = articles.stream().map(entity -> {
//                ArticleDTO aritcleDTO = modelMapper.map(entity, ArticleDTO.class);
//                aritcleDTO.setWriter(entity.getUser().getUid());
//                return aritcleDTO;
//    }).toList();
//        return dtoList;
    }


}
