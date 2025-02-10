package com.demo.operational.repository;

import com.demo.operational.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends BaseRepository<User,Integer> {
    User findByUsernameAndPassword(String username, String password);
}
