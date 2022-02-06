package com.example.sbb_r.servises.implementations;

import com.example.sbb_r.models.entities.User;
import com.example.sbb_r.repositories.UserRepository;
import com.example.sbb_r.servises.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    @Transactional
    public User createUser(User user) {
        userRepository.save(user);
        return user;
    }
}
