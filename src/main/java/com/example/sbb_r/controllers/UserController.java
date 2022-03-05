package com.example.sbb_r.controllers;

import com.example.sbb_r.models.dtos.UserDto;
import com.example.sbb_r.models.entities.User;
import com.example.sbb_r.models.mappers.UserMapper;
import com.example.sbb_r.servises.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final UserMapper userMapper;

    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        User user = userService.createUser(userMapper.dtoToEntity(userDto));
        return userMapper.entityToDto(user);
    }

    @PutMapping(path = "/{id}")
    public UserDto updateUser(@PathVariable long id, @RequestBody UserDto userDto) {
        User user = userService.updateUser(userMapper.dtoToEntity(userDto));
        return userMapper.entityToDto(user);
    }

    @DeleteMapping(path = "/{id}")
    public String deleteUser(@PathVariable long id) {
        return userService.deleteUser(id);
    }

    @GetMapping(path = "/{id}")
    public UserDto getUser(@PathVariable long id) {
        return userMapper.entityToDto(userService.getUserById(id));
    }

    @GetMapping()
    public UserDto getUserByEmail(@RequestParam String email) {
        return userMapper.entityToDto(userService.getUserByEmail(email));
    }
}
