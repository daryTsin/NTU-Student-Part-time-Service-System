<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
    <link rel="stylesheet" href="css/header.css">
</head>

<body>
    <div class="header w">
        <div class="logo">
            <img src="images/logo.png" alt="">
        </div>
        <div class="login">
            <i><img src="images/login.jfif" alt=""></i>
            <span>${sessionScope.account}</span>
        </div>
    </div>
    <div class="nav">
        <ul class="w">
            <li><a href="#">Home</a></li>
            <li><a href="#">Favorite</a></li>
            <li><a href="#">Applied</a></li>
            <li><a href="#">Logout</a></li>
        </ul>
    </div>
</body>

</html>