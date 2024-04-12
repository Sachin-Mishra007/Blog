package com.sachin.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.blog.entities.User;

public interface UserRepository extends JpaRepository<User,Integer> {

}
