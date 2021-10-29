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


 <script type="text/javascript">
 function validateForm() {
	 var salary = document.forms["form"]["salary"].value;
	 var staffNumber = document.forms["form"]["staffNumber"].value;
	 var title = document.forms["form"]["title"].value;
	 var type = document.forms["form"]["type"].value;
	 
	 if (salary == null ||salary == ""||staffNumber == null ||staffNumber == ""|| title == null ||title == ""||type == null ||type == "") 
	 {
		 alert("Please Fill All Required Field!");
		 return false;
		 }
}
 </script>
 
<form action="PublishOrder" method="POST" name="form" onsubmit="return validateForm()">

    Title: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="title" type="text" />
	</div>
	
	Job Type: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="type" type="text" />
	</div>
	
	Content: 
	<div >
	    <input name="content" type="text" />
	</div>
	
	Location: 
	<div >
	    <input name="location" type="text" />
	</div>
	
	PostCode: 
	<div >
	    <input name="postCode" type="text" />
	</div>
	
	Work Period: 
	<div >
	    <input name="workPeriod" type="text" />
	</div>
	
	Salary: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="salary" type="text"  oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
	</div>

	

	
	Required Staff Number: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="staffNumber" type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
	</div>
	
	Deadline: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="deadline" type="date" value= "2017-01-01" />
	</div>
			
	<input type="submit" name = "submit" value="Submit" />
	<input type="submit" name = "cancel" value="Cancel"  />

</form>


</body>
</html>