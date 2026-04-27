<%@ page contentType="text/html;charset=UTF-8" %>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark shadow">
    <div class="container-fluid">

        <a class="navbar-brand fw-bold" href="dashboard.jsp">🏥 HMS</a>

        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                data-bs-target="#navbarNav">
            <span class="navbar-toggler-icon"></span>
        </button>

        <div class="collapse navbar-collapse" id="navbarNav">

            <ul class="navbar-nav me-auto">

                <li class="nav-item">
                    <a class="nav-link" href="dashboard.jsp">Dashboard</a>
                </li>

                <%
                String user = (String) session.getAttribute("username");
                
                if(user != null){
                %>

                <li class="nav-item">
                    <a class="nav-link" href="DoctorServlets">Doctors</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="PatientServlets">Patients</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="AppointmentServlets">Appointments</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link" href="UserListServlets">Users</a>
                </li>

                <% } %>
            </ul>

            <ul class="navbar-nav">

                <% if(user == null){ %>

                <li class="nav-item">
                    <a class="nav-link text-info" href="LoginServlet">Login</a>
                </li>

                <li class="nav-item">
                    <a class="nav-link text-success" href="RegisterServlets">Register</a>
                </li>

                <% } else { %>

                <li class="nav-item">
                    <span class="nav-link text-warning">👤 <%= user %></span>
                </li>
                

                <li class="nav-item">
                    <a class="nav-link text-danger" href="LogoutServlets">Logout</a>
                </li>

                <% } %>

            </ul>

        </div>
    </div>
</nav>