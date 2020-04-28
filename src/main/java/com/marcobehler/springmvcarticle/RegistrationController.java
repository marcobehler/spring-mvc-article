package com.marcobehler.springmvcarticle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @PostMapping("/register")  // <1>
    public String createUser2(@RequestParam(required = false) Integer age, @RequestParam String name, Model model) { // <2>
        User user = new User(name, age); // <3>

        // TODO save user to database
        // userDao.save(user);

        // TODO send out registration email
        // mailService.sendRegistrationEmail(user);

        model.addAttribute("user", user); // <4>
        return "registration-success"; // <5>
    }
}
