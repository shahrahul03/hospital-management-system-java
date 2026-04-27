package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.db.DBConnection;
import com.model.Doctor;

public class DoctorServiceImpl implements DoctorService {

	@Override
	public void addDoctor(Doctor d) {
		 try {
	            Connection conn = DBConnection.getConnection();

	            String sql = "INSERT INTO doctor(name,email,specialization,address,mobile,gender) VALUES(?,?,?,?,?,?)";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, d.getName());
	            ps.setString(2, d.getEmail());
	            ps.setString(3, d.getSpecialization());
	            ps.setString(4, d.getAddress());
	            ps.setString(5, d.getMobile());
	            ps.setString(6, d.getGender());

	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}

	@Override
	public List<Doctor> getAllDoctors() {
		List<Doctor> list = new ArrayList<>();

        try {
            Connection conn = DBConnection.getConnection();
            String sql = "SELECT * FROM doctor";

            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Doctor d = new Doctor(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("email"),
                        rs.getString("specialization"),
                        rs.getString("address"),
                        rs.getString("mobile"),
                        rs.getString("gender")
                );
                list.add(d);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

	@Override
	public void updateDoctor(Doctor d) {

	    String sql = "UPDATE doctor SET name=?, email=?, specialization=?, address=?, mobile=?, gender=? WHERE id=?";

	    try (Connection conn = DBConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {

	        ps.setString(1, d.getName());
	        ps.setString(2, d.getEmail());
	        ps.setString(3, d.getSpecialization());
	        ps.setString(4, d.getAddress());
	        ps.setString(5, d.getMobile());
	        ps.setString(6, d.getGender());
	        ps.setInt(7, d.getId());
	        
	        ps.executeUpdate();

	       

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	@Override
	public void deleteDoctor(int id) {
		 try {
	            Connection conn = DBConnection.getConnection();

	            String sql = "Delete from Doctor where id =?";

	            PreparedStatement ps = conn.prepareStatement(sql);
	           ps.setInt(1, id);
	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	}
	

}
