package com.sachin.blog.reposetories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sachin.blog.entities.Category;


public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
