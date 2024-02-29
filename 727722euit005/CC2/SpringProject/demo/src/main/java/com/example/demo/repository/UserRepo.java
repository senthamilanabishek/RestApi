package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.model.User;

@Repository
public interface UserRepo extends JpaRepository<User,Integer>{
    @Query(value = "select * from user u where u.user_name=?1 and u.password=?2",nativeQuery = true)
    public String authentified(String username,String password);
}
