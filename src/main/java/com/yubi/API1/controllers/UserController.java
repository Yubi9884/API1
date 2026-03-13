package com.yubi.API1.controllers;

import com.yubi.API1.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private List<User> users;

    public UserController() {
        users = new ArrayList<>();
        users.add(new User(1, "John", "john@op.ac.nz"));
        users.add(new User(2, "Sara", "sara@op.ac.nz"));
        users.add(new User(3, "Josh", "josh@op.ac.nz"));
    }
    @GetMapping
    public List<User> getUsers(){
        return users;
    }

    @PostMapping
    public String addUser (@RequestBody User user){
        users.add(user);
        return "Users added Successfully";

    }
    @DeleteMapping("/{id}")
    public String deleteUser (@PathVariable int id){
        for(User u:users){
            if(u.getId()== id){
                users.remove(u);
                return "Users deleted Successfully";
            }
        }
        return "Users not found with id "+ id;

    }
    @PutMapping
    public String updateUser(@RequestBody User user){
        int id = user.getId();
        for(User u:users){
            if(u.getId()==id){
                u.setName(user.getName());
                u.setEmail(user.getEmail());
                return "User updated successfully";
            }
        }
        return "Users not found with id "+ id;

    }

}
