package com.wildcodeschool.wildandwizard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wildcodeschool.wildandwizard.entity.Message;
import com.wildcodeschool.wildandwizard.repository.MessageRepository;

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
