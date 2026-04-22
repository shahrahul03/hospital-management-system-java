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

    /**
     * 👉 HANDLE GET REQUEST
     * Used for:
     * - Display list
     * - Load edit data
     * - Delete record
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AppointmentService service = new AppointmentServiceImpl();

        // ================= DELETE LOGIC =================
        // If deleteId comes in URL → delete record
        String deleteId = request.getParameter("deleteId");

        if (deleteId != null && !deleteId.isEmpty()) {
            int id = Integer.parseInt(deleteId);

            service.deleteAppointment(id);

            // redirect to refresh list after delete
            response.sendRedirect("AppointmentServlets");
            return;
        }

        // ================= FETCH ALL APPOINTMENTS =================
        List<Appointment> list = service.getAllAppointments();
        request.setAttribute("list", list);

        // ================= LOAD DOCTORS =================
        DoctorService docService = new DoctorServiceImpl();
        List<Doctor> doctors = docService.getAllDoctors();
        request.setAttribute("doctorList", doctors);

        // ================= EDIT LOGIC =================
        // If editId exists → send that record to JSP
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

        // ================= FORWARD TO JSP =================
        request.getRequestDispatcher("appointment.jsp").forward(request, response);
    }

    /**
     * 👉 HANDLE POST REQUEST
     * Used for:
     * - Add new appointment
     * - Update existing appointment
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

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

            // reload doctors
            DoctorService docService = new DoctorServiceImpl();
            request.setAttribute("doctorList", docService.getAllDoctors());

            // reload appointment list
            AppointmentService service = new AppointmentServiceImpl();
            request.setAttribute("list", service.getAllAppointments());

            request.getRequestDispatcher("appointment.jsp").forward(request, response);
            return;
        }

        AppointmentService service = new AppointmentServiceImpl();

        // ================= CREATE OBJECT =================
        Appointment a = new Appointment();
        a.setDoctor(doctor);
        a.setDate(date);
        a.setSlot(slot);
        a.setDetails(details);

        // ================= UPDATE LOGIC =================
        if ("update".equals(action)) {

            String idStr = request.getParameter("id");

            if (idStr != null && !idStr.isEmpty()) {
                int id = Integer.parseInt(idStr);
                a.setId(id);

                service.updateAppointment(a);
            }

        } else {
            // ================= ADD LOGIC =================
            service.addAppointment(a);
        }

        // ================= REDIRECT =================
        // Prevent form resubmission issue
        response.sendRedirect("AppointmentServlets");
    }
}