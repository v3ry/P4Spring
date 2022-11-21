package com.wildcodeschool.wildandwizard.entity;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    
    @OneToMany(mappedBy = "categorie", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Article> articles;

    public Categorie(){}

    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }


    public List<Article> getArticles() {
        return articles;
    }


    public void setArticles(List<Article> articles) {
        this.articles = articles;
    }
    
}
