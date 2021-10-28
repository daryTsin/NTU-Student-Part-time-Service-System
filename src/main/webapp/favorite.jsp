<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                <c:forEach var="oneorder" items="${GetOrders.orders}">
                    <div class="onelist-ver2">
                        <a href="${job_description?orderID=${oneorder.orderID}">
                            <img src="images/restaurant.jfif" alt="${oneorder.title}">
                        </a>
                        <div class="txt">
                            <a href="${job_description?orderID=${oneorder.orderID}">
                                ${oneorder.title}
                            </a>
                            <ul>
                                <li class="t1">Work Period:</li>
                                <li>${oneorder.type}</li>
                                <li class="t2">Type:</li>
                                <li>${oneorder.type}</li>
                                <li class="t1">Location:</li>
                                <li>${oneorder.location}</li>
                                <li class="t2">Salary:</li>
                                <li>${oneorder.salary}</li>
                                <li class="t1">Publish Date:</li>
                                <li>${oneorder.publishTime}</li>
                                <li class="t2">Deadline:</li>
                                <li>${oneorder.deadline}</li>
                            </ul>
                        </div>
                        <div class="detail">
                            <i>Status:&nbsp</i>
                            <span>${oneorder.status}</span>
                            <i>Remove from list:&nbsp</i>
                            <input type="submit" name="remove" value="Remove" id="remove" />
                        </div>
                    </div>
                </c:forEach>
            </div>
            <div class="page">
                <div class="detail">
                    <a href="$xxxxx?pageIndex=0">First Page</a>
                    <c:if test="${ pageIndex>=2 }">
                        <a href="$xxxxx?pageIndex=${pageIndex-2}">Previous</a>&nbsp;
                    </c:if>
                    <span>${pageIndex}/${pageTotal}</span>
                    <c:if test="${pageIndex<pageTotal}">
                        <a href="$xxxxx?pageIndex=${pageIndex}">Next</a>&nbsp;
                    </c:if>
                    <a href="$xxxxx?pageIndex=${pageTotal-1}">Last Page</a>
                </div>
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
            alert('\n' + ${ OrderCollect.result });
            location.reload();
            // 刷新页面
        }
    </script>
</body>

</html>