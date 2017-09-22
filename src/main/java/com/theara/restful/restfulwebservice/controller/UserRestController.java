package com.theara.restful.restfulwebservice.controller;

import com.theara.restful.restfulwebservice.model.User;
import com.theara.restful.restfulwebservice.exception.UserNotFoundException;
import com.theara.restful.restfulwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController()
public class UserRestController {

    private UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);

        if(user == null)
            throw new UserNotFoundException("id-" + id);

        return user;
    }

    @PostMapping("users")
    public ResponseEntity saveUser(@RequestBody User user){
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

}
