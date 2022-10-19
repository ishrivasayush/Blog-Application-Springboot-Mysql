package com.Narainox.blog.BlogAppAPI.Entities;

import com.Narainox.blog.BlogAppAPI.Payloads.CategoryDto;
import com.Narainox.blog.BlogAppAPI.Payloads.UserDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int postId;

    private String title;

    @Column(length = 1000)
    private String content;

    private String imageName;

    private Date addedDate;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User user;

}
