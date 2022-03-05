package com.example.sbb_r.servises.implementations;

import com.example.sbb_r.exceptions.UserNotFound;
import com.example.sbb_r.models.entities.User;
import com.example.sbb_r.repositories.UserRepository;
import com.example.sbb_r.servises.interfaces.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    @Transactional
    public User createUser(User user) {
        user.setEmailVerificationStatus(true);
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);
        return user;
    }

    @Override
    public User getUser(String email) {
        var user = userRepository.findUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);
        return user;
    }

    @Override
    public User getUserById(long id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFound("User with id: " + id + " isn't found");
        return user.get();
    }

    @Override
    public User updateUser(User entity) {
        User original = userRepository.findUserByEmail(entity.getEmail());
        if (entity.getBirthdate() != null) original.setBirthdate(entity.getBirthdate());
        if (entity.getFirstname() != null) original.setFirstname(entity.getFirstname());
        if (entity.getLastname() != null) original.setLastname(entity.getLastname());
        if (entity.getWallet() != 0) original.setWallet(entity.getWallet());
        userRepository.save(original);
        return entity;
    }

    @Override
    public String deleteUser(long id) {
        var user = userRepository.findById(id);
        if (user.isEmpty()) throw new UserNotFound("user with id: " + id + " was not found");
        userRepository.delete(user.get());
        return "User with id " + id + " was successfully deleted";
    }

    @Override
    public User getUserByEmail(String email) {
        var user = userRepository.findUserByEmail(email);
        if (user == null) throw new UserNotFound("User with email: " + email + " isn't found");
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var user = userRepository.findUserByEmail(email);
        if (user == null) throw new UsernameNotFoundException(email);
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }
}
