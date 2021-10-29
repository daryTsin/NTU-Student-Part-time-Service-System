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
    <link rel="stylesheet" href="css/waitinglist.css">
    <title>Waiting List</title>
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
</head>

<body>

	<%@ include file="z_header_for_mer.jsp"%>
	
	
    <div class="content w">
        <div class="subtitle">
            <h2>Students in Waiting List</h2>
        </div>
		
		<div class="wlist">
			<% 
			List<StudentApplyInfo> orders = (List<StudentApplyInfo>) request.getAttribute("orders");
			if(orders == null){
				orders = new ArrayList();
			}
			for (StudentApplyInfo oneorder:orders){
			%>
				<div class="onelist">
                    <ul class="clearfix">
                        <li class="t">Job Title:</li>
                        <li><% out.print( oneorder.orderInfo.title); %></li>
                        <li class="t">Age:</li>
                        <li><% out.print( oneorder.studentInfo.age); %></li>
                        <li class="t">Name:</li>
                        <li><% out.print( oneorder.studentInfo.name); %></li>
                        <li class="t">Major:</li>
                        <li><% out.print( oneorder.studentInfo.program); %></li>
                        <li class="t">Gender:</li>
                        <li><% out.print( oneorder.studentInfo.gender); %></li>
                        <li class="t">Nationality:</li>
                        <li><% out.print( oneorder.studentInfo.nationality); %></li>
                    </ul>
                    <span>Details:</span>
                    <p>
                        <% out.print( oneorder.remark); %>
                    </p>
                    <div class="operation">
						<form action="ApplicationHandle" method="get">
							<input type="submit" name="accept" value="Accept" id="accept" />
						</form>
						<form action="ApplicationHandle" method="get">
							<input type="submit" name="reject" value="Reject" id="reject" />
						</form>
                    </div>
                </div>
			<%
			}
			%>
		</div>
    </div>
	
    <script type="text/javascript">

        var accept = document.querySelector('#accept');
        accept.onclick = function () {
            alert('\n' + <% out.print( request.getAttribute("result")); %>);
            location.reload();
            // 刷新页面
        }
        var reject = document.querySelector('#reject');
        reject.onclick = function () {
            alert('\n' + request.getAttribute("result"); %>);
            location.reload();
        }

    </script>
</body>

</html>