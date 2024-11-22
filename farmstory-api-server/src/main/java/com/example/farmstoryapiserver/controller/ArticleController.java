package com.example.farmstoryapiserver.controller;

import com.example.farmstoryapiserver.dto.ArticleDTO;
import com.example.farmstoryapiserver.dto.PageRequestDTO;
import com.example.farmstoryapiserver.dto.PageResponseDTO;
import com.example.farmstoryapiserver.service.ArticleService;
import jakarta.annotation.security.PermitAll;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.hibernate.internal.build.AllowSysOut;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.filter.RequestContextFilter;

import java.util.List;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ArticleController {

    private final ArticleService articleService;
    private final RequestContextFilter requestContextFilter;

    @PermitAll // 모든 사용자에게 접근을 허용
    @GetMapping("/article/{cate}/{pg}")
    public PageResponseDTO list(PageRequestDTO pageRequestDTO) {

        PageResponseDTO pageResponseDTO = articleService.findAll(pageRequestDTO);
        return pageResponseDTO;

//        PageResponseDTO responseDTO = PageResponseDTO.builder()
//                                        .dtoList(dtoList)
//                                        .build();
//        return responseDTO;

    }

    @PostMapping("/article")
    public ResponseEntity article(@RequestBody ArticleDTO articleDTO, HttpServletRequest req){
        articleDTO.setRegip(req.getRemoteAddr());

        //정보 안넘어옴 forbidden -> security때문에 -> 토큰의 ROLE을 실어 담아 보내야함 프론트에서 (ArticleAPI 참고)
        log.info("와오오옹 : " + articleDTO);

        int no = articleService.save(articleDTO);

        return ResponseEntity.ok().body(no);

    }
}
