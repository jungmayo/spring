package com.example.farmstoryapiserver.repository;

import com.example.farmstoryapiserver.entity.Article;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Integer> {

    public Page<Article> findAllByCate(String cate, Pageable pageable);
}
