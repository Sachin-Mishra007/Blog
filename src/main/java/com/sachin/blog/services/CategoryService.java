package com.sachin.blog.services;

import java.util.List;



import com.sachin.blog.payloads.CategoryDto;
public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);
    CategoryDto viewCategory(Integer categoryId);
    void deleteCategory(Integer categoryId);
    List<CategoryDto> getAllCategory();
}
