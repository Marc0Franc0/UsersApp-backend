package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.UserResponse;
import com.app.security.user.User;
import com.app.service.UserServiceImpl;

@RestController
public class MainController {
    @Autowired
    UserServiceImpl service;

    @GetMapping("/")
    public ResponseEntity<List<UserResponse>> get() {

        return ResponseEntity.ok(service.getUsers());
    }
    @PutMapping("{id}")
    public ResponseEntity<String> modifyUser(@PathVariable Integer id, @RequestBody User user){

        return ResponseEntity.status(HttpStatus.OK).body(service.modifyUser(id, user));
    }

    @GetMapping("/rol/{email}")
    public ResponseEntity<Boolean> isAdmin(@PathVariable String email) {

        return ResponseEntity.ok(service.isAdmin(email));
    }

   
}
