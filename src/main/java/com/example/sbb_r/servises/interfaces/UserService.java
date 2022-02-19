package com.example.sbb_r.servises.interfaces;

import com.example.sbb_r.models.entities.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
     User createUser(User user);
}
