package com.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.db.DBConnection;
import com.model.Patient;

public class PatientServiceImpl implements PatientService {

	@Override
	public void addPatient(Patient p) {
		try {
            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO patient(first_name,last_name,gender,phone,date_of_birth,address) VALUES(?,?,?,?,?,?)";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, p.getFirstName());
            ps.setString(2, p.getLastName());
            ps.setString(3, p.getGender());
            ps.setString(4, p.getPhone());
            ps.setString(5, p.getDateOfBirth());
            ps.setString(6, p.getAddress());

            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

	@Override
	public List<Patient> getAllPatients() {
		  List<Patient> list = new ArrayList<>();

	        try {
	            Connection conn = DBConnection.getConnection();
	            String sql = "SELECT * FROM patient";

	            PreparedStatement ps = conn.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery();

	            while (rs.next()) {
	                Patient p = new Patient(
	                        rs.getInt("id"),
	                        rs.getString("first_name"),
	                        rs.getString("last_name"),
	                        rs.getString("gender"),
	                        rs.getString("phone"),
	                        rs.getString("date_of_birth"),
	                        rs.getString("address")
	                );
	                list.add(p);
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return list;
	    }

}
