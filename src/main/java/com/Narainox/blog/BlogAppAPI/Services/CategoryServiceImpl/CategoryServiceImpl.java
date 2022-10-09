package com.Narainox.blog.BlogAppAPI.Services.CategoryServiceImpl;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import com.Narainox.blog.BlogAppAPI.Exception.ResourceNotFoundException;
import com.Narainox.blog.BlogAppAPI.Payloads.CategoryDto;
import com.Narainox.blog.BlogAppAPI.Repositories.CategoryRepo;
import com.Narainox.blog.BlogAppAPI.Services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryRepo categoryRepo;

    @Autowired
    ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category=categoryDtoToCategory(categoryDto);
        Category save=categoryRepo.save(category);
        return categoryToCategoryDto(save);
    }

    @Override
    public CategoryDto updateCategory(int id, CategoryDto categoryDto) {
        Category category=categoryRepo.findById(id).orElseThrow(()-> new  ResourceNotFoundException("category","categoryId",id));

        category.setCategoryName(categoryDto.getCategoryName());
        category.setCategoryDescription(category.getCategoryDescription());

        Category save=categoryRepo.save(category);
        return categoryToCategoryDto(save);
    }

    @Override
    public CategoryDto get(int id) {
        Category category=categoryRepo.findById(id).orElseThrow(()-> new  ResourceNotFoundException("user","id",id));
        return categoryToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> categoryList=categoryRepo.findAll();
        List<CategoryDto> collect = categoryList.stream().map(category -> categoryToCategoryDto(category)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteCategory(int id) {
        Category category=categoryRepo.findById(id).orElseThrow(()-> new  ResourceNotFoundException("user","id",id));
        categoryRepo.delete(category);
    }

    public CategoryDto categoryToCategoryDto(Category category)
    {
        CategoryDto categoryDto= modelMapper.map(category,CategoryDto.class);
        return categoryDto;
    }
    public Category categoryDtoToCategory(CategoryDto categoryDto)
    {
        Category category=modelMapper.map(categoryDto,Category.class);
        return category;
    }
}
