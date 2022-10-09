package com.Narainox.blog.BlogAppAPI.Controllers;

import com.Narainox.blog.BlogAppAPI.Payloads.ApiResponse;
import com.Narainox.blog.BlogAppAPI.Payloads.CategoryDto;
import com.Narainox.blog.BlogAppAPI.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    //create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto)
    {
        CategoryDto categoryDto1=categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(categoryDto1, HttpStatus.CREATED);
    }

    //update
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody  CategoryDto categoryDto,@PathVariable int id)
    {
        CategoryDto categoryDto1=categoryService.updateCategory(id,categoryDto);
        return new ResponseEntity<>(categoryDto1,HttpStatus.OK);
    }

    //delete
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse> deleteCategory(@PathVariable int id)
    {
        categoryService.deleteCategory(id);
        return new  ResponseEntity<>(new ApiResponse("Delete Category Successfully",false),HttpStatus.OK);
    }

    //getAll
    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getCategory()
    {
        List<CategoryDto> categoryDtoList=categoryService.getAll();
        return new ResponseEntity<>(categoryDtoList,HttpStatus.OK);
    }

    //get
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable int id)
    {
        CategoryDto categoryDto=categoryService.get(id);
        return new ResponseEntity<>(categoryDto,HttpStatus.OK);
    }
}
