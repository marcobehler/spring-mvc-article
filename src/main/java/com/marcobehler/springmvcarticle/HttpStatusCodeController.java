package com.marcobehler.springmvcarticle;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class HttpStatusCodeController {

    @GetMapping("/somePath")
    public void alwaysThrowsException() {
         //throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Meeepp, not found.");

        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Well, that just wasn't right!");
    }
}
