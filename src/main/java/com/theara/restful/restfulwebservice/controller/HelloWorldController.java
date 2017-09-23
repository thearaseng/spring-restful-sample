package com.theara.restful.restfulwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.*;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping(path = "/hello-world")
    public String helloWorld(@RequestHeader(name = "Accept-Language", required = false) Locale locale){
        return messageSource.getMessage("hello.world.message", null, locale);
    }

}
