package com.example.sbb_r.models.mappers;

import com.example.sbb_r.models.dtos.UserDto;
import com.example.sbb_r.models.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserMapper {

    public User dtoToEntity(UserDto userDto) {
        User user = new User();
        user.setFirstname(userDto.getFirstname());
        user.setLastname(userDto.getLastname());
        user.setWallet(userDto.getWallet());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setBirthdate(userDto.getBirthdate());
        return user;
    }

    public UserDto entityToDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setFirstname(user.getFirstname());
        userDto.setLastname(user.getLastname());
        userDto.setEmail(user.getEmail());
        userDto.setWallet(user.getWallet());
        userDto.setPassword(user.getPassword());
        userDto.setBirthdate(user.getBirthdate());
        return userDto;
    }

    public List<UserDto> entitiesToDtos(List<User> users) {
        List<UserDto> userDtos = new ArrayList<>();
        for (User u : users) {
            userDtos.add(entityToDto(u));
        }
        return userDtos;
    }

    public List<User> DtosToEntities(List<UserDto> dtos) {
        List<User> users = new ArrayList<>();
        for (UserDto u : dtos) {
            users.add(dtoToEntity(u));
        }
        return users;
    }
}

