package com.marcobehler.springmvcarticle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServletV1 extends HttpServlet { // <1>

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException { // <2>
        if (req.getRequestURI().equals("/")) {   // <3>
            resp.setContentType("text/html"); // <4>
            resp.getWriter().print("<html><head></head><body><h1>Welcome!</h1><p>This is a very cool page!</p></body></html>"); // <5>
        }
        else {
            throw new IllegalStateException("Help, I don't know what to do with this url");
        }
    }
}