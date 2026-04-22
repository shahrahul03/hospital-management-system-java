package com.service;

import java.util.List;

import com.model.Appointment;

public interface AppointmentService {
	void addAppointment(Appointment a);
    List<Appointment> getAllAppointments();
    void updateAppointment(Appointment a);
	void deleteAppointment(int id);

}
