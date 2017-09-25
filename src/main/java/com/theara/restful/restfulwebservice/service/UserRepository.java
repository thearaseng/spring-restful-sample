package com.theara.restful.restfulwebservice.service;

import com.theara.restful.restfulwebservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

}
