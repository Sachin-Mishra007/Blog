package com.sachin.blog.services;

import java.util.List;

import com.sachin.blog.payloads.UserDto;

public interface UserServices {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user, Integer id);
    UserDto getUser(Integer id);
    void deleteUser(Integer id);
    List<UserDto> getAllUsers();

}
