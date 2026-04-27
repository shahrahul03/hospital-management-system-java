package com.service;

import java.util.List;

import com.model.Doctor;

public interface DoctorService {
	void addDoctor(Doctor d);
    List<Doctor> getAllDoctors();
    void updateDoctor(Doctor d);
    void deleteDoctor(int id);

}
