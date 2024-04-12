package com.sachin.blog.payloads;

import com.sachin.blog.entities.User;

public class ModelMapper {
    public static UserDto toUserDto(User user)
    {
        return new UserDto(user.getId(),user.getName(),user.getEmail(),user.getPassword(),user.getAbout());
        
    }
    public static User toUser(UserDto userDto)
    {
        return new User(userDto.getId(), userDto.getName(),userDto.getEmail(), userDto.getPassword(),userDto.getAbout());
    }

}
