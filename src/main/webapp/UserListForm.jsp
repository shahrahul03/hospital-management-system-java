<%@ page contentType="text/html;charset=UTF-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User List</title>
</head>

<body>

<h1>User List</h1>
<hr>

<table border="1">
    <tr>
        <th>Full Name</th>
        <th>Username</th>
        <th>Password</th>
    </tr>

    <c:forEach var="u" items="${ulist}">
        <tr>
            <td>${u.fullname}</td>
            <td>${u.username}</td>
            <td>${u.password}</td>
        </tr>
    </c:forEach>
</table>


</body>
</html>