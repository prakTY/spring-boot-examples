package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {
        return users;
    }

    public User getUserById(Long id) {
        return users.stream()
                .filter(user -> user.getId() != null && user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void createUser(User user) {
        users.add(user);
    }
    
    public void updateUser(User user) {
        User existingUser = getUserById(user.getId());
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setAge(user.getAge());
            existingUser.setEmail(user.getEmail());
        }
    }
    
    public void deleteUser(Long id) {
        users.removeIf(user -> user.getId() != null && user.getId().equals(id));
    }
}
