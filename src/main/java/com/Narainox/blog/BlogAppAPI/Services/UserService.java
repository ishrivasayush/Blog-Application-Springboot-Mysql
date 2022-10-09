package com.Narainox.blog.BlogAppAPI.Services;
import com.Narainox.blog.BlogAppAPI.Payloads.UserDto;

import java.util.List;

public interface UserService {

    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Integer userId);
    UserDto getUserById(Integer userId);
    List<UserDto> getAllUsers();
    void deleteUser(Integer userid);
}
