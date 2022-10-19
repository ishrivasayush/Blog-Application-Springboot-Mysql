package com.Narainox.blog.BlogAppAPI.Payloads;

import com.Narainox.blog.BlogAppAPI.Entities.Category;
import com.Narainox.blog.BlogAppAPI.Entities.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PostDto {

    private String title;
    private String content;
    private String imageName;
    private Date addedDate;
    private UserDto user;
    private CategoryDto category;


}
