package com.Narainox.blog.BlogAppAPI.Controllers;
import com.Narainox.blog.BlogAppAPI.Payloads.ApiResponse;
import com.Narainox.blog.BlogAppAPI.Payloads.UserDto;
import com.Narainox.blog.BlogAppAPI.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/users")
public class Usercontroller {

    @Autowired
    private UserService userService;

    //POST-create User
    @PostMapping("/")
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto){
        UserDto user = userService.createUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    //PUT-update User
    @PutMapping("/{userId}")
    public ResponseEntity<UserDto> updateUser(@RequestBody UserDto userDto,@PathVariable int userId)
    {
        UserDto updatedUser=userService.updateUser(userDto,userId);
        return new ResponseEntity<>(updatedUser,HttpStatus.OK);
    }

    //DELETE-delete user
    @DeleteMapping("/{userId}")
    public ResponseEntity<?> deleteUser(@PathVariable int userId)
    {
        userService.deleteUser(userId);
        return new ResponseEntity<>(new ApiResponse("User deleted sucessfully",true),HttpStatus.OK);
    }

    //GET- user get
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable int id)
    {
        return ResponseEntity.ok(userService.getUserById(id));
    }

    //GET- user get
    @GetMapping("/")
    public  ResponseEntity<List<UserDto>> getAllUser()
    {
        return ResponseEntity.ok(userService.getAllUsers());
    }
}
