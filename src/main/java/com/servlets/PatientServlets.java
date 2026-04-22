package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.PatientService;
import com.model.Patient;
import com.service.PatientServiceImpl;

/**
 * Servlet implementation class Patient
 */
@WebServlet("/PatientServlets")
public class PatientServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PatientServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
        PatientService service = new PatientServiceImpl();
        List<Patient> list = service.getAllPatients();

        request.setAttribute("list", list);
        request.getRequestDispatcher("patient.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		 String firstName = request.getParameter("firstName");
	        String lastName = request.getParameter("lastName");
	        String gender = request.getParameter("gender");
	        String phone = request.getParameter("phone");
	        String dateOfBirth = request.getParameter("dateOfBirth");
	        String address = request.getParameter("address");

	        // validation
	        if (firstName == null || firstName.isEmpty() ||
	            lastName == null || lastName.isEmpty()) {

	            request.setAttribute("message", "Required fields missing");
	            request.getRequestDispatcher("patient.jsp").forward(request, response);
	            return;
	        }

	        Patient p = new Patient(0, firstName, lastName, gender, phone, dateOfBirth, address);

	        PatientService service = new PatientServiceImpl();
	        service.addPatient(p);

	        // redirect to refresh page
	        response.sendRedirect("patient");
	}

}
