package com.example.farmstoryapiserver.controller;

import com.example.farmstoryapiserver.dto.ArticleDTO;
import com.example.farmstoryapiserver.service.ArticleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.RequestContextFilter;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final RequestContextFilter requestContextFilter;

    @PostMapping("/article")
    public ResponseEntity article(@RequestBody ArticleDTO articleDTO, HttpServletRequest req){
        articleDTO.setRegip(req.getRemoteAddr());

        //정보 안넘어옴 forbidden -> security때문에 -> 토큰의 ROLE을 실어 담아 보내야함 프론트에서 (ArticleAPI 참고)
        log.info("와오오옹 : " + articleDTO);

        int no = articleService.save(articleDTO);

        return ResponseEntity.ok().body(no);

    }
}
