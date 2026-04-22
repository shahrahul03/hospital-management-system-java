<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Patient</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h3>Patient Registration</h3>

<form action="PatientServlets" method="post">

    <input name="firstName" class="form-control mb-2" placeholder="First Name">

    <input name="lastName" class="form-control mb-2" placeholder="Last Name">

    Gender:
    <input type="radio" name="gender" value="Male"> M
    <input type="radio" name="gender" value="Female"> F

    <input name="phone" class="form-control mb-2" placeholder="Phone">

    <input type="date" name="dateOfBirth" class="form-control mb-2">

    <textarea name="address" class="form-control mb-2" placeholder="Address"></textarea>

    <button class="btn btn-success">Register</button>

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
        </tr>
    </thead>

    <tbody>

    <%
    java.util.List<com.model.Patient> list =
        (java.util.List<com.model.Patient>) request.getAttribute("list");

    if(list != null && !list.isEmpty()){
        for(com.model.Patient p : list){
    %>
        <tr>
            <td><%= p.getFirstName() %></td>
            <td><%= p.getLastName() %></td>
            <td><%= p.getGender() %></td>
            <td><%= p.getPhone() %></td>
            <td><%= p.getDateOfBirth() %></td>
            <td><%= p.getAddress() %></td>
        </tr>
    <%
        }
    } else {
    %>
        <tr>
            <td colspan="6" class="text-center">No patients found</td>
        </tr>
    <%
    }
    %>

    </tbody>
</table>

</body>
</html>