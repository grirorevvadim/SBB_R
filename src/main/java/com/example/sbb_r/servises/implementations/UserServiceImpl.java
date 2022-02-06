package com.example.sbb_r.servises.implementations;

import com.example.sbb_r.models.entities.User;
import com.example.sbb_r.servises.interfaces.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User createUser(User user) {
        return user;
    }
}
