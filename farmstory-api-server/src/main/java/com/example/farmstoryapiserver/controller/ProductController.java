package com.example.farmstoryapiserver.controller;

import com.example.farmstoryapiserver.dto.PageRequestDTO;
import com.example.farmstoryapiserver.dto.PageResponseDTO;
import com.example.farmstoryapiserver.dto.ProductDTO;
import com.example.farmstoryapiserver.service.ProductService;
import com.example.farmstoryapiserver.util.CustomFileUtil;
import jakarta.servlet.http.HttpServletResponse;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.aspectj.util.FileUtil;
import org.modelmapper.ModelMapper;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

@Log4j2
@RequiredArgsConstructor
@RestController
public class ProductController {

    private final ProductService productService;
    private final CustomFileUtil customFileUtil;

    @GetMapping("/product/{pg}")
    public PageResponseDTO<ProductDTO> list(PageRequestDTO pageRequestDTO){

        PageResponseDTO<ProductDTO> pageResponseDTO = productService.list(pageRequestDTO);
        log.info(pageResponseDTO);

        return pageResponseDTO;
    }
    @GetMapping("/product/thumb/{fileName}")
    public ResponseEntity<Resource> thumbnail(@PathVariable String fileName){
        return customFileUtil.getFile(fileName);
    }

    @PostMapping("/product")
    public Map<String, Integer> register(ProductDTO productDTO) {
        log.info(productDTO);

        List<MultipartFile> files =  productDTO.getThumbFiles();

        //파일저장 (oname sname 표 형태로 첫째줄 왼쪽 o, 오른쪽 s)
        Map<String, String> uploadFileNames = customFileUtil.saveFiles(files);

        //oName 형태로 저장
        productDTO.setThumbNames(uploadFileNames);

        //등록후 상품 번호 리턴
        int pno = productService.register(productDTO);

        return Map.of("pno", pno);

    }
}
