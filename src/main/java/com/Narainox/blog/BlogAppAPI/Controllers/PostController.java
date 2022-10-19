package com.Narainox.blog.BlogAppAPI.Controllers;

import com.Narainox.blog.BlogAppAPI.Entities.Post;
import com.Narainox.blog.BlogAppAPI.Payloads.ApiResponse;
import com.Narainox.blog.BlogAppAPI.Payloads.PostDto;
import com.Narainox.blog.BlogAppAPI.Services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PostController {

    @Autowired
    PostService postService;

    @PostMapping("/user/{userId}/category/{categoryId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId, @PathVariable Integer categoryId)
    {
        PostDto post= postService.createPost(postDto,userId,categoryId);
        return new ResponseEntity<PostDto>(post, HttpStatus.CREATED);
    }

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId)
    {
        List<PostDto> postByCategory = postService.getPostByCategory(categoryId);
        return new ResponseEntity<>(postByCategory,HttpStatus.OK);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostByUserId(@PathVariable Integer userId)
    {
        List<PostDto> postByCategory = postService.getPostByCategory(userId);
        return new ResponseEntity<>(postByCategory,HttpStatus.OK);
    }

    @GetMapping("/post/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId)
    {
        PostDto postById = postService.getPostById(postId);
        return new ResponseEntity<>(postById,HttpStatus.OK);
    }

    @GetMapping("/post")
    public ResponseEntity<List<PostDto>> getAllPost()
    {
        List<PostDto> postDtos = postService.getAllPost();
        return new ResponseEntity<>(postDtos,HttpStatus.OK);
    }

    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePostById(@PathVariable Integer postId)
    {
        postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Deleted Sucessfully",true),HttpStatus.OK);
    }

    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@RequestBody PostDto postDto,@PathVariable Integer postId)
    {
        PostDto updatePost = postService.updatePost(postDto, postId);
        return new ResponseEntity<>(updatePost,HttpStatus.OK);
    }


}
