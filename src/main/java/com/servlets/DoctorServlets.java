package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.service.DoctorService;
import com.model.Doctor;
import com.service.DoctorServiceImpl;

/**
 * Servlet implementation class Doctor
 */
@WebServlet("/DoctorServlets")
public class DoctorServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoctorServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		DoctorService service = new DoctorServiceImpl();
	        List<Doctor> list = service.getAllDoctors();

	        request.setAttribute("list", list);
	        request.getRequestDispatcher("doctor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String specialization = request.getParameter("specialization");
        String address = request.getParameter("address");
        String mobile = request.getParameter("mobile");
        String gender = request.getParameter("gender");

        // validation
        if (name == null || name.isEmpty() ||
            email == null || email.isEmpty()) {

            request.setAttribute("message", "Required fields missing");
            request.getRequestDispatcher("doctor.jsp").forward(request, response);
            return;
        }

        Doctor d = new Doctor(0, name, email, specialization, address, mobile, gender);

        DoctorService service = new DoctorServiceImpl();
        service.addDoctor(d);

        // redirect to refresh
        response.sendRedirect("doctor");
	}

}
