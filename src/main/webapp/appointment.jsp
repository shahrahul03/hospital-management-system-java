<%@ page contentType="text/html;charset=UTF-8" %>

<!-- ✅ JSTL CORE TAG -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Appointment</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">
<jsp:include page="menu.jsp" />

<h3 class="mb-3">Appointment</h3>

<!-- ================= FORM ================= -->
<form action="AppointmentServlets" method="post" class="card p-3 mb-4">

    <!-- Hidden fields -->
    <input type="hidden" name="id" value="${editData.id}">
    <input type="hidden" name="action"
           value="${editData != null ? 'update' : 'add'}">

    <!-- Doctor Dropdown -->
    <select name="doctor" class="form-control mb-2">
        <option value="">Select Doctor</option>

        <c:forEach var="d" items="${doctorList}">
            <option value="${d.name}"
                <c:if test="${editData != null && d.name eq editData.doctor}">
                    selected
                </c:if>>
                ${d.name} - ${d.specialization}
            </option>
        </c:forEach>
    </select>

    <!-- Date -->
    <input type="date" name="date" class="form-control mb-2"
           value="${editData.date}">

    <!-- Slot -->
    <input type="text" name="slot" class="form-control mb-2"
           placeholder="Slots"
           value="${editData.slot}">

    <!-- Details -->
    <textarea name="details" class="form-control mb-2"
              placeholder="Details">${editData.details}</textarea>

    <button class="btn btn-warning">
        <c:choose>
            <c:when test="${editData != null}">
                Update Appointment
            </c:when>
            <c:otherwise>
                Book Appointment
            </c:otherwise>
        </c:choose>
    </button>

</form>

<!-- ================= TABLE ================= -->
<h4>Appointment List</h4>

<table class="table table-bordered table-striped">
    <thead class="table-dark">
        <tr>
            <th>Doctor</th>
            <th>Date</th>
            <th>Slot</th>
            <th>Details</th>
            <th>Action</th>
        </tr>
    </thead>

    <tbody>
        <c:forEach var="a" items="${list}">
            <tr>
                <td>${a.doctor}</td>
                <td>${a.date}</td>
                <td>${a.slot}</td>
                <td>${a.details}</td>

                <td>
                    <!-- EDIT -->
                    <a href="AppointmentServlets?editId=${a.id}"
                       class="btn btn-sm btn-primary">Edit</a>

                    <!-- DELETE -->
                    <a href="AppointmentServlets?deleteId=${a.id}"
                       class="btn btn-sm btn-danger"
                       onclick="return confirm('Delete this record?')">
                       Delete
                    </a>
                </td>
            </tr>
        </c:forEach>
    </tbody>
</table>

</body>
</html>