package com.revature.favPlayer;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class App {
    public static void main(String[] args) throws SQLException {
        Tomcat server = new Tomcat();
        server.getConnector();
        server.addContext("", null);
        //server.setPort(8081);

        server.addServlet("", "defaultServlet", new DefaultServlet()).addMapping("/*");

        Connection conn = DriverManager.getConnection("jdbc:h2:mem:test;MODE=PostgreSQL;DATABASE_TO_LOWER=TRUE;INIT=runscript from 'classpath:schema.sql'", "sa", "");
        server.addServlet("","favPlayerServlet", new FavPlayerServlet(conn)).addMapping("/Player");
        server.addServlet("","UpcomingEventServlet", new UpcomingEventServlet(conn)).addMapping("/Upcoming");

        try {
            server.start();
            //System.out.println("Server is running on http://localhost:" + server.getConnector().getLocalPort());

        } catch (LifecycleException e) {
            System.err.println("Failed to start server: " + e.getMessage());
        }
    }
}
