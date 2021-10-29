<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.*" %>
<%@ page import="pojo.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0">
    <link rel="stylesheet" href="css/header.css">
    <link rel="stylesheet" href="css/jd.css">
    <link rel="stylesheet" href="css/share.css">
    <title>Job Description</title>
    <style>
        @font-face {
            font-family: 'icomoon';
            src: url('fonts/icomoon.eot?g7qitb');
            src: url('fonts/icomoon.eot?g7qitb#iefix') format('embedded-opentype'),
                url('fonts/icomoon.ttf?g7qitb') format('truetype'),
                url('fonts/icomoon.woff?g7qitb') format('woff'),
                url('fonts/icomoon.svg?g7qitb#icomoon') format('svg');
            font-weight: normal;
            font-style: normal;
            font-display: block;
        }
    </style>
    <script type="text/javascript" src="js/animate.js"></script>
</head>

<body>

    <%
	if (session.getAttribute("usertype") == "student") {
	%>
    <%@ include file="z_header_for_stu.jsp"%>
	<%
	}
	else {
	%>
     <%@ include file="z_header_for_mer.jsp"%>
	<%
	}
	%>

    <div class="content w">
        <div class="subtitle">
            <h2>Job Description</h2>
        </div>
        <div class="detail clearfix">
            <div class="left">
                <img src="images/restaurant.jfif" alt="">
            </div>
            <div class="right">
			<% 
			OrderInfo oneorder = (OrderInfo) request.getAttribute("order");
			%>
                <h2><% out.print( oneorder.title); %></h2>
                <ul class="l1">
                    <li class="t1">Type:</li>
                    <li><% out.print( oneorder.type); %></li>
                    <li class="t2">Salary:</li>
                    <li><% out.print( oneorder.salary); %></li>
                    <li class="t1">Status:</li>
                    <li><% out.print( oneorder.status); %></li>
                    <li class="t2">Staff Number:</li>
                    <li><% out.print( oneorder.staffNumber); %></li>
                    <li class="t1">Deadline:</li>
                    <li><% out.print( oneorder.deadline); %></li>
                    <li class="t2">Published time:</li>
                    <li><% out.print( oneorder.publishTime); %></li>
                    <li class="t1">Location:</li>
                    <li><% out.print( oneorder.location); %></li>
                    <li class="t2">Work Period:</li>
                    <li><% out.print( oneorder.workPeriod); %></li>
                </ul>
                <span>Descriptions:</span>
                <p>
                    <% out.print( oneorder.content); %>
                </p>
            </div>
        </div>
        <!-- 判断：加button -->
		<%
		if (session.getAttribute("usertype") == "student") {
		%>
		<div class="operation">
            <form action="OrderApply" method="get">
                <input type="submit" name="apply" value="Apply" class="apply" />
            </form>
            <form action=" OrderCollect" method="get">
                <input type="submit" name="favorite" value="Favorite" class="favorite" />
            </form>
        </div>
		<%
		}
		%>
		
    </div>
    <div class=" share">
        <div class="slidebar">
            <a href="">
                <i></i>
                <span>share</span>
            </a>
        </div>
    </div>

    <script type="text/javascript">
        var share = document.querySelector('.share');
        var slidebar = document.querySelector('.slidebar');
        share.addEventListener('mouseenter', function () {
            animate(slidebar, -100);
        })
        share.addEventListener('mouseleave', function () {
            animate(slidebar, 0);
        })
        slidebar.onclick = function () {
            alert('\nLink copied successfully.\nGo and share with others!');
        }


        var apply = document.querySelector('.apply');
        apply.onclick = function () {
            alert('\n' + request.getAttribute("result"); %>);
        }


        var favorite = document.querySelector('.favorite');
        favorite.onclick = function () {
            alert('\n' + request.getAttribute("result"); %>);
        }
    </script>
</body>

</html>