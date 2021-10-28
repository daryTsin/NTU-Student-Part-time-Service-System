<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Publish Order</title>
</head>
<body>
<h1> Recruitment notice</h1><br>

	<span>
		${salary}
	</span>
<form action="PublishOrder" method="POST">

    Title: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="title" type="text" >
	</div>
	
	Job Type: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="type" type="text" >
	</div>
	
	Content: 
	<div >
	    <input name="content" type="text" >
	</div>
	
	Location: 
	<div >
	    <input name="location" type="text" >
	</div>
	
	PostCode: 
	<div >
	    <input name="postCode" type="text" >
	</div>
	
	Work Period: 
	<div >
	    <input name="workPeriod" type="text" >
	</div>
	
	Salary: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="salary" type="text" >
	</div>

	

	
	Required Staff Number: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="staffNumber" type="text" >
	</div>
	
	Deadline: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="deadline" type="date" value="2000-01-01" >
	</div>
			
	<input type="submit" name = "submit" value="Submit" />
	<input type="submit" name = "cancel" value="Cancel"  />

</form>
<%
out.println(request.getParameter("salary"));
%>

</body>
</html>