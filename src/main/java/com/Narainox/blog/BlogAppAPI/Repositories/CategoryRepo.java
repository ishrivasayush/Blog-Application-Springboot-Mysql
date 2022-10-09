package com.Narainox.blog.BlogAppAPI.Repositories;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepo extends JpaRepository<Category,Integer> {

}
