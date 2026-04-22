<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
<title>Doctor</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="container mt-5">

<h3>Doctor Form</h3>

<form action="DoctorServlets" method="post">

    <input name="name" class="form-control mb-2" placeholder="Name">

    <input name="email" class="form-control mb-2" placeholder="Email">

    <select name="specialization" class="form-control mb-2">
        <option value="">Select Specialization</option>
        <option>Cardiology</option>
        <option>Neurology</option>
        <option>Orthopedic</option>
    </select>

    <textarea name="address" class="form-control mb-2" placeholder="Address"></textarea>

    <input name="mobile" class="form-control mb-2" placeholder="Mobile">

    Gender:
    <input type="radio" name="gender" value="Male"> M
    <input type="radio" name="gender" value="Female"> F

    <br>

    <button class="btn btn-primary mt-3">Save</button>

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
        </tr>
    </thead>

    <tbody>

    <%
    java.util.List<com.model.Doctor> list =
        (java.util.List<com.model.Doctor>) request.getAttribute("list");

    if(list != null && !list.isEmpty()){
        for(com.model.Doctor d : list){
    %>
        <tr>
            <td><%= d.getName() %></td>
            <td><%= d.getEmail() %></td>
            <td><%= d.getSpecialization() %></td>
            <td><%= d.getAddress() %></td>
            <td><%= d.getMobile() %></td>
            <td><%= d.getGender() %></td>
        </tr>
    <%
        }
    } else {
    %>
        <tr>
            <td colspan="6" class="text-center">No doctors found</td>
        </tr>
    <%
    }
    %>

    </tbody>
</table>

</body>
</html>