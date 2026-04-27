<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Hospital Dashboard</title>

    <!-- Bootstrap + Icons -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css" rel="stylesheet">

    <style>
        body {
            background: linear-gradient(135deg, #4facfe, #00f2fe);
            min-height: 100vh;
        }

        .title {
            font-weight: bold;
            color: white;
        }

        .menu-card {
            border-radius: 20px;
            padding: 30px;
            text-align: center;
            transition: 0.3s;
            background: white;
            cursor: pointer;
        }

        .menu-card:hover {
            transform: translateY(-8px);
        }

        .menu-icon {
            font-size: 50px;
            margin-bottom: 15px;
        }

        .menu-title {
            font-size: 18px;
            font-weight: 600;
        }
    </style>
</head>

<body>

<!-- HEADER -->
<div class="container text-center mt-5">
    <h2 class="title">🏥 Hospital Management System</h2>
    <p class="text-white">Welcome, ${sessionScope.username}</p>
</div>

<!-- MENU GRID -->
<div class="container mt-5">
    <div class="row g-4 justify-content-center">

        <div class="col-6 col-md-3">
            <a href="DoctorServlets" class="text-decoration-none">
                <div class="menu-card">
                    <div class="menu-icon text-primary">
                        <i class="bi bi-person-badge"></i>
                    </div>
                    <div class="menu-title">Doctors</div>
                </div>
            </a>
        </div>

        <div class="col-6 col-md-3">
            <a href="PatientServlets" class="text-decoration-none">
                <div class="menu-card">
                    <div class="menu-icon text-success">
                        <i class="bi bi-people"></i>
                    </div>
                    <div class="menu-title">Patients</div>
                </div>
            </a>
        </div>

        <div class="col-6 col-md-3">
            <a href="AppointmentServlets" class="text-decoration-none">
                <div class="menu-card">
                    <div class="menu-icon text-warning">
                        <i class="bi bi-calendar-check"></i>
                    </div>
                    <div class="menu-title">Appointments</div>
                </div>
            </a>
        </div>

        <div class="col-6 col-md-3">
            <a href="UserListServlets" class="text-decoration-none">
                <div class="menu-card">
                    <div class="menu-icon text-info">
                        <i class="bi bi-person-lines-fill"></i>
                    </div>
                    <div class="menu-title">Users</div>
                </div>
            </a>
        </div>

        <!-- LOGOUT -->
        <div class="col-6 col-md-3">
            <a href="LogoutServlets" class="text-decoration-none">
                <div class="menu-card">
                    <div class="menu-icon text-danger">
                        <i class="bi bi-box-arrow-right"></i>
                    </div>
                    <div class="menu-title">Logout</div>
                </div>
            </a>
        </div>

    </div>
</div>

</body>
</html>