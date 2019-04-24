<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UPDATE PHYSICIAN</title>
<style>
*
{
padding:0px;
margin:0px;
}
body
{
    background-image:url("https://www.nosm.ca/wp-content/uploads/2018/04/Stephoscope-Laptop.jpg");
    background-size:100% 720px;
    background-repeat:no-repeat;
    background-attachment:fixed;
    overflow:hidden;
    }
ul {
  Display:block;
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  padding-top:15px;
  padding-bottom:15px;
  padding-left:25px;
  
}

li {
  float:left;
}

li a {
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
  font-weight:100;
  font-size:18px;
  font-family:Helvetica, sans-serif;


}


li a:hover:not(.active) {
  background-color:rgba(0, 181, 204, 1);
  border:none;
}

.active {
 background-color: STEELBLUE;
border:none;
}
label
{
 padding:8px;
 color:white;
}td
{
 padding:8px;
 font-family:bold;
}

input
{
 padding:10px 30px;
 border:none;
}

button
{
  padding:10px 30px;
 color:white;
 background-color:steelblue;
 border:none;
 box-shadow: 5px 10px black;
 cursor:pointer;
}
.overlay
{
 background-color:rgba(0,0,0,0.7);
 width:100%;
 height:680px;
}
#message {
  display:none;
  color: #000;
  position: relative;
  width:1%;
  float:right;
  margin-top:1%;
  margin-right:5%;

  
}

#message p {
  font-size: 20px;
  
}


/* Add a green text color and a checkmark when the requirements are right */
.valid {
  color: green;
}

.valid:before {
  position: relative;
  left: -15px;
  content: "\2713";
}

/* Add a red text color and an "x" when the requirements are wrong */
.invalid {
  color: red;
}

.invalid:before {
  position: relative;
  left: -35px;
  content: "X";
}

#message1 {
  display:none;
  color: #000;
  position: relative;
  width:1%;
  float:right;
  margin-top:2%;
  margin-right:5%;

  
}

#message1 p {
  font-size: 20px;
  
}

.valid1 {
  color: green;
}

.valid1:before {
  position: relative;
  left: -35px;
  content: "\2713";
}

.invalid1 {
  color: red;
}

.invalid1:before {
  position: relative;
  left: -35px;
  content: "X";
}


#message2 {
  display:none;
  color: #000;
  position: relative;
  width:1%;
  float:right;
  margin-top:2%;
  margin-right:5%;

  
}

#message2 p {
  font-size: 20px;
  
}

.valid2 {
  color: green;
}

.valid2:before {
  position: relative;
  left: -35px;
  content: "\2713";
}

.invalid2 {
  color: red;
}

.invalid2:before {
  position: relative;
  left: -35px;
  content: "X";
}

img
{
    width:30%;
    margin-left:20%;
    height:520px;
    float:left;
    margin-top:2%;
}

.dateclass {
  width: 100%;
}

.dateclass.placeholderclass::before {
  width: 100%;
  content: attr(placeholder);
}

.dateclass.placeholderclass:hover::before {
  width: 0%;
  content: "";
}
</style>
<script>
function validate(dob)
{
	var today=new Date();
	var dd=today.getDate();
	var mm=today.getMonth()+1;
	var yyyy=today.getFullYear()-21;
	if(dd<10){
		dd='0'+dd;
	}
	if(mm<10){
		mm='0'+mm;
	}
	today=yyyy+'-'+mm+'-'+dd;
	document.getElementById("dob").setAttribute("max",today);
	return true;
}

function agecalculator(agecal)
{ 
    var d=document.getElementById("dob").value;
    var a=d.substring(0,4);
    var k=parseInt(a,10);
    var today=new Date();
    var yyyy=today.getFullYear();
    var s= yyyy-k;
	document.getElementById("agecal").value=s;
   
    return true;
}
</script>
</head>
<body>
<div class="overlay">
<ul>
  <li><a class="active" href="home.htm" style ="color:white;"><strong>Medicenter</strong></a></li>
  
  <li style="float:right; "><a style="color:white;"href="logoutUser.htm">Logout</a></li>
  <li style="float:right; color:white;"><a>Welcome!:${adminId} </a></li>
 
</ul>
<center><springform:form modelAttribute="updatePhysician" method="get" action="updatePhysicianDetails.htm" >
<table>
<tr>
<td><springform:label path="physicianId">PhysicianID:</springform:label>
<td><springform:input path="physicianId" readonly="true"/>
<td><springform:label path="firstName">First Name:</springform:label>
<td><springform:input path="firstName"></springform:input>
</td>
</tr>

<tr>

<td><springform:label path="lastName">Last Name:</springform:label>
<td><springform:input path="lastName"></springform:input>
<td><springform:label path="gender">Gender:</springform:label></td>
<td>
<select name="gender" style="color:black; width:99%; height:33px">
<option>Gender</option>
<option>Male</option>
<option>Female</option>
</td>
</tr>

<tr>	
<td><springform:label path="age">Age:</springform:label>
<td><springform:input path="age" id="agecal" readonly="true"></springform:input>
<td><springform:label path="doB" >DoB:</springform:label>
<td><springform:input type="date" path="doB" style="width:74%; height:17px " id="dob" onchange="return agecalculator(this)" onclick="return validate(this);" onkeypress="return false" ></springform:input>
</tr>

 <tr>
