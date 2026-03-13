package com.example.demo.service;
 
import com.example.demo.model.User;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;
    
    @AfterEach
    public void cleanup() {
        List<User> users = new ArrayList<>(userService.getAllUsers());
        for (User user : users) {
            userService.deleteUser(user.getId());
        }
    }
    
    @Test
    public void testGetAllUsers() {
        List<User> users = userService.getAllUsers();
        assertNotNull(users);
    }

    @Test
    public void testCreateUser() {
        User user = new User(1L, "testuser", 25, "test@example.com");
        userService.createUser(user);
        User createdUser = userService.getUserById(1L);
        assertNotNull(createdUser);
        assertEquals(user.getUsername(), createdUser.getUsername());
        assertEquals(user.getAge(), createdUser.getAge());
        assertEquals(user.getEmail(), createdUser.getEmail());
    }

    @Test
    public void testGetUserById() {
        User user = new User(1L, "testuser", 25, "test@example.com");
        userService.createUser(user);
        User retrievedUser = userService.getUserById(1L);
        assertNotNull(retrievedUser);
        assertEquals(user.getId(), retrievedUser.getId());
        assertEquals(user.getUsername(), retrievedUser.getUsername());
        assertEquals(user.getAge(), retrievedUser.getAge());
        assertEquals(user.getEmail(), retrievedUser.getEmail());
    }
    
    @Test
    public void testUpdateUser() {
        User user = new User(1L, "testuser", 25, "test@example.com");
        userService.createUser(user);
        user.setUsername("updateduser");
        user.setAge(30);
        user.setEmail("updated@example.com");
        userService.updateUser(user);
        User updatedUser = userService.getUserById(1L);
        assertNotNull(updatedUser);
        assertEquals(user.getUsername(), updatedUser.getUsername());
        assertEquals(user.getAge(), updatedUser.getAge());
        assertEquals(user.getEmail(), updatedUser.getEmail());
    }
    
    @Test
    public void testDeleteUser() {
        User user = new User(1L, "testuser", 25, "test@example.com");
        userService.createUser(user);
        userService.deleteUser(1L);
        User deletedUser = userService.getUserById(1L);
        assertNull(deletedUser);
    }

}
