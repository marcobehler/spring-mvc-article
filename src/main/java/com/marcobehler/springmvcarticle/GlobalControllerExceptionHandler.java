package com.marcobehler.springmvcarticle;


import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.CONFLICT)  // 409
    @ExceptionHandler(SomeConflictException.class)
    public String handleConflict(SomeConflictException e, Model model) {
        // do something
        model.addAttribute("message", e.getMessage());
        return "new-template";
    }

    @ResponseStatus(HttpStatus.NOT_IMPLEMENTED)  // 409
    @ExceptionHandler(NotYetImplementedExceptoin.class)
    public void handleBandwithLimitExceeded(NotYetImplementedExceptoin e) {
        // do nothing;
    }
}

