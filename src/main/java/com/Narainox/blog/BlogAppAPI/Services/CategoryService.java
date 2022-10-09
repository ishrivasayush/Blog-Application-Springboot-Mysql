package com.Narainox.blog.BlogAppAPI.Services;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import com.Narainox.blog.BlogAppAPI.Payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
    //create
    CategoryDto createCategory(CategoryDto category);
    //update
    CategoryDto updateCategory(int id,CategoryDto category);
    //get
    CategoryDto get(int id);
    //getAll
    List<CategoryDto> getAll();
    //delete
    void deleteCategory(int id);
}
