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
            <!-- <span><%=session.getAttribute("account")%></span> -->
        </div>
    </div>
    <div class="nav">
        <ul class="w">
            <li class="li-ver2"><a href="#">Home</a></li>
            <li class="li-ver2"><a href="#">Published</a></li>
            <li class="li-ver2"><a href="#">Waiting List</a></li>
            <li class="li-ver2"><a href="#">Publish New</a></li>
            <li class="li-ver2"><a href="#">Logout</a></li>
        </ul>
    </div>
</body>

</html>