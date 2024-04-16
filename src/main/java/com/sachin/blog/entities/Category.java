package com.sachin.blog.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer categoryId;
    private String categoryTitle;
    private String categoryDescrisption;
    public Category() {
    }
    
    public Category(int categoryId, String categoryTitle, String categoryDescrisption) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescrisption = categoryDescrisption;
    }

    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getCategoryTitle() {
        return categoryTitle;
    }
    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }
    public String getCategoryDescrisption() {
        return categoryDescrisption;
    }
    public void setCategoryDescrisption(String categoryDescrisption) {
        this.categoryDescrisption = categoryDescrisption;
    }
    
}
