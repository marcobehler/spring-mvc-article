package com.marcobehler.springmvcarticle;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @PostMapping("/register")
    public String registerUser(@RequestParam(required = false) Integer age, @RequestParam String name, Model model) {
        User user = new User(name, age);

        // TODO save user to database
        // userDao.save(user);

        // TODO send out registration email
        // mailService.sendRegistrationEmail(user);

        model.addAttribute("user", user);
        return "registration-success";
    }
}
