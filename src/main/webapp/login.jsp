<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login</title>

    <style>
        body {
            font-family: Arial;
            background: #f4f6f9;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .container {
            background: white;
            padding: 25px;
            width: 300px;
            border-radius: 10px;
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }

        h2 { text-align: center; }

        input {
            width: 100%;
            padding: 8px;
            margin: 8px 0;
        }

        button {
            width: 100%;
            padding: 10px;
            background: #007bff;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover { background: #0056b3; }

        .msg {
            color: red;
            text-align: center;
        }

        .link {
            text-align: center;
            margin-top: 10px;
        }
    </style>

    <!-- ✅ validation script -->
    <script>
        function validateForm() {
            let username = document.getElementsByName("username")[0].value.trim();
            let password = document.getElementsByName("password")[0].value.trim();
            let error = document.getElementById("errorMsg");

            if (username === "" || password === "") {
                error.innerText = "All fields are required!";
                return false;
            }

            error.innerText = "";
            return true;
        }
    </script>

</head>
<body>

<div class="container">

    <h2>Login</h2>
   

    <!-- JS error message -->
    <p class="msg" id="errorMsg"></p>
<p class="msg">${message}</p>
    <form action="LoginServlet" method="post" onsubmit="return validateForm()">
        <input type="hidden" name="action" value="login">

        <input type="text" name="username" placeholder="Username">
        <input type="password" name="password" placeholder="Password">

        <button type="submit">Login</button>
    </form>

    <div class="link">
        <a href="register.jsp">Create Account</a>
    </div>

</div>

</body>
</html>