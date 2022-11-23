package com.wildcodeschool.wildandwizard.controller;

import org.hibernate.annotations.Any;
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
        return articleRepository.findAll();
    }
    @GetMapping("/articles/cat")
    public List<Article> byCat(long cat) {
            return articleRepository.findAllByCategorieId(cat);
    }

    @GetMapping("/articles/{id}")
    public Article show(@PathVariable Long id){
        return articleRepository.findById(id).get();
    }

    @PostMapping("/articles")
    public Article create(@RequestBody Article article,@RequestHeader("Authorization") String header){
        System.out.println("header : " + header);
        System.out.println("header : " + header.equals("toto"));
        if (header.equals("toto")){
            return articleRepository.save(article);
        }
        return null;
    }

    @PutMapping("/articles/{id}")
    public Article update(@PathVariable Long id, @RequestBody Article article,@RequestHeader("Authorization") String header){
        System.out.println("header : " + header);
        System.out.println("header : " + header.equals("toto"));
        if (header.equals("toto")){
            Article articleToUpdate = articleRepository.findById(id).get();
            articleToUpdate.setTitle(article.getTitle());
            articleToUpdate.setDescription(article.getDescription());
            articleToUpdate.setDate(article.getDate());
            articleToUpdate.setPicture(article.getPicture());
            articleToUpdate.setCategorie(article.getCategorie());
            return articleRepository.save(articleToUpdate);
        }
        return null;


    }


    @DeleteMapping("articles/{id}")
    public boolean delete(@PathVariable Long id,@RequestHeader("Authorization") String header){
        System.out.println("header : " + header);
        System.out.println("header : " + header.equals("toto"));
        if (header.equals("toto")){
            articleRepository.deleteById(id);
            return true;
        }
        return false;


    }
    
}
