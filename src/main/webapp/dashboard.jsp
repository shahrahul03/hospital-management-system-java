<%@ page contentType="text/html;charset=UTF-8" %>

<!DOCTYPE html>

<html>
<head>
    <title>Dashboard</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-dark text-white">

<div class="container mt-5 text-center">


<h2>Hospital Dashboard</h2>

<div class="row mt-4">
 <p class="fullname">${message}</p>


    <div class="col-md-4">
        <a href="DoctorServlets" class="btn btn-primary w-100">Doctor</a>
    </div>

    <div class="col-md-4">
        <a href="PatientServlets" class="btn btn-success w-100">Patient</a>
    </div>

    <div class="col-md-4">
        <a href="AppointmentServlets" class="btn btn-warning w-100">Appointment</a>
   
    
    
    

</div>
<div class="col-md-4">
    <a href="UserListServlets" class="btn btn-warning w-100">User list</a>
    </div>



</div>


</body>
</html>
