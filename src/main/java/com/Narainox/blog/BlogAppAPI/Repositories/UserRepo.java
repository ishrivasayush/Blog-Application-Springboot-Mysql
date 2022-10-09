package com.Narainox.blog.BlogAppAPI.Repositories;

import com.Narainox.blog.BlogAppAPI.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Integer>
{

}
