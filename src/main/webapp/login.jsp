<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/login.css">
    <title>Login</title>

</head>

<body>
    <div class="header">
        <div class="logo">
            <img src="images/logo.png" alt="">
        </div>
    </div>
    <div class="content">
        <div class="box">
            <h2>Login</h2>
            <form action="login" method="get">
                <div class="clearfix">
                    <div class="clearfix">
                        <span>Account:&nbsp;&nbsp;</span>
                        <input class="text" name="account" id="account" type="text">
                    </div>
                    <div class="clearfix">
                        <span>Password:</span>
                        <input class="text" name="password" id="password" type="password">
                    </div>
                </div>
                <div class="container clearfix">
                    <div class="radio">
                        <input id="radio-1" name="radio" id="stu" type="radio" value="stu" checked="checked">
                        <label for="radio-1" class="radio-label">Student</label>
                    </div>
                    <div class="radio">
                        <input id="radio-2" name="radio" id="mer" type="radio" value="mer">
                        <label for="radio-2" class="radio-label">Merchant</label>
                    </div>
                </div>
                <i class="msg">&nbsp;</i>
                <input type="submit" name="login" value="Sign In" class="button" onclick="check();" />
            </form>
        </div>
    </div>
    <script type="text/javascript">
        function check() {
            var result = ${result};
            if (result == 'login fail') {
                var msg = document.querySelector('.msg');
                document.document.querySelector('.msg').innerHTML = 'The account or password is incorrect.';
            }
            if (result == 'login success') {
                window.location.replace("home.jsp")
            }
        }
    </script>
</body>

</html>