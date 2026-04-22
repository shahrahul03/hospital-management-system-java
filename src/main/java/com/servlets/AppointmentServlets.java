package com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.Appointment;
import com.model.Doctor;
import com.service.AppointmentService;
import com.service.AppointmentServiceImpl;
import com.service.DoctorService;
import com.service.DoctorServiceImpl;

@WebServlet("/AppointmentServlets")
public class AppointmentServlets extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// show page + list
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AppointmentService service = new AppointmentServiceImpl();

        List<Appointment> list = service.getAllAppointments();

        request.setAttribute("list", list);
        
        DoctorService docService = new DoctorServiceImpl();
        List<Doctor> doctors = docService.getAllDoctors();

        request.setAttribute("doctorList", doctors);

        request.getRequestDispatcher("appointment.jsp").forward(request, response);
    }

    // handle form submit
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");
        String slot = request.getParameter("slot");
        String details = request.getParameter("details");

        // validation
        if (doctor == null || doctor.isEmpty() ||
            date == null || date.isEmpty() ||
            slot == null || slot.isEmpty()) {

            request.setAttribute("message", "All fields required");
            request.getRequestDispatcher("appointment.jsp").forward(request, response);
            return;
        }

      
        Appointment a = new Appointment();
        a.setDoctor(doctor);
        a.setDate(date);
        a.setSlot(slot);
        a.setDetails(details);
        

        AppointmentService service = new AppointmentServiceImpl();
        service.addAppointment(a);

        
        response.sendRedirect("AppointmentServlets");
    }
}