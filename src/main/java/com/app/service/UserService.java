package com.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.app.model.UserResponse;
import com.app.security.user.User;
@Service
public interface UserService {
    public List<UserResponse> getUsers();
    public String modifyUser(Integer id,User user);
    public boolean isAdmin(String email);
}
