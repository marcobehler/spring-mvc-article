package com.marcobehler.springmvcarticle;

import org.apache.coyote.Request;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
public class HowToPassAndRetrieveRequestParametersController {

    @PostMapping("/users")   /*Params are required*/
    public User createUser(@RequestParam Integer age, @RequestParam String name) {
        User user = new User(name, UUID.randomUUID().toString(), age);
        System.out.println("user = " + user);
        return user;
    }

    @PostMapping("/users2")   /* First Param is optional */
    public User createUser2(@RequestParam(required = false) Integer age, @RequestParam String name) {
        User user = new User(name, UUID.randomUUID().toString(), age);
        System.out.println("user = " + user);
        return user;
    }

    @PostMapping("/users3")   /* Spring will convert this automatically, if you have getters and setters */
    public User createUser(User user) {
        System.out.println("user = " + user);
        return user;
    }

  /*  @PostMapping("/users3")   *//* Spring will convert this automatically, if you have getters and setters *//*
    public User createUser4(User user) {
        System.out.println("user = " + user);
        return user;
    }*/
}
