package com.revature.favplayer;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FavPlayerServlet extends HttpServlet {
    private Connection conn;

    public FavPlayerServlet(Connection conn) {
        this.conn = conn;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Player> favorite_player = new ArrayList<>();
        try {
            ResultSet rs = this.conn.prepareStatement("select * from Artist").executeQuery();
            while (rs.next()) {
                favorite_player.add(new Player(rs.getInt("playerID"),rs.getString("playerName"), rs.getString("sport"),rs.getInt("number")));
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve from db: " + e.getSQLState());
        }

        //JSON Mapper
        ObjectMapper mapper = new ObjectMapper();
        String results = mapper.writeValueAsString(favorite_player);
        resp.setContentType("application/json");
        resp.getWriter().println(results);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ObjectMapper mapper = new ObjectMapper();
        Player newPlayer = mapper.readValue(req.getInputStream(), Player.class);
        try {
            PreparedStatement stmt = conn.prepareStatement("insert into Player values (?,?)");
            stmt.setInt(1, newPlayer.getPlayerID());
            stmt.setString(2, newPlayer.getPlayerName());
            stmt.setString(3,newPlayer.getSport());
            stmt.setInt(4,newPlayer.getNumber());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert: " + e.getMessage());
        }



    }
}
