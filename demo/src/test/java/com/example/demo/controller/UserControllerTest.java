package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
@ComponentScan(basePackages = "com.example.demo")
public class UserControllerTest {
    
    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private UserService userService;
    
    @BeforeEach
    public void setup() {
        userService.createUser(new User(1L, "张三", 25, "zhangsan@example.com"));
        userService.createUser(new User(2L, "李四", 30, "lisi@example.com"));
    }
    
    @Test
    public void testGetAllUsers() throws Exception {
        mockMvc.perform(get("/api/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
    }
    
    @Test
    public void testGetUserById() throws Exception {
        mockMvc.perform(get("/api/users/1"))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testCreateUser() throws Exception {
        String userJson = "{\"username\":\"张三\",\"email\":\"zhangsan@example.com\",\"age\":25}";
        
        mockMvc.perform(post("/api/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testUpdateUser() throws Exception {
        String userJson = "{\"username\":\"李四更新\",\"email\":\"lisi_new@example.com\",\"age\":31}";
        
        mockMvc.perform(put("/api/users/1")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson))
                .andExpect(status().isOk());
    }
    
    @Test
    public void testDeleteUser() throws Exception {
        mockMvc.perform(delete("/api/users/1"))
                .andExpect(status().isOk());
    }
}