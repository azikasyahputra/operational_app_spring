package com.demo.operational.service;

import com.demo.operational.model.User;
import com.demo.operational.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends CrudService<User> {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return userRepository.findByUsernameAndPassword(username, password);
    }
}
