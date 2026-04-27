package com.servlets;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class UserListServlets
 */
@WebServlet("/UserListServlets")
public class UserListServlets extends HttpServlet {

    private static final long serialVersionUID = 1L;

    // ================= GET =================
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 🔐 SECURITY + STORE URL
        HttpSession session = request.getSession(false);

        if (session == null || session.getAttribute("username") == null) {
            HttpSession newSession = request.getSession();
            newSession.setAttribute("redirectAfterLogin", "UserListServlets");

            response.sendRedirect("login.jsp");
            return;
        }

        // ================= FETCH USERS =================
        UserService service = new UserServiceImpl();
        List<User> list = service.getAllUsers();

        request.setAttribute("ulist", list);

        request.getRequestDispatcher("UserListForm.jsp").forward(request, response);
    }

    // ================= POST =================
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // 👉 simply reuse GET
        doGet(request, response);
    }
}

