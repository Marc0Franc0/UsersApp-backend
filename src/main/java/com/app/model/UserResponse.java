package com.app.model;

import lombok.Data;

@Data
public class UserResponse {

    private Integer id;
    private String firstname;
    private String lastname;
    private String email;
}
