<%@ page contentType="text/html;charset=UTF-8" %>

<!-- ✅ JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Patient</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">
<jsp:include page="menu.jsp" />

<h3>Patient Registration</h3>

<form action="PatientServlets" method="post" class="card p-3 mb-4">

    <!-- 🔥 Hidden fields for update -->
    <input type="hidden" name="id" value="${editData.id}">
    <input type="hidden" name="action"
           value="${editData != null ? 'update' : 'add'}">

    <!-- First Name -->
    <input name="firstName" class="form-control mb-2" placeholder="First Name"
           value="${editData.firstName}">

    <!-- Last Name -->
    <input name="lastName" class="form-control mb-2" placeholder="Last Name"
           value="${editData.lastName}">

    <!-- Gender -->
    Gender:
    <input type="radio" name="gender" value="Male"
        <c:if test="${editData.gender eq 'Male'}">checked</c:if>> M

    <input type="radio" name="gender" value="Female"
        <c:if test="${editData.gender eq 'Female'}">checked</c:if>> F

    <!-- Phone -->
    <input name="phone" class="form-control mb-2" placeholder="Phone"
           value="${editData.phone}">

    <!-- Date -->
    <input type="date" name="dateOfBirth" class="form-control mb-2"
           value="${editData.dateOfBirth}">

    <!-- Address -->
    <textarea name="address" class="form-control mb-2"
              placeholder="Address">${editData.address}</textarea>

    <!-- Button -->
    <button class="btn btn-success">
        <c:choose>
            <c:when test="${editData != null}">Update</c:when>
            <c:otherwise>Register</c:otherwise>
        </c:choose>
    </button>

</form>

<hr>

<h4>Patient List</h4>

<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Gender</th>
            <th>Phone</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

    <!-- 🔥 JSTL LOOP -->
    <c:forEach var="p" items="${list}">
        <tr>
            <td>${p.firstName}</td>
            <td>${p.lastName}</td>
            <td>${p.gender}</td>
            <td>${p.phone}</td>
            <td>${p.dateOfBirth}</td>
            <td>${p.address}</td>

            <td>
                <!-- EDIT -->
                <a href="PatientServlets?editId=${p.id}"
                   class="btn btn-sm btn-warning">Edit</a>

                <!-- DELETE -->
                <a href="PatientServlets?deleteId=${p.id}"
                   class="btn btn-sm btn-danger"
                   onclick="return confirm('Delete this patient?')">
                   Delete
                </a>
            </td>
        </tr>
    </c:forEach>

    <!-- EMPTY CASE -->
    <c:if test="${empty list}">
        <tr>
            <td colspan="7" class="text-center">No patients found</td>
        </tr>
    </c:if>

    </tbody>
</table>

</body>
</html>