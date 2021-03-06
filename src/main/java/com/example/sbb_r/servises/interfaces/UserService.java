package com.example.sbb_r.servises.interfaces;

import com.example.sbb_r.models.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User createUser(User user);

    User getUser(String email);

    User getUserById(long id);

    User updateUser(User entity);

    String deleteUser(long id);

    User getUserByEmail(String email);

    List<User> getUsers(int page, int limit);
}
