package com.sachin.blog.contollers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sachin.blog.payloads.UserDto;
import com.sachin.blog.services.UserServices;

@RestController
@RequestMapping("/api/users")
public class UserController {
    UserServices userServices;
    
    public UserController(UserServices userServices) {
        this.userServices=userServices;
    }
    @PostMapping
    ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto)
    {
        return new ResponseEntity<>(userServices.createUser(userDto),HttpStatus.CREATED);
    }
    @GetMapping
    ResponseEntity<List<UserDto>> getAllUsers()
    {
       List<UserDto> userDtoList=userServices.getAllUsers();
       return ResponseEntity.ok(userDtoList);

    }
    @PutMapping("/{id}")
    ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto ,@PathVariable int id)
    {
        UserDto updatedUserDto=userServices.updateUser(userDto, id);
        return ResponseEntity.ok(updatedUserDto);
    }
    @DeleteMapping("/{id}")
    ResponseEntity<String> deleteUser(@PathVariable int id)
    {
        userServices.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }
    @GetMapping("/{id}")
    ResponseEntity<UserDto> getUserbyId(@PathVariable int id)
    {
        return ResponseEntity.ok(userServices.getUser(id));
    }
}
