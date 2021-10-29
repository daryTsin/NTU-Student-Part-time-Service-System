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
    <title>Home</title>
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
        <div class="filter">
            <ul>
                <li class="first">TYPE</li>
                <li><a href="#" id="onefilter">restaurant</a></li>
                <li><a href="#" id="onefilter">hotel</a></li>
                <li><a href="#" id="onefilter">school</a></li>
                <li><a href="#" id="onefilter">volunteer</a></li>
                <li><a href="#" id="onefilter">park</a></li>
            </ul>
        </div>
        <div class="result">
            <div class="search">
                <form action="GetOrders" method="get" id="myform">
                    <input type="text" name="search" placeholder="Title / Content / Location" id="search">
					<input type="submit" value="?" id="searchicon" />
				</form>
            </div>
           
            <div class="joblist">
			<% 
			List<OrderInfo> orders = (List<OrderInfo>) request.getAttribute("orders");
			if(orders == null){
				orders = new ArrayList();
			}
			for (OrderInfo oneorder:orders){
			%>
				<div class="onelist">
					<a href="">
						<img src="images/restaurant.jfif" title="<% out.print( oneorder.title); %>">
					</a>
					<div class="txt">
						<a href="">
							<% out.print( oneorder.title); %>
						</a>
							<ul>
							<li class="t1">Work Period:</li>
							<li><% out.print( oneorder.workPeriod); %></li>
							<li class="t2">Type:</li>
							<li><% out.print( oneorder.type); %></li>
							<li class="t1">Location:</li>
							<li><% out.print( oneorder.location); %></li>
							<li class="t2">Salary:</li>
							<li><% out.print( oneorder.salary); %></li>
							<li class="t1">Publish Date:</li>
							<li><% out.print( oneorder.publishTime); %></li>
							<li class="t2">Deadline:</li>
							<li><% out.print( oneorder.deadline); %></li>
						</ul>
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
            <i>?</i>
            <span>share</span>
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
        };
  
  
  var search = document.querySelector('#search').value;
        // 1. 获取所有按钮元素
  var filter = document.querySelector('.filter');
        var btns = filter.getElementsByTagName('a');
  var searchicon = document.querySelector('#searchicon');
        // btns得到的是伪数组  里面的每一个元素 btns[i]
        for (var i = 0; i < btns.length; i++) {
            btns[i].onclick = function() {
                // (1) 先把所有的按钮deafult
                for (var i = 0; i < btns.length; i++) {
                    btns[i].style.backgroundColor = '#fff';
     btns[i].style.color='rgb(68, 114, 196)';
                }
                // (2) 当前的元素
    this.style.backgroundColor = 'rgb(68, 114, 196)';
    this.style.color='#fff';
    var type = this.innerText;
    request.setAttribute("type",type);
    request.setAttribute("search",search);
    var myform = document.getElementById('myform');
    myform.submit();
            }
        }
  
  

    </script>
</body>

</html>