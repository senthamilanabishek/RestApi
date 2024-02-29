package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.UserService;

@RestController
public class UserController {
    @Autowired
    UserService userservice;

    @PostMapping("/user/post")
    public User post(@RequestBody User u)
    {
        return userservice.userpost(u);
    }

    @GetMapping("/user/get/{userName}/{password}")
    public String get(@PathVariable String userName,@PathVariable String password)
    {
        return userservice.authentication(userName, password);
    }
}
