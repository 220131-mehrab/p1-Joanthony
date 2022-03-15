package com.revature.favplayer;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.http.fileupload.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        server.setPort(8081);
        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");

        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        server.addServlet("","favPlayerServlet", new FavPlayerServlet(conn)).addMapping("/Player");
        try {
            server.start();
        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
