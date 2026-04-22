package com.service;

import java.util.List;

import com.model.Patient;

public interface PatientService {
	void addPatient(Patient p);
    List<Patient> getAllPatients();

}
