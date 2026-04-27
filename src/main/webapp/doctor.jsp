<%@ page contentType="text/html;charset=UTF-8" %>

<!-- ✅ JSTL -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Doctor</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">
<jsp:include page="menu.jsp" />

<h3>Doctor Form</h3>

<form action="DoctorServlets" method="post" class="card p-3 mb-4">

    <!-- 🔥 Hidden fields for update -->
    <input type="hidden" name="id" value="${editData.id}">
    <input type="hidden" name="action"
           value="${editData != null ? 'update' : 'add'}">

    <!-- Name -->
    <input name="name" class="form-control mb-2" placeholder="Name"
           value="${editData.name}">

    <!-- Email -->
    <input name="email" class="form-control mb-2" placeholder="Email"
           value="${editData.email}">

    <!-- Specialization -->
    <select name="specialization" class="form-control mb-2">
        <option value="">Select Specialization</option>

        <option value="Cardiology"
            <c:if test="${editData.specialization eq 'Cardiology'}">selected</c:if>>
            Cardiology
        </option>

        <option value="Neurology"
            <c:if test="${editData.specialization eq 'Neurology'}">selected</c:if>>
            Neurology
        </option>

        <option value="Orthopedic"
            <c:if test="${editData.specialization eq 'Orthopedic'}">selected</c:if>>
            Orthopedic
        </option>
    </select>

    <!-- Address -->
    <textarea name="address" class="form-control mb-2"
              placeholder="Address">${editData.address}</textarea>

    <!-- Mobile -->
    <input name="mobile" class="form-control mb-2" placeholder="Mobile"
           value="${editData.mobile}">

    <!-- Gender -->
    Gender:
    <input type="radio" name="gender" value="Male"
        <c:if test="${editData.gender eq 'Male'}">checked</c:if>> M

    <input type="radio" name="gender" value="Female"
        <c:if test="${editData.gender eq 'Female'}">checked</c:if>> F

    <br>

    <!-- Button -->
    <button class="btn btn-primary mt-3">
        <c:choose>
            <c:when test="${editData != null}">Update</c:when>
            <c:otherwise>Save</c:otherwise>
        </c:choose>
    </button>

</form>

<hr>

<h4>Doctor List</h4>

<table class="table table-bordered table-striped">
    <thead>
        <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Specialization</th>
            <th>Address</th>
            <th>Mobile</th>
            <th>Gender</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>

    <!-- 🔥 JSTL LOOP -->
    <c:forEach var="d" items="${list}">
        <tr>
            <td>${d.name}</td>
            <td>${d.email}</td>
            <td>${d.specialization}</td>
            <td>${d.address}</td>
            <td>${d.mobile}</td>
            <td>${d.gender}</td>

            <td>
                <!-- EDIT -->
                <a href="DoctorServlets?editId=${d.id}"
                   class="btn btn-sm btn-warning">Edit</a>

                <!-- DELETE -->
                <a href="DoctorServlets?deleteId=${d.id}"
                   class="btn btn-sm btn-danger"
                   onclick="return confirm('Delete this doctor?')">
                   Delete
                </a>
            </td>
        </tr>
    </c:forEach>

    <!-- EMPTY CASE -->
    <c:if test="${empty list}">
        <tr>
            <td colspan="7" class="text-center">No doctors found</td>
        </tr>
    </c:if>

    </tbody>
</table>

</body>
</html>