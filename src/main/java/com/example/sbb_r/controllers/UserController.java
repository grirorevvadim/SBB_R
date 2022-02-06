package com.example.sbb_r.controllers;

import com.example.sbb_r.models.dtos.UserDto;
import com.example.sbb_r.models.entities.User;
import com.example.sbb_r.models.mappers.UserMapper;
import com.example.sbb_r.servises.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public User createUser(@RequestBody UserDto userDto) {

        return userService.createUser(userMapper.dtoToEntity(userDto));
    }
}
