package com.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import com.model.User;
import com.service.UserService;
import com.service.UserServiceImpl;

@WebServlet("/RegisterServlets")
public class RegisterServlets extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // SHOW REGISTER PAGE
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    // HANDLE FORM SUBMIT
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 1. Get form data
        String fname = request.getParameter("fullname");
        String uname = request.getParameter("username");
        String psw = request.getParameter("password");

        // 2. Set data into User object
        User u = new User();
        u.setFullname(fname);
        u.setUsername(uname);
        u.setPassword(psw);

        // 3. Call service
        UserService service = new UserServiceImpl();
        service.register(u);

        
        response.sendRedirect("login.jsp");
    }
}