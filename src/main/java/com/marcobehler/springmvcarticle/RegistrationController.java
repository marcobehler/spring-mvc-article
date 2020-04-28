package com.marcobehler.springmvcarticle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller // <1>
public class RegistrationController {

    @PostMapping("/register")  // <2>
    public String registerUser(@RequestParam(required = false) Integer age, @RequestParam String name, Model model) { // <3>
        User user = new User(name, age); // <4>

        // TODO save user to database
        // userDao.save(user);

        // TODO send out registration email
        // mailService.sendRegistrationEmail(user);

        model.addAttribute("user", user); // <5>
        return "registration-success"; // <6>
    }
}
