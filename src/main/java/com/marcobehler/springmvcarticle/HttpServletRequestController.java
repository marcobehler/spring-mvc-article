package com.marcobehler.springmvcarticle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class HttpServletRequestController {

    @Autowired
    private SomeRequestService someRequestService;

    @GetMapping("/request")
    public String getRequest(HttpServletRequest request) {
        System.out.println("request = " + request);
        return request.toString();
    }
}

@Service
class SomeRequestService {

    @Autowired
    private HttpServletRequest httpServletRequest;

    public HttpServletRequest getRequest() {
        return httpServletRequest;
    }
}

