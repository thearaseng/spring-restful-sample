package com.theara.restful.restfulwebservice.controller;

import com.theara.restful.restfulwebservice.model.Name;
import com.theara.restful.restfulwebservice.model.PersonV1;
import com.theara.restful.restfulwebservice.model.PersonV2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersionController {

    private PersonV1 createPersonV1(){
        return new PersonV1("Theara Seng");
    }

    private PersonV2 createPersonV2(){
        return new PersonV2(new Name("Theara", "Seng"));
    }

    @GetMapping("/v1/person")
    public PersonV1 personV1(){
        return createPersonV1();
    }

    @GetMapping("/v2/person")
    public PersonV2 personV2(){
        return createPersonV2();
    }

    @GetMapping(value = "/person/param", params = "v=1")
    public PersonV1 paramV1(){
        return createPersonV1();
    }

    @GetMapping(value = "/person/param", params = "v=2")
    public PersonV2 paramV2(){
        return createPersonV2();
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=1")
    public PersonV1 headerV1(){
        return createPersonV1();
    }

    @GetMapping(value = "/person/header", headers = "X-API-VERSION=2")
    public PersonV2 headerV2(){
        return createPersonV2();
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v1+json")
    public PersonV1 producesV1(){
        return createPersonV1();
    }

    @GetMapping(value = "/person/produces", produces = "application/vnd.company.app-v2+json")
    public PersonV2 producesV2(){
        return createPersonV2();
    }

}
