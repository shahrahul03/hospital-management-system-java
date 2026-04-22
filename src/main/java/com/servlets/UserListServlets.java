package com.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class UserListServlets
 */
@WebServlet("/UserListServlets")
public class UserListServlets extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserListServlets() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		   UserService service = new UserServiceImpl();
		    List<User> list = service.getAllUsers();

		    System.out.println("User size: " + list.size());

		    request.setAttribute("ulist", list);

		    request.getRequestDispatcher("UserListForm.jsp").forward(request, response);
		
		request.getRequestDispatcher("UserListForm.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

		
	}

}
