package com.service;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.db.DB;
import com.model.User;

public class UserServiceImpl implements UserService {

    // REGISTER USER
    @Override
    public void register(User user) {
        String sql = "INSERT INTO users(fullname, username, password) VALUES (?, ?, ?)";

        try (Connection conn = DB.getConnect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFullname());
            ps.setString(2, user.getUsername());
            ps.setString(3, user.getPassword());

            int result = ps.executeUpdate();
            System.out.println("Inserted rows: " + result);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LOGIN USER
    @Override
    public boolean login(String username, String password) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DB.getConnect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // clean way

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

   
    @Override
    public List<User> getAllUsers() {

        List<User> ulist = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try (Connection conn = DB.getConnect();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
            	User u = new User(
            		    rs.getInt("id"),
            		    rs.getString("fullname"),
            		    rs.getString("username"),
            		    rs.getString("password")
            		);
                ulist.add(u);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return ulist;
    }
}