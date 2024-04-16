package com.sachin.blog.payloads;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

public class CategoryDto {
    
    private int categoryId;
    @NotEmpty(message = "Title cannot be empty")
    @Size(min = 3, message = "Title should be minimum 3 characters")
    private String categoryTitle;
    @NotEmpty(message = "Descrisption cannot be empty")
    @Size(min=3,message = "Description should be minimum 3 characters")
    private String categoryDescription;
    public CategoryDto() {
    }
    
    public CategoryDto(int categoryId,
            @NotEmpty(message = "Title cannot be empty") @Size(min = 3, message = "Title should be minimum 3 characters") String categoryTitle,
            @NotEmpty(message = "Descrisption cannot be empty") @Size(min = 3, message = "Description should be minimum 3 characters") String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryTitle = categoryTitle;
        this.categoryDescription = categoryDescription;
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
    public String getCategoryDescription() {
        return categoryDescription;
    }
    public void setCategoryDescription(String categoryDescrisption) {
        this.categoryDescription = categoryDescrisption;
    }


    
}
