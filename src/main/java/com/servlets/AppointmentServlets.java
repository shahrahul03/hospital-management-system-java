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

    private static final long serialVersionUID = 1L;

    // ================= GET =================
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {

            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "AppointmentServlets");

            response.sendRedirect("LoginServlet");
            return;
        }

        AppointmentService service = new AppointmentServiceImpl();

        // ================= DELETE =================
        String deleteId = request.getParameter("deleteId");

        if (deleteId != null && !deleteId.isEmpty()) {
            int id = Integer.parseInt(deleteId);

            service.deleteAppointment(id);

            response.sendRedirect("AppointmentServlets");
            return;
        }

        // ================= FETCH =================
        List<Appointment> list = service.getAllAppointments();
        request.setAttribute("list", list);

        // ================= DOCTOR LIST =================
        DoctorService docService = new DoctorServiceImpl();
        request.setAttribute("doctorList", docService.getAllDoctors());

        // ================= EDIT =================
        String editId = request.getParameter("editId");

        if (editId != null && !editId.isEmpty()) {
            int id = Integer.parseInt(editId);

            for (Appointment a : list) {
                if (a.getId() == id) {
                    request.setAttribute("editData", a);
                    break;
                }
            }
        }

        request.getRequestDispatcher("appointment.jsp").forward(request, response);
    }

    // ================= POST =================
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 SECURITY + STORE URL
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {

            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "AppointmentServlets");

            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");

        String doctor = request.getParameter("doctor");
        String date = request.getParameter("date");
        String slot = request.getParameter("slot");
        String details = request.getParameter("details");

        // ================= VALIDATION =================
        if (doctor == null || doctor.isEmpty() ||
            date == null || date.isEmpty() ||
            slot == null || slot.isEmpty()) {

            request.setAttribute("message", "All fields required");

            DoctorService docService = new DoctorServiceImpl();
            request.setAttribute("doctorList", docService.getAllDoctors());

            AppointmentService service = new AppointmentServiceImpl();
            request.setAttribute("list", service.getAllAppointments());

            request.getRequestDispatcher("appointment.jsp").forward(request, response);
            return;
        }

        AppointmentService service = new AppointmentServiceImpl();

        Appointment a = new Appointment();
        a.setDoctor(doctor);
        a.setDate(date);
        a.setSlot(slot);
        a.setDetails(details);

        // ================= UPDATE =================
        if ("update".equals(action)) {

            String idStr = request.getParameter("id");

            if (idStr != null && !idStr.isEmpty()) {
                a.setId(Integer.parseInt(idStr));
                service.updateAppointment(a);
            }

        } else {
            // ================= ADD =================
            service.addAppointment(a);
        }

        response.sendRedirect("AppointmentServlets");
    }
}