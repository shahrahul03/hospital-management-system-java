package com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.Doctor;
import com.service.DoctorService;
import com.service.DoctorServiceImpl;

@WebServlet("/DoctorServlets")
public class DoctorServlets extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // ================= GET =================
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 SECURITY + STORE URL
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "DoctorServlets");

            response.sendRedirect("login.jsp");
            return;
        }

        DoctorService service = new DoctorServiceImpl();

        // ================= DELETE =================
        String deleteId = request.getParameter("deleteId");

        if (deleteId != null && !deleteId.isEmpty()) {
            int id = Integer.parseInt(deleteId);
            service.deleteDoctor(id);

            response.sendRedirect("DoctorServlets");
            return;
        }

        // ================= FETCH =================
        List<Doctor> list = service.getAllDoctors();
        request.setAttribute("list", list);

        // ================= EDIT =================
        String editId = request.getParameter("editId");

        if (editId != null && !editId.isEmpty()) {
            int id = Integer.parseInt(editId);

            for (Doctor d : list) {
                if (d.getId() == id) {
                    request.setAttribute("editData", d);
                    break;
                }
            }
        }

        request.getRequestDispatcher("doctor.jsp").forward(request, response);
    }

    // ================= POST =================
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 SECURITY + STORE URL
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "DoctorServlets");

            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String specialization = request.getParameter("specialization");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");

        // ================= VALIDATION =================
        if (name == null || name.isEmpty() ||
            email == null || email.isEmpty()) {

            request.setAttribute("message", "Required fields missing");

            DoctorService service = new DoctorServiceImpl();
            request.setAttribute("list", service.getAllDoctors());

            request.getRequestDispatcher("doctor.jsp").forward(request, response);
            return;
        }

        DoctorService service = new DoctorServiceImpl();

        Doctor d = new Doctor();
        d.setName(name);
        d.setEmail(email);
        d.setSpecialization(specialization);
        d.setAddress(address);
        d.setMobile(mobile);
        d.setGender(gender);

        // ================= UPDATE =================
        if ("update".equals(action)) {

            String idStr = request.getParameter("id");

            if (idStr != null && !idStr.isEmpty()) {
                d.setId(Integer.parseInt(idStr));
                service.updateDoctor(d);
            }

        } else {
            // ================= ADD =================
            service.addDoctor(d);
        }

        response.sendRedirect("DoctorServlets");
    }
}