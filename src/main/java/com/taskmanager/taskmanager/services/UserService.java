package com.taskmanager.taskmanager.services;

import com.taskmanager.taskmanager.entities.User;
import com.taskmanager.taskmanager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }
    public User createUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(Long id, User userUpdated) {
        User user = userRepository.findById(id).orElse(null);
        if (user!=null) {
            user.setUserName(userUpdated.getUserName());
            user.setEmail(userUpdated.getEmail());
            user.setPassword(userUpdated.getPassword());
            return  userRepository.save(user);
        }
        return null;
    }
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
