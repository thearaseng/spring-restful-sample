package com.theara.restful.restfulwebservice;

import com.theara.restful.restfulwebservice.model.User;
import com.theara.restful.restfulwebservice.service.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    private static final Logger log =
            LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private UserRepository userRepository;

    @Override
    public void run(String... strings) throws Exception {
        User user = new User("Theara Seng", new Date());
        userRepository.save(user);
        log.info("New User created : " + user);

        User userWithIdOne = userRepository.findOne(1);
        log.info("Retrieved User : " + userWithIdOne);

        List<User> users = userRepository.findAll();
        log.info("All Users : " + users);

    }

}
