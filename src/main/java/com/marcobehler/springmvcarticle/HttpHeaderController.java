package com.marcobehler.springmvcarticle;

import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Map;

@Controller
public class HttpHeaderController {

    @GetMapping("/headers1")
    public void singleHeader(@RequestHeader("x-forwarded-for") String xForwardedFor) {
       // ...
    }

    @GetMapping("/headers2")
    public void headersAsMap(@RequestHeader Map<String,String> headers) {  // or MultiValueMap<String,String>
        // ...
    }

    @GetMapping("/headers3")
    public void headersAsObject(HttpHeaders headers) {
        // ...
    }


}
