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
    <link rel="stylesheet" href="css/joblist.css">
    <link rel="stylesheet" href="css/share.css">
    <title>Favorite</title>
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

    <%@ include file="z_header_for_stu.jsp"%>
	
    <div class="content w">
        <div class="filter">
            <ul>
                <li class="first">STATUS</li>
                <li><a href="#">Processing</a></li>
                <li><a href="#">Approved</a></li>
                <li><a href="#">Rejected</a></li>
                <li><a href="#">Completed</a></li>
            </ul>
        </div>
        <div class="result">
            <div class="search">
                <form action="xxxxx" method="get">
                    <input type="text" placeholder="Title / Content / Location">
                </form>
                <input type="submit" name="search" value="" id="search" />
            </div>
            <div class="subtitle">
                <h2>Favorite Job List</h2>
            </div>
            <div class="joblist">
			<% 
			List<StudentApplyInfo> orders = (List<StudentApplyInfo>) request.getAttribute("orders");
			if(orders == null){
				orders = new ArrayList();
			}
			for (StudentApplyInfo oneorder:orders){
			%>
				<div class="onelist-ver2">
					<a href="">
						<img src="images/restaurant.jfif" title="<% out.print( oneorder.orderInfo.title); %>">
					</a>
					<div class="txt">
						<a href="">
							<% out.print( oneorder.orderInfo.title); %>
						</a>
							<ul>
							<li class="t1">Work Period:</li>
							<li><% out.print( oneorder.orderInfo.workPeriod); %></li>
							<li class="t2">Type:</li>
							<li><% out.print( oneorder.orderInfo.type); %></li>
							<li class="t1">Location:</li>
							<li><% out.print( oneorder.orderInfo.location); %></li>
							<li class="t2">Salary:</li>
							<li><% out.print( oneorder.orderInfo.salary); %></li>
							<li class="t1">Publish Date:</li>
							<li><% out.print( oneorder.orderInfo.publishTime); %></li>
							<li class="t2">Deadline:</li>
							<li><% out.print( oneorder.orderInfo.deadline); %></li>
						</ul>
					</div>
					<div class="detail">
                        <i>Status:&nbsp</i>
                        <span><% out.print( oneorder.status); %></span>
						<i>Remove from list:&nbsp</i>
						<form action="OrderCollect" method="get">
							<input type="submit" name="remove" value="Remove" id="remove" />
						</form>
                    </div>
				</div>
			<%
			}
			%>
			</div>
        </div>
    </div>
    <div class="share">
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

        var remove = document.querySelector('#remove');
        remove.onclick = function () {
            alert('\n' + request.getAttribute("result"); %>);
            location.reload();
            // 刷新页面
        }
    </script>
</body>

</html>