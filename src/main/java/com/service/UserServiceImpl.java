package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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

            ps.executeUpdate();
            System.out.println("User registered successfully!");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // LOGIN USER
    @Override
    public boolean login(String Uname, String psw) {
        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try (Connection conn = DB.getConnect();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, Uname);
            ps.setString(2, psw);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true; 
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false; 
    }
}