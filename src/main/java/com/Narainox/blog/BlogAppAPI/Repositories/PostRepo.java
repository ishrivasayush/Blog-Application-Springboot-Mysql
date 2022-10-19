package com.Narainox.blog.BlogAppAPI.Repositories;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import com.Narainox.blog.BlogAppAPI.Entities.Post;
import com.Narainox.blog.BlogAppAPI.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post,Integer> {


    //Get all the post of user
    List<Post> findByUser(User user);
    //Get all the Post of Category
    List<Post> findByCategory(Category category);
}
