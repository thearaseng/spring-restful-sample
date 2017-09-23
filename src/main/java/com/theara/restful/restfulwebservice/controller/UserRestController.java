package com.theara.restful.restfulwebservice.controller;

import com.theara.restful.restfulwebservice.model.User;
import com.theara.restful.restfulwebservice.exception.UserNotFoundException;
import com.theara.restful.restfulwebservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;

import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
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
    public Resource<User> getUserById(@PathVariable Integer id){
        User user = userService.getUserById(id);

        if(user == null)
            throw new UserNotFoundException("id-" + id);

        Resource<User> resource = new Resource<>(user);

        ControllerLinkBuilder linkBuilder =
                linkTo(methodOn(this.getClass()).getAllUsers());

        resource.add(linkBuilder.withRel("all-users"));

        return resource;
    }

    @PostMapping("users")
    public ResponseEntity saveUser(@Valid @RequestBody User user){
        User savedUser = userService.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUserById(@PathVariable Integer id){
        User user = userService.deleteUserById(id);

        if(user == null)
            throw new UserNotFoundException("id-" + id);
    }

}
