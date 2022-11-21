package com.wildcodeschool.wildandwizard.controller;

import org.hibernate.type.descriptor.sql.BigIntTypeDescriptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wildcodeschool.wildandwizard.entity.Article;
import com.wildcodeschool.wildandwizard.entity.Message;
import com.wildcodeschool.wildandwizard.repository.ArticleRepository;
import com.wildcodeschool.wildandwizard.repository.CategorieRepository;
import com.wildcodeschool.wildandwizard.repository.MessageRepository;

import java.lang.reflect.*;
import java.math.BigInteger;
import java.util.*;

@CrossOrigin(origins = "*")
@RestController
public class MessageController {

    @Autowired
    private MessageRepository messageRepository;

    @GetMapping("/messages")
    public List<Message> index() {
        return messageRepository.findAll();
    }

    @GetMapping("/messages/{id}")
    public Message show(@PathVariable Long id){
        return messageRepository.findById(id).get();
    }

    @PostMapping("/messages")
    public Message create(@RequestBody Message message){
        return messageRepository.save(message);
    }

    @DeleteMapping("messages/{id}")
    public boolean delete(@PathVariable Long id){
        messageRepository.deleteById(id);
        return true;
    }
}
