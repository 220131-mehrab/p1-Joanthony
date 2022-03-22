package com.revature.favPlayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UpcomingEventServlet extends HttpServlet {
    private Connection conn;
    

    public UpcomingEventServlet(Connection conn) {
        this.conn = conn;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Upcoming> upcoming_event = new ArrayList<>();
        try {
            ResultSet rs = this.conn.prepareStatement("select * from Upcoming").executeQuery();
            while (rs.next()) {
                upcoming_event.add(new Upcoming(rs.getInt("Event ID"),rs.getString("City"), rs.getString("State"),rs.getString("Event Date")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve from db: " + e.getSQLState());
        }

        //JSON Mapper
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(upcoming_event);
        resp.setContentType("application/json");
        resp.getWriter().println(results);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Upcoming newUpcoming = mapper.readValue(req.getInputStream(), Upcoming.class);
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Upcoming values (?,?)");
            stmt.setInt(1, newUpcoming.getEventID());
            stmt.setString(2, newUpcoming.getCity());
            stmt.setString(3, newUpcoming.getState());
            stmt.setString(4,newUpcoming.getEventDate());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert: " + e.getMessage());
        }
    }
}