<td><springform:label path="password">Password:</springform:label>
<td><springform:input path="password" type="password" id="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
 title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></springform:input>
 <div id="message">
  <p id="letter" class="invalid"></p>
 </div>
<td><springform:label path="contactNumber">Contact_Number:</springform:label>
<td><springform:input path="contactNumber" id="cno" pattern ="[6-9]{1}[0-9]{9}" title="Contact Number must be 10 digits" ></springform:input>
  <springform:errors path="contactNumber" style="color:red"></springform:errors>
  <div id="message1">
  <p id="letter1" class="invalid1"></p>
 </div>
</tr> 

<tr>
<td><springform:label path="altContactNumber">Alt_Contact_Number:</springform:label>
<td><springform:input path="altContactNumber" id="acno" pattern ="[6-9]{1}[0-9]{9}"
   title="Alternate Contact Number must be 10 digits and not be same as Contact number" ></springform:input>
   <div id="message2">
  <p id="letter2" class="invalid2"></p>
 </div>
<td><springform:label path="emailId">Email_Id:</springform:label>
<td><springform:input path="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$"></springform:input>
</tr>

<tr>
<td><springform:label path="addressLine1">Address_Line1:</springform:label>
<td><springform:input path="addressLine1"></springform:input>
<td><springform:label path="addressLine2">Address_Line2:</springform:label>
<td><springform:input path="addressLine2"></springform:input>
</tr>
<tr>
<td><springform:label path="city">City:</springform:label>
<td><springform:input path="city"></springform:input>
<td><springform:label path="state">State:</springform:label>
<td><springform:input path="state"></springform:input>
</tr>
<tr>
<td><springform:label path="zipCode">Zip_Code:</springform:label>
<td><springform:input type="number" path="zipCode" minlength="6"></springform:input>
<td><springform:label path="degree">Degree:</springform:label>
<td><springform:input path="degree"></springform:input>
</tr>


<tr>

<td><springform:label path="workHours">Work_Hours:</springform:label>
<td><springform:input path="workHours"></springform:input>
<td><springform:label path="hospitalName">Hospital_Name:</springform:label>
<td><springform:input path="hospitalName"></springform:input>
<td><button type="submit" value="Update">Update</button><br></td>
</tr>


</table>
</springform:form></center>
${status}
</div>
<script>
function signup()
{
 alert("Congratulation! You have registered Successfully",admin);	
}

function validate(dob)
{
	var today=new Date();
	var dd=today.getDate();
	var mm=today.getMonth()+1;
	var yyyy=today.getFullYear();
	if(dd<10){
		dd='0'+dd;
	}
	if(mm<10){
		mm='0'+mm;
	}
	today=yyyy+'-'+mm+'-'+dd;
	document.getElementById("doB").setAttribute("max", today);
}

function agecalculator(agecal)
{ 
    var d=document.getElementById("dob").value;
    var a=d.substring(0,4);
    var k=parseInt(a,10);
    var today=new Date();
    var yyyy=today.getFullYear();
    var s= yyyy-k;
    if(s<18)
    	{
    	alert("Age less than 18 Not eligible to register");
    	document.getElementById("agecal").value="";
    	return false;
    	}
    else if(s>18)
    	{
    	document.getElementById("agecal").value=s;
    	}
    else{
    	document.getElementById("agecal").value="";
    	alert("please enter dob");
    	return false;
    }
    return true;
}

</script>
<script>
//validation for Password
var myInput = document.getElementById("psw");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}

myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}

myInput.onkeyup = function() {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  var upperCaseLetters = /[A-Z]/g;
  var numbers = /[0-9]/g;
  
  if(myInput.value.match(lowerCaseLetters) && myInput.value.match(upperCaseLetters) && myInput.value.match(numbers) &&myInput.value.length >= 8) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }

 
}

//validation for contact_number
var contact =  document.getElementById("cno");
var letter1 = document.getElementById("letter1");
contact.onfocus = function() 
{
  document.getElementById("message1").style.display = "block";
}

contact.onblur = function()
{
  document.getElementById("message1").style.display = "none";
}

contact.onkeyup = function() 
{
    var phoneno = /^\d{10}$/;
    if(contact.value.match(phoneno))
   {  
    letter1.classList.remove("invalid1");
    letter1.classList.add("valid1");
   } else
   {
    letter1.classList.remove("valid1");
    letter1.classList.add("invalid1");
   }

 
}

//validation for alternate contact number
var alternate_contact = document.getElementById("acno");
var letter2 = document.getElementById("letter2");
alternate_contact.onfocus = function()
{
 document.getElementById("message2").style.display = "block";
}

alternate_contact.onblur = function()
{
  document.getElementById("message2").style.display = "none";
}

alternate_contact.onkeyup = function() 
{
    var phoneno = /^\d{10}$/;
    if(alternate_contact.value.match(phoneno) && contact.value != alternate_contact.value)
   {  
    letter2.classList.remove("invalid2");
    letter2.classList.add("valid2");
   } else
   {
    letter2.classList.remove("valid2");
    letter2.classList.add("invalid2");
   }

 
}

</script>
</body>
</html>