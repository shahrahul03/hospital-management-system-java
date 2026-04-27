package com.servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.Patient;
import com.service.PatientService;
import com.service.PatientServiceImpl;

@WebServlet("/PatientServlets")
public class PatientServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // ================= GET =================
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 SECURITY + STORE URL
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "PatientServlets");

            response.sendRedirect("login.jsp");
            return;
        }

        PatientService service = new PatientServiceImpl();

        // ================= DELETE =================
        String deleteId = request.getParameter("deleteId");

        if (deleteId != null && !deleteId.isEmpty()) {
            int id = Integer.parseInt(deleteId);

            service.deletePatient(id);

            response.sendRedirect("PatientServlets");
            return;
        }

        // ================= FETCH =================
        List<Patient> list = service.getAllPatients();
        request.setAttribute("list", list);

        // ================= EDIT =================
        String editId = request.getParameter("editId");

        if (editId != null && !editId.isEmpty()) {
            int id = Integer.parseInt(editId);

            for (Patient p : list) {
                if (p.getId() == id) {
                    request.setAttribute("editData", p);
                    break;
                }
            }
        }

        request.getRequestDispatcher("patient.jsp").forward(request, response);
    }

    // ================= POST =================
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 SECURITY + STORE URL
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "PatientServlets");

            response.sendRedirect("login.jsp");
            return;
        }

        String action = request.getParameter("action");

        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String dateOfBirth = request.getParameter("dateOfBirth");
        String address = request.getParameter("address");

        // ================= VALIDATION =================
        if (firstName == null || firstName.isEmpty() ||
            lastName == null || lastName.isEmpty()) {

            request.setAttribute("message", "Required fields missing");

            PatientService service = new PatientServiceImpl();
            request.setAttribute("list", service.getAllPatients());

            request.getRequestDispatcher("patient.jsp").forward(request, response);
            return;
        }

        PatientService service = new PatientServiceImpl();

        Patient p = new Patient();
        p.setFirstName(firstName);
        p.setLastName(lastName);
        p.setGender(gender);
        p.setPhone(phone);
        p.setDateOfBirth(dateOfBirth);
        p.setAddress(address);

        // ================= UPDATE =================
        if ("update".equals(action)) {

            String idStr = request.getParameter("id");

            if (idStr != null && !idStr.isEmpty()) {
                p.setId(Integer.parseInt(idStr));
                service.updatePatient(p);
            }

        } else {
            // ================= ADD =================
            service.addPatient(p);
        }

        response.sendRedirect("PatientServlets");
    }
}