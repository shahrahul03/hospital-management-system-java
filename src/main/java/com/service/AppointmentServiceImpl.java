package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.db.DBConnection;
import com.model.Appointment;

public class AppointmentServiceImpl implements AppointmentService {

	@Override
	public void addAppointment(Appointment a) {
        try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO appointment(doctor,date,slot,details) VALUES(?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, a.getDoctor());
            ps.setString(2, a.getDate());
            ps.setString(3, a.getSlot());
            ps.setString(4, a.getDetails());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Appointment> getAllAppointments() {
		   List<Appointment> list = new ArrayList<>();

	        try {
	            Connection conn = DBConnection.getConnection();
	            String sql = "SELECT * FROM appointment";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Appointment a = new Appointment(
	                        rs.getInt("id"),
	                        rs.getString("doctor"),
	                        rs.getString("date"),
	                        rs.getString("slot"),
	                        rs.getString("details")
	                );
	                list.add(a);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

	@Override
	public void updateAppointment(Appointment a) {
		
	        try {
	            Connection conn = DBConnection.getConnection();

	            String sql ="UPDATE appointment SET doctor = ?, date = ?, slot = ?,details =? WHERE id = ?";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ps.setString(1, a.getDoctor());
	            ps.setString(2, a.getDate());
	            ps.setString(3, a.getSlot());
	            ps.setString(4, a.getDetails());
	            ps.setInt(5, a.getId());

	            ps.executeUpdate();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
	}
	@Override
	public void deleteAppointment(int id) {
	    try {
	        Connection conn = DBConnection.getConnection();

	        String sql = "DELETE FROM appointment WHERE id = ?";

	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        ps.executeUpdate();

	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

}
