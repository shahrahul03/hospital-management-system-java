<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Appointment</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h3>Appointment</h3>

<form action ="AppointmentServlets" method="post">
      <select name="doctor" class="form-control mb-2">
    <option value="">Select Doctor</option>

    <c:forEach var="d" items="${doctorList}">
        <option value="${d.name}">
            ${d.name} - ${d.specialization}
        </option>
    </c:forEach>

</select>

    <input type="date" name="date" class="form-control mb-2">

    <input type="text" name="slot" class="form-control mb-2" placeholder="Slots">

    <textarea name="details" class="form-control mb-2" placeholder="Details"></textarea>

    <button class="btn btn-warning">Book</button>


</form>

<hr>

<h4>Appointment List</h4>

<table class="table table-bordered">
    <thead>
        <tr>
            <th>Doctor</th>
            <th>Date</th>
            <th>Slot</th>
            <th>Details</th>
        </tr>
    </thead>

    <tbody>

    <%
    java.util.List<com.model.Appointment> list =
        (java.util.List<com.model.Appointment>) request.getAttribute("list");

    if(list != null && !list.isEmpty()){
        for(com.model.Appointment a : list){
    %>
        <tr>
            <td><%= a.getDoctor() %></td>
            <td><%= a.getDate() %></td>
            <td><%= a.getSlot() %></td>
            <td><%= a.getDetails() %></td>
        </tr>
    <%
        }
    } else {
    %>
        <tr>
            <td colspan="4" class="text-center">No appointments found</td>
        </tr>
    <%
    }
    %>

    </tbody>
</table>

</body>
</html>
