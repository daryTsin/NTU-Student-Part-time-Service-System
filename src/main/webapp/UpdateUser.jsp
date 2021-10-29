<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ApplyJob</title>
</head>
<body>
<h1> Apply</h1><br>


<script type="text/javascript">
  function validateForm() {
	 var name = document.forms["userform"]["name"].value;
	 var gender = document.forms["userform"]["gender"].value;
	 var fin = document.forms["userform"]["finNo"].value;
	 var email = document.forms["userform"]["email"].value;
	 var phoneNumber = document.forms["userform"]["phoneNumber"].value;
	 
	 if (name == null ||name == ""||gender == null ||gender == ""|| fin == null ||fin == ""||email == null ||email == ""||phoneNumber == null ||phoneNumber == "") 
	 {
		 alert("Please Fill All Required Field!");
		 return false;onsubmit="return validateForm()"
		 }
}
</script>

 
<form action="updateUser" method="POST" name="userform" onsubmit="return validateForm()">

    Name: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="name" type="text" />
	</div>
	
	Matriculation No: 
	<div >
	    <input name="matriculationNo" type="text" />
	</div>
	
	<div>
	Gender: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i><br>
	<select name="gender" id="gender" style= "wighth= 30">
	<optgroup label="Gender">
	<option value="female">Female</option>
    <option value="male">Male</option>
    </optgroup>
    </select>
	</div>


<!-- 	<div > -->
<!-- 	    <input name="gender" type="text" /> -->
<!-- 	</div> -->
	
	Age: 
	<div >
	    <input name="age" type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
	</div>
	
	Nationality: 
	<div >
	    <input name="nationality" type="text" />
	</div>
	
	Year Of Study: 
	<div >
	    <input name="yearOfStudy" type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');"  />
	</div>
	
	FIN: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="finNo" type="text"   />
	</div>

	

	
	Email: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="email" type="email" />
	</div>
	
	Mobile No: <i style="color: rgb(238, 44, 74); font-style: normal;"> *</i>
	<div >
	    <input name="phoneNumber" type="text" oninput="this.value = this.value.replace(/[^0-9.]/g, '').replace(/(\..*)\./g, '$1');" />
	</div>
	
	<div>
	 Degree: <br>
	<select name="degree" id="degree" >
	<optgroup label="Select">
	<option value="bachelor">bachelor</option>
	<option value="master">master</option>
    <option value="doctor">doctor</option>
    </optgroup>
    </select>
	</div>
	
<!-- 	<div > -->
<!-- 	    <input name="degree" type="text" /> -->
<!-- 	</div> -->
	
	Remark: 
	<div >
	    <input name="remark" type="text" />
	</div>
	
	Program: 
	<div >
	    <input name="program" type="text" />
	</div>
	
	Experience: 
	<div >
	    <textarea name="experience" >
	    </textarea>
	</div>
			
	<input type="submit" name = "submit" value="Submit" />
	<input type="button" name = "cancel" value="Cancel" onclick="javascript:history.back(-1)"  />

</form>


</body>
</html>