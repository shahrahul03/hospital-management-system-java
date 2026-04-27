<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>

<!-- Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">

<style>
    body {
        background: linear-gradient(135deg, #667eea, #764ba2);
        min-height: 100vh;
        color: white;
    }

    .container-box {
        background: white;
        border-radius: 15px;
        padding: 25px;
        color: black;
        box-shadow: 0px 8px 25px rgba(0,0,0,0.2);
    }

    .table th {
        background-color: #4e73df;
        color: white;
    }

    .title {
        font-weight: bold;
    }
</style>

</head>

<body>

<div class="container mt-5">

    <!-- HEADER -->
    <div class="text-center mb-4">
        <h2 class="title">👥 User List</h2>
        <p>Manage registered users</p>
    </div>

    <!-- CARD -->
    <div class="container-box">

        <div class="d-flex justify-content-between mb-3">
            <h5>Total Users: ${fn:length(ulist)}</h5>
            <a href="dashboard.jsp" class="btn btn-secondary btn-sm">⬅ Back</a>
        </div>

        <table class="table table-striped table-hover">
            <thead>
                <tr>
                    <th>#</th>
                    <th>Full Name</th>
                    <th>Username</th>
                    <th>Status</th>
                </tr>
            </thead>

            <tbody>

            <c:forEach var="u" items="${ulist}" varStatus="i">
                <tr>
                    <td>${i.index + 1}</td>
                    <td>${u.fullname}</td>
                    <td>${u.username}</td>
                    <td>
                        <span class="badge bg-success">Active</span>
                    </td>
                </tr>
            </c:forEach>

            <c:if test="${empty ulist}">
                <tr>
                    <td colspan="4" class="text-center">No users found</td>
                </tr>
            </c:if>

            </tbody>
        </table>

    </div>

</div>

</body>
</html>