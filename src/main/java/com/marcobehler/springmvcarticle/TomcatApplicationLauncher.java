package com.marcobehler.springmvcarticle;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Wrapper;
import org.apache.catalina.startup.Tomcat;

public class TomcatApplicationLauncher {

    public static void main(String[] args) throws LifecycleException {
        Tomcat tomcat = new Tomcat(); // <1>
        tomcat.setPort(8080);
        tomcat.getConnector();

        Context ctx = tomcat.addContext("", null);
        Wrapper servlet = Tomcat.addServlet(ctx, "myServlet", new MyServletV2()); // <2>
        servlet.setLoadOnStartup(1);
        servlet.addMapping("/*"); // <3>

        tomcat.start(); // <4>
    }
}
