package com.marcobehler.springmvcarticle;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@Controller
public class CookieController {

    @GetMapping("/cookie")
    public void handle(@CookieValue("JSESSIONID") String cookie, HttpServletResponse response) {

        response.addCookie(new Cookie("SOME_COOKIE_NAME", "This is a crazy new cookie!"));
        //...
    }
}
