package com.example.sbb_r.repositories;

import com.example.sbb_r.models.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Long> {
    User findUserByEmail(String email);
}
