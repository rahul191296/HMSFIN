<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">

*
{
 padding:0px;
 margin:0px;
}

body
{
  background-color:rgba(0,0,0,0.3);

background-image: linear-gradient(0, 0, 0,0.5)"https://images.pexels.com/photos/1877288/pexels-photo-1877288.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"
}
ul {
  list-style-type: none;
  margin: 0;
  padding: 0;
  overflow: hidden;
  padding-top:15px;
  padding-bottom:15px;
  padding-left:25px;
background-color:rgba(0,0,0,0.5);

}

li {
  float:left;

}

li a {
  display: block;
  color: black;
  text-align: center;
  padding: 12px 16px;
  text-decoration: none;
  font-weight:900;
  font-size:18px;
  color:white;


}

.active {
  background-color: #4CAF50;
  float:right;
}
form

{
    
width:30%;
height:520px;
background-color:rgba(0,0,0,0.6);
margin-top:2%;
float:right;
margin-right:20%;


}

input

{
   padding-top:10px;
   padding-bottom:10px;
   padding-left:5px;
   background-color:rgba(0,0,0,0.5);
   border:none;
   color:white;
   width:80%;
   outline:none;
   border-radius:15px;
 
}

select
{
   padding-top:9px;
   padding-bottom:9px;
   padding-left:2px;
   background-color:rgba(0,0,0,0.5);
   border:none;
   color:grey;
   width:80%;
   outline:none;
   width:82%;
}

option
{
    color:white;
    
}

button
{
 padding:15px 25px;
 width:45%;
 color:white;
 background-color:#154575;
 border:none;
 cursor:pointer;
 border-radius:40px;
}
button:hover
{
    background-color:#113A62;
}

#message {
  display:none;
  color: #000;
  position: relative;
  width:1%;
  float:right;
  margin-top:-12%;
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
  left: -35px;
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
  margin-top:-12%;
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
  margin-top:-12%;
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
</head>
<body>
<ul>
  <li><a class="active" href="login.htm"><strong>Medicenter</strong></a></li>
  <li style="float:right;"><a href="login.htm">LOGIN</a></li>
</ul> 

<img src="https://images.pexels.com/photos/1549001/pexels-photo-1549001.jpeg?auto=compress&cs=tinysrgb&dpr=1&w=500"/>

<center><springform:form  modelAttribute="admin" method="post" action="doRegistration.htm">
 
 <li style ="width:100%;background-color:#113A62; color:white;padding-top:10px;padding-bottom:10px; list-style-type:none;">ADMIN REGISTRATION</li><br><br><br>
 
 <springform:input path="firstName" style="width:40%;" type ="text" placeholder="First Name" />
   
 <springform:input path="lastName" style="width:40%;" type  ="text" placeholder ="Last Name"  /><br><br>
 
 <springform:input style="width:40%;" type ="text" placeholder="Age" path ="age" id="agecal" readonly="true"></springform:input>
   
 <springform:input style="width:40%; color:grey; padding-top:7.5px; padding-bottom:7.5px;" type ="date" placeholder ="Date of Birth" max="11-11-2001"
  path="doB" id="dob" onchange="return agecalculator(this)" onclick="return validate(this);" onkeypress="return false" ></springform:input><br><br>

<select name="gender" style="color:white; border-radius:15px" required>
<option value="">Gender</option>
<option>Male</option>
<option>Female</option>
 </select><br><br>
 <springform:input type ="tel" placeholder="Contact Number" path ="contactNumber" id="cno" pattern ="[6-9]{1}[0-9]{9}" title="Contact Number must be 10 digits" ></springform:input>
  <springform:errors path="contactNumber" style="color:red"></springform:errors><br><br>
  <div id="message1">
  <p id="letter1" class="invalid1"></p>
 </div>
   
 <springform:input type = "text" placeholder ="Alternate Contact Number" path ="altContactNumber" id="acno" pattern ="[6-9]{1}[0-9]{9}"
   title="Alternate Contact Number must be 10 digits and not be same as Contact number" ></springform:input><br><br>
   <div id="message2">
  <p id="letter2" class="invalid2"></p>
 </div>
 
 <springform:input type ="text" placeholder="Email Id" path ="emailId" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" size="30"></springform:input><br><br>
 <springform:errors path="emailId" style="color:red"></springform:errors>
   
 <springform:input type = "password" placeholder ="Password" path="password"  id="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
 title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></springform:input><br><br>
 <div id="message">
  <p id="letter" class="invalid"></p>
 </div>

 
   <center><button type="submit" onclick="signup();" >SIGNUP</button></center>

</springform:form></center>

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