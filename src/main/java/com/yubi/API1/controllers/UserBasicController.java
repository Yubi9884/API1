package com.yubi.API1.controllers;

import com.yubi.API1.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserBasicController {
    @GetMapping("/users_basic_string")
    public String getUsers(){
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", "john@op.ac.nz"));
        users.add(new User(2, "Sara", "sara@op.ac.nz"));
        users.add(new User(3, "Josh", "josh@op.ac.nz"));
        return users.toString();
    }
    @GetMapping("/users_basic_json")
    public List<User> getUsers2(){
        List<User> users = new ArrayList<>();
        users.add(new User(1, "John", "john@op.ac.nz"));
        users.add(new User(2, "Sara", "sara@op.ac.nz"));
        users.add(new User(3, "Josh", "josh@op.ac.nz"));
        return users;
    }

}
