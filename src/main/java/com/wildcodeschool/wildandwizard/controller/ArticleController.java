package com.wildcodeschool.wildandwizard.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.wildcodeschool.wildandwizard.entity.Article;
import com.wildcodeschool.wildandwizard.repository.ArticleRepository;

import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles")
    public List<Article> index() {
        // if (!cat.isEmpty()) {
            // return articleRepository.findAllArticlesByCategorieId(cat);
        // }
        return articleRepository.findAll();
    }
    @GetMapping("/articles/cat")
    public List<Article> byCat(long cat) {
        // if (!cat.isEmpty()) {
            return articleRepository.findAllByCategorieId(cat);
            // return articleRepository.findAllArticlesByCategorieId(cat);
        // }
        // return articleRepository.findAll();
    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).get();
    }

    @PostMapping("/articles")
    public Article create(@RequestBody Article article){
        return articleRepository.save(article);
    }

    @PutMapping("/articles/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article){
        // getting blog
        Article articleToUpdate = articleRepository.findById(id).get();
        articleToUpdate.setTitle(article.getTitle());
        articleToUpdate.setDescription(article.getDescription());
        articleToUpdate.setDate(article.getDate());
        articleToUpdate.setPicture(article.getPicture());
        articleToUpdate.setCategorie(article.getCategorie());
        return articleRepository.save(articleToUpdate);
    }


    @DeleteMapping("articles/{id}")
    public boolean delete(@PathVariable Long id){
        articleRepository.deleteById(id);
        return true;
    }
    
}
