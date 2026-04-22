<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Register</title>

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
            width: 320px;
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
            background: green;
            color: white;
            border: none;
            cursor: pointer;
        }

        button:hover { background: darkgreen; }

        .msg {
            color: red;
            text-align: center;
        }

        .link {
            text-align: center;
            margin-top: 10px;
        }
    </style>

    <script>
        function validateRegister() {
            let fullname = document.getElementsByName("fullname")[0].value.trim();
            let username = document.getElementsByName("username")[0].value.trim();
            let password = document.getElementsByName("password")[0].value.trim();
            let error = document.getElementById("errorMsg");

            if (fullname === "" || username === "" || password === "") {
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

    <h2>Register</h2>

    <p class="msg">${message}</p>
    <p class="msg" id="errorMsg"></p>

    <form action="RegisterServlets" method="post" onsubmit="return validateRegister()">
        <input type="hidden" name="action" value="register">

        <input type="text" name="fullname" placeholder="Full Name">
        <input type="text" name="username" placeholder="Username">
        <input type="password" name="password" placeholder="Password">

        <button type="submit">Register</button>
    </form>

    <div class="link">
        <a href="LoginServlet">Back to Login</a>
    </div>

</div>

</body>
</html>