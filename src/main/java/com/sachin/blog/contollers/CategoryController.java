package com.sachin.blog.contollers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sachin.blog.payloads.CategoryDto;
import com.sachin.blog.services.CategoryService;
import org.springframework.web.bind.annotation.RequestBody;
import jakarta.validation.Valid;

@Validated
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    private CategoryService categoryService;
    

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    ResponseEntity<CategoryDto> createCategory(@RequestBody  @Valid CategoryDto categoryDto)
    {
        return new ResponseEntity<>(categoryService.createCategory(categoryDto),HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    ResponseEntity<CategoryDto> viewCategory(@PathVariable Integer id)
    {
        return  ResponseEntity.ok(categoryService.viewCategory(id));
    }
    @PutMapping("/{id}")
    ResponseEntity<CategoryDto> updateCategory(@RequestBody  @Valid CategoryDto categoryDto, @PathVariable int id)
    {
        return ResponseEntity.ok(categoryService.updateCategory(categoryDto, id));
    }
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteCategory(@PathVariable int id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok("Category deleted successfully");
    }
    @GetMapping
    ResponseEntity<List<CategoryDto>> getAllCategories()
    {
        return ResponseEntity.ok(categoryService.getAllCategory());
    } 
}
