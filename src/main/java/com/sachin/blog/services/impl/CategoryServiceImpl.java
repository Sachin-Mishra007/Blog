package com.sachin.blog.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sachin.blog.entities.Category;
import com.sachin.blog.exceptions.ResourceNotFoundException;
import com.sachin.blog.payloads.CategoryDto;
import com.sachin.blog.payloads.ModelMapper;
import com.sachin.blog.reposetories.CategoryRepository;
import com.sachin.blog.services.CategoryService;
@Service
public class CategoryServiceImpl implements CategoryService{
    CategoryRepository categoryRepository;
    

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
       Category newCategory=ModelMapper.toCategory(categoryDto);
       Category saveCategory=categoryRepository.save(newCategory);
       return ModelMapper.toCategoryDto(saveCategory);
       
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
        Category category=categoryRepository.findById(categoryId).orElseThrow(()->(new ResourceNotFoundException("Category", categoryId)));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescrisption(categoryDto.getCategoryDescription());
        Category savCategory=categoryRepository.save(category);
        return ModelMapper.toCategoryDto(savCategory);

    }

    @Override
    public void deleteCategory(Integer categoryId) {
       Category category=categoryRepository.findById(categoryId).orElseThrow(()->(new ResourceNotFoundException("Category", categoryId)));
       categoryRepository.delete(category);
    }

    @Override
    public List<CategoryDto> getAllCategory() {
       List<Category> categoryList=new ArrayList<>();
       categoryList=categoryRepository.findAll();
       List<CategoryDto> categoryDtos=new ArrayList<>();
       for (Category category : categoryList) {
            categoryDtos.add(ModelMapper.toCategoryDto(category));
        
       }
       return categoryDtos;
    }

    @Override
    public CategoryDto viewCategory(Integer categoryId) {
        Category category= categoryRepository.findById(categoryId).orElseThrow(()->(new ResourceNotFoundException("Category", categoryId)));
        return ModelMapper.toCategoryDto(category);
    }

}
