package com.marcobehler.springmvcarticle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MyServletV1 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        if (req.getRequestURI().equals("/")) {
            resp.setContentType("text/html");
            resp.getWriter().print("<html><head></head><body><h1>Welcome!</h1><p>This is a very cool page!</p></body></html>");
        }
        else {
            throw new IllegalStateException("Help, I don't know what to do with this url");
        }
    }
}