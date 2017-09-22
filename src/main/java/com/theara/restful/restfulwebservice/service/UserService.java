package com.theara.restful.restfulwebservice.service;

import com.theara.restful.restfulwebservice.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Integer id);

    User save(User user);

    User deleteUserById(int id);

}
