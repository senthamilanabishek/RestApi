package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepo;

@Service
public class UserService {
    @Autowired
    UserRepo repo;

    public User userpost(User ob)
    {
        return repo.save(ob);
    }

    public String authentication(String username,String password)
    {
        if(repo.authentified(username,password)!=null)
        {
            return ("Login Successful");
        }
        else
        {
            return ("password or username is incorrect");
        }

    }
}
