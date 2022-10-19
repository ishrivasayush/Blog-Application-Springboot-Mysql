package com.Narainox.blog.BlogAppAPI.Services;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import com.Narainox.blog.BlogAppAPI.Entities.Post;
import com.Narainox.blog.BlogAppAPI.Entities.User;
import com.Narainox.blog.BlogAppAPI.Payloads.PostDto;

import java.util.List;

public interface PostService {
    //create
    PostDto createPost(PostDto postDto,Integer categoryId,Integer userId);
    //delete
    void deletePost(Integer postId);
    //update
    PostDto updatePost(PostDto postDto,Integer postId);
    //get
    List<PostDto> getAllPost();
    // get Single Post
    PostDto getPostById(Integer posttId);
    //get all post by id
    List<PostDto> getPostByCategory(Integer categoryId);
    //get post by user
    List<PostDto> getPostByUser(Integer userId);
    // search post by String
    Post getPostBySearch(String search);

}
