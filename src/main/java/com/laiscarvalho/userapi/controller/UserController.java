package com.laiscarvalho.userapi.controller;

import com.laiscarvalho.userapi.dto.UserDto;
import com.laiscarvalho.userapi.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List;

@RestController
public class UserController {

    private UserService userService;


    @GetMapping("/")
    public String getMessage() {
        return "Spring boot is working";
    }


    @GetMapping("/user/all")
    public List<UserDto> getAllUser() {
        List<UserDto> users = userService.getAll();
        return users;
    }

    @GetMapping("/user/{cpf}")
    public UserDto getUser(@PathVariable String cpf) {
        UserDto userDto = userService.findByCpf(cpf);
        return userDto;
    }


    @PostMapping("/newUser")
    public UserDto postUser(@RequestBody UserDto userDto) {
        UserDto savedUser = userService.save(userDto);
        return savedUser;

    }

    @DeleteMapping("/user/{id}")
    public UserDto deleteUSer(@PathVariable long id) throws UserPrincipalNotFoundException {
        return userService.delete(id);
    }

    @GetMapping("/user/serach")
    public List<UserDto> findByName(@RequestParam(required = true) String name) {
        List<UserDto> userDto = userService.findByName(name);
        return userDto;
    }

}
