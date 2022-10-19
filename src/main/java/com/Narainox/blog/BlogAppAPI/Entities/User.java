package com.Narainox.blog.BlogAppAPI.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/*
@Entity(here we can give the name of entity)
@table(here we can give the name of db table)
 */
@Entity
@Table(name="users")
/*
This will create the No args constructor as we as getter and setter with the help of lombok
 */
@NoArgsConstructor
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   //gives By the hibernate
    private int id;

    @Column(name="user_name",nullable = false,length = 100)
    private String name;

    private String email;

    private String password;

    private String about;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)   //if we are removing the parent than the child ia slo removed by itself
    private List<Post> posts=new ArrayList<>();
}
