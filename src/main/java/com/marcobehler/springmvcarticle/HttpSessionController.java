package com.marcobehler.springmvcarticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class HttpSessionController {

    @GetMapping("/session")
    public String getSession(HttpSession httpSession) {
        System.out.println("httpSession = " + httpSession);
        return httpSession.getId();
    }
}

@Service
class SomeOtherService {

    @Autowired
    private HttpSession httpSession;

    public HttpSession getHttpSession() {
        return httpSession;
    }
}
