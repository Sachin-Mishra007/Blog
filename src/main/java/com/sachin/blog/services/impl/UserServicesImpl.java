package com.sachin.blog.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.sachin.blog.entities.User;
import com.sachin.blog.exceptions.ResourceNotFoundException;
import com.sachin.blog.payloads.ModelMapper;
import com.sachin.blog.payloads.UserDto;
import com.sachin.blog.reposetories.UserRepository;
import com.sachin.blog.services.UserServices;
@Service
public class UserServicesImpl implements UserServices {
    UserRepository userRepository;
    
   
    public UserServicesImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user=userRepository.save(ModelMapper.toUser(userDto));
        return ModelMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UserDto userDto, Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User", id));
        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setAbout(userDto.getAbout());
        User saveUser=userRepository.save(user);
        return ModelMapper.toUserDto(saveUser);

    }

    @Override
    public UserDto getUser(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("User",id));
        return ModelMapper.toUserDto(user);
    }

    @Override
    public void deleteUser(Integer id) {
        User user=userRepository.findById(id).orElseThrow(()->(new ResourceNotFoundException("User", id)));
        userRepository.delete(user);
    }

    @Override
    public List<UserDto> getAllUsers() {
        List <UserDto>userDtoList=new ArrayList<>();
        List<User> userList=userRepository.findAll();
        if(userList.size()==0)
        throw new RuntimeException("No users are registerd");
        for (User user : userList) {
            userDtoList.add(ModelMapper.toUserDto(user));
        }
        return userDtoList;
    }

}
