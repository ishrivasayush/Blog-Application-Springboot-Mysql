package com.Narainox.blog.BlogAppAPI.Services.UserServiceImpl;
import com.Narainox.blog.BlogAppAPI.Entities.User;
import com.Narainox.blog.BlogAppAPI.Exception.ResourceNotFoundException;
import com.Narainox.blog.BlogAppAPI.Payloads.UserDto;
import com.Narainox.blog.BlogAppAPI.Repositories.UserRepo;
import com.Narainox.blog.BlogAppAPI.Services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=dtoUserToUser(userDto);
        User save = userRepo.save(user);
        return userToDtoUser(save);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer userId) {
        User user=userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("User"," id ",userId));

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(user.getAbout());

        User updateUser=userRepo.save(user);
        UserDto userDto1 = userToDtoUser(updateUser);
        return userDto1;
    }

    @Override
    public UserDto getUserById(Integer userId) {
        User user=userRepo.findById(userId).
                orElseThrow(()->new ResourceNotFoundException("user","id",userId));
        UserDto userDto = userToDtoUser(user);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        List<UserDto> collect = users.stream().map(user->userToDtoUser(user)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public void deleteUser(Integer userid) {
        User user=userRepo.findById(userid).orElseThrow(()->new ResourceNotFoundException("user","id",userid));
        userRepo.delete(user);
    }

    //convert the UserDto object to User object
    private User dtoUserToUser(UserDto userDto)
    {
//        User user=new User();
//        user.setId(userDto.getId());
//        user.setName(userDto.getName());
//        user.setEmail(userDto.getEmail());
//        user.setPassword(userDto.getPassword());
//        user.setAbout(userDto.getAbout());
//        return user;

        User user1=this.modelMapper.map(userDto,User.class);
        return user1;
    }

    //convert the User object to UserDto object
    private UserDto userToDtoUser(User user)
    {
//        UserDto userDto=new UserDto();
//        userDto.setId(user.getId());
//        userDto.setName(user.getName());
//        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
//        userDto.setAbout(user.getAbout());
        UserDto userDto1=this.modelMapper.map(user,UserDto.class);
        return userDto1;
    }

    /*
    Model Mapper depandancy Maven Repo we add in pom.xml file.
    -Declare the bean in Application
    @Bean
    public ModelMapper modelMapper()
    {
        return new ModelMapper();
    }

    -Add it to service

    -

     */
}
