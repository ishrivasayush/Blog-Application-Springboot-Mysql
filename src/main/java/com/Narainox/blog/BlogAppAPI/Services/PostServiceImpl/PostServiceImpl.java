package com.Narainox.blog.BlogAppAPI.Services.PostServiceImpl;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import com.Narainox.blog.BlogAppAPI.Entities.Post;
import com.Narainox.blog.BlogAppAPI.Entities.User;
import com.Narainox.blog.BlogAppAPI.Exception.ResourceNotFoundException;
import com.Narainox.blog.BlogAppAPI.Payloads.CategoryDto;
import com.Narainox.blog.BlogAppAPI.Payloads.PostDto;
import com.Narainox.blog.BlogAppAPI.Repositories.CategoryRepo;
import com.Narainox.blog.BlogAppAPI.Repositories.PostRepo;
import com.Narainox.blog.BlogAppAPI.Repositories.UserRepo;
import com.Narainox.blog.BlogAppAPI.Services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    UserRepo userRepo;

    @Autowired
    CategoryRepo categoryRepo;


    @Override
    public PostDto createPost(PostDto postDto, Integer categoryId, Integer userId) {
        Category category=categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","Id",categoryId));
        User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("user","Id",userId));
        Post post=modelMapper.map(postDto,Post.class);
        post.setAddedDate(new Date());
        post.setImageName("Default.jpg");
        post.setCategory(category);
        post.setUser(user);
        Post save = postRepo.save(post);
        return modelMapper.map(save,PostDto.class);
    }

    @Override
    public void deletePost(Integer postId) {
        Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
        postRepo.delete(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, Integer postId) {
        Post post=postRepo.findById(postId).orElseThrow(()->new ResourceNotFoundException("Post","PostId",postId));
        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());
        post.setImageName(post.getImageName());
        Post save = postRepo.save(post);
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getAllPost() {
        List<Post> posts = postRepo.findAll();
        List<PostDto> collect = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public PostDto getPostById(Integer postId) {
        Post post = postRepo.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Post", "PostId", postId));
        return modelMapper.map(post,PostDto.class);
    }

    @Override
    public List<PostDto> getPostByCategory(Integer categoryId) {
        Category category=categoryRepo.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category","id",categoryId));
        List<Post> postRepoByCategory = postRepo.findByCategory(category);
        List<PostDto> collect = postRepoByCategory.stream().map(post->modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public List<PostDto> getPostByUser(Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User","UserId",userId));
        List<Post> posts = postRepo.findByUser(user);
        List<PostDto> collect = posts.stream().map(post -> modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public Post getPostBySearch(String search) {
        return null;
    }
}
