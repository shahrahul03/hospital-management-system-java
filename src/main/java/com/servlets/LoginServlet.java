package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

      
        request.getRequestDispatcher("login.jsp").forward(request, response);
        
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	    // 1. Get form data
	    String uname = request.getParameter("username");
	    String psw = request.getParameter("password");

	    // 2. Validation
	    if (uname == null || uname.isEmpty() ||
	        psw == null || psw.isEmpty()) {

	        request.setAttribute("message", "All fields required");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	        return;
	    }

	    // 3. Check login
	    UserService service = new UserServiceImpl();
	    boolean isValid = service.login(uname, psw);

	    if (isValid) {

	        // ✅ CREATE SESSION
	        HttpSession session = request.getSession();
	        session.setAttribute("username", uname);   // 🔥 FIXED KEY

	        // 🔥 REDIRECT TO REQUESTED PAGE (IMPORTANT)
	        String redirectURL = (String) session.getAttribute("redirectAfterLogin");

	        if (redirectURL != null) {
	            session.removeAttribute("redirectAfterLogin");
	            response.sendRedirect(redirectURL);   // go back to requested page
	        } else {
	            response.sendRedirect("dashboard.jsp"); // default
	        }

	    } else {
	        request.setAttribute("message", "Invalid username or password");
	        request.getRequestDispatcher("login.jsp").forward(request, response);
	    }
	}
    }
    

