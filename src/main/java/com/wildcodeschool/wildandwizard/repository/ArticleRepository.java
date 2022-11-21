package com.wildcodeschool.wildandwizard.repository;

import com.wildcodeschool.wildandwizard.entity.Article;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByCategorieId(long categorieId);
}