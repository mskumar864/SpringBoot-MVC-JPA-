package com.example.SpringMVCDemo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SpringMVCDemo.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{

}
