package com.eidiko.springboot_jwt.spring_boot_jwt_example.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private String userId;
    private String userName;
    private String userEmail;

}
