package com.eidiko.springboot_jwt.spring_boot_jwt_example.service;

import com.eidiko.springboot_jwt.spring_boot_jwt_example.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User(UUID.randomUUID().toString(),"Adil","adil@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(),"Raza","raza@gmail.com"));

        users.add(new User(UUID.randomUUID().toString(),"Akash","akash@gmail.com"));
        users.add(new User(UUID.randomUUID().toString(),"Chandu","chandu@gmail.com"));

    }

    public List<User> getUsers(){
        return this.users;
    }
}
