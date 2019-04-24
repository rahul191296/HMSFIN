<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
     <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<!DOCTYPE>

<html>
<title>MEDICENTER</title>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<style type="text/css">
*
{
    padding:0px;
    margin:0px;
}
body
{
    background-image:url("https://www.nosm.ca/wp-content/uploads/2018/04/Stephoscope-Laptop.jpg");
    background-size:100% 720px;
    background-repeat:none;
    background-attachment:fixed;




}

#header
{
overflow: hidden;
  background-color: #333;
  position: fixed; /* Set the navbar to fixed position */
  top: 0; /* Position the navbar at the top of the page */
  width: 100%; 
  padding-bottom:10px;
  padding-top:10px;
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
  color:white;
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
#details
{
  margin-top:7%;
  margin-left:5%;
  height:480px;
  padding:20px;
  width:22%;
  background-color:rgba(0,0,0,0.6);
  float:left;
  position:fixed;

}


#details img
{
 width:70%;
 height:200px;
 border-radius:50%;
 margin-left:10%
}

img
{
  padding:10px;
  width:90%;
  height:250px;
 margin-left:1%;
 }

button
{
 background-color:steelblue;
 padding:10px 25px; 
 border:none;
 color:white;
 cursor:pointer;
 font-weight:100;
 font-family:Helvetica, sans-serif;
}
form

{
    
width:30%;
height:810px;
background-color:rgba(0,0,0,0.5);
display:none;
float:right;
margin-right:10%;
margin-top:7%;



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
   
 
}

::placeholder
{
color:white;
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
}

option
{
 padding:15px;
}

#header
{
background-color:rgba(0,0,0,0.5);
}
#viewPatient
{
display:none;
float:right;
margin-top:7%;
margin-right:10%;
}

#viewPhysician
{
 display:none;
float:right;
margin-right:10%;
margin-top:7%;

}
#luck
{
display:block;
}

table {
  border-collapse: collapse;
  width: 90%;
}

th
{
  padding:12px;
  text-align: center;
  border: 1px solid #dddddd;
  color:white;
  background-color:steelblue;
}
td {
  text-align: center;
  padding:8px;
  border: 1px solid #dddddd;
  color:white;
  font-family:1200;
}



.overlay
{
 background-color:rgba(0,0,0,0.6);
 position: relative;
 width:100%;
 background-repeat: repeat-y;
 height:350%;
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
button.clicked
{
 transition: 0.70s;
  -webkit-transition: 0.70s;
  -moz-transition: 0.70s;
  -ms-transition: 0.70s;
  -o-transition: 0.70s;
  -webkit-transform: rotate(360deg);
  -moz-transform: rotate(360deg);
  -o-transform: rotate(360deg);
  -ms-transform: rotate(360deg);
  transform: rotate(360deg);
  }

#myBtn {
  display: none;
  position: fixed;
  bottom: 20px;
  right: 30px;
  z-index: 99;
  font-size: 18px;
  border: none;
  outline: none;
  background-color: steelblue;
  color: white;
  cursor: pointer;
  padding: 15px;
  border-radius: 4px;
}

#myBtn:hover {
  background-color:dogerblue;
}

.button {
 width:90%;
 margin-left:5%;
 margin-top:2%;
 margin-bottom:2%;
 color:white;
 padding:12px 12px;
 font-weight:bold;
  border-radius: 4px;
  background-color:Dogerblue;
  border: none;
  text-align: center;
  transition: all 0.5s;
  cursor: pointer;

}

.button span {
  cursor: pointer;
  display: inline-block;
  position: relative;
  transition: 0.5s;
}

.button span:after {
  content: '\00bb';
  position: absolute;
  opacity: 0;
  top: 0;
  right: -20px;
  transition: 0.5s;
}
.button:hover
{
 background-color:steelblue;
}

.button:hover span {
  padding-right: 25px;
 
}

.button:hover span:after {
  opacity: 1;
  right: 0;
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


#message3 {
  display:none;
  color: #000;
  position: relative;
  width:1%;
  float:right;
  margin-top:-12%;
  margin-right:5%;

  
}

#message3 p {
  font-size: 20px;
  
}

.valid3 {
  color: green;
}

.valid3:before {
  position: relative;
  left: -35px;
  content: "\2713";
}

.invalid3 {
  color: red;
}

.invalid3:before {
  position: relative;
  left: -35px;
  content: "X";
}


#message4 {
  display:none;
  color: #000;
  position: relative;
  width:1%;
  float:right;
  margin-top:-12%;
  margin-right:5%;

  
}

#message4 p {
  font-size: 20px;
  
}

.valid4 {
  color: green;
}

.valid4:before {
  position: relative;
  left: -35px;
  content: "\2713";
}

.invalid4 {
  color: red;
}

.invalid4:before {
  position: relative;
  left: -35px;
  content: "X";
}

</style>

<script>
function CreatePatient() {
  document.getElementById("PatientForm").style.display = "block";
  document.getElementById("PhysicianForm").style.display = "none";
  document.getElementById("viewPatient").style.display = "none";
  document.getElementById("viewPhysician").style.display = "none";
  document.getElementById("searchbar").style.display = "none";
  document.getElementById("physicianSearch").style.display = "none";
  
  document.body.style.backgroundImage = "url('https://www.nosm.ca/wp-content/uploads/2018/04/Stephoscope-Laptop.jpg')";
}

function CreatePhysician()
{
  document.getElementById("PhysicianForm").style.display = "block";
  document.getElementById("PatientForm").style.display = "none";
  document.getElementById("viewPatient").style.display = "none";
  document.getElementById("viewPhysician").style.display = "none";
  document.getElementById("physiciansearchbar").style.display = "none";
  document.getElementById("physicianSearch").style.display = "none";
  document.body.style.backgroundImage = "url('https://www.nosm.ca/wp-content/uploads/2018/04/Stephoscope-Laptop.jpg')";
}



function patientvalidate(dob)
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
	document.getElementById("dob").setAttribute("max", today);
	return true;
}

function physicianvalidate(pdob)
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
	document.getElementById("pdob").setAttribute("max",today);
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

function pagecalculator(agecal)
{ 
    var d=document.getElementById("pdob").value;
    var a=d.substring(0,4);
    var k=parseInt(a,10);
    var today=new Date();
    var yyyy=today.getFullYear();
    var s= yyyy-k;
	document.getElementById("pagecal").value=s;
   
    return true;
}



</script>
</head>

<body>
<div class ="overlay">
<div id="header">
<ul>
  <li><a class="active" href="home.htm"><strong>Medicenter</strong></a></li>
  
  <li style="float:right;"><a href="logoutUser.htm">Logout</a></li>
  <li style="float:right;"><a>Welcome!:${adminId} </a></li>
 
</ul>
</div>
<div id="details">
<h3 style="color:white;  background-color:steelblue; padding:10px 10px;">Admin ID: ${adminId}</h3>
<img src ="https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRjYxnF_qv1MHaA9wnlSwEMUM4gKzD-krMSF5nxulZoA2Xa8zj4"/><br><br><br>
<button onclick="CreatePatient()"; class="button"><span>Create Patient Details</span></button>
<form action="viewpatient.htm" style = "display:block; height:0px; width:100%; margin-top:-1%;">
<button style="margin-left:45px;" type="submit"  class="button"><span>View Patient Details</span></button>
</form>
<br><br><br><button style="margin-top:5%;" onclick="CreatePhysician()"; class="button" ><span>Create Physician Details</span></button>
<form action="viewphysician.htm" style = "display:block; height:0px; width:100%; margin-top:-1%;">
<button style="margin-left:45px;" type="submit" class="button"><span>View Physician Details</span></button>
</form>
</div>


<center><springform:form modelAttribute="patient" id="PatientForm" action="addPatientDetails.htm" method="get"  class="patient">
 
   <button type= "submit" style ="width:100%; color:white; font-weight:900;">PATIENT DETAILS</button><br><br>
  
  <springform:input  style="width:39%;" type ="text" placeholder="First Name" path ="firstName" required="required" pattern ="[A-Za-z]{3-12}"></springform:input>
   
 <springform:input style="width:39%;" type  ="text" placeholder ="Last Name" path ="lastName" required="required" pattern ="[A-Za-z]{3-12}" title="Username must be character"></springform:input><br><br>
 
   
<springform:input style=" color:white; padding-top:7.5px; padding-bottom:7.5px;" type ="date" placeholder ="Date of Birth" max="11-11-2001"
  path="doB" id="dob" onchange="return agecalculator(this)" onclick="return patientvalidate(this);" onkeypress="return false" ></springform:input><br><br>
 
<select name="gender" style="color:white;" required>
<option value="">Gender</option>
<option>Male</option>
<option>Female</option>

</select><br><br>
 
 <springform:input type ="tel" placeholder="Contact Number" path ="contactNumber"  required="required"  id="cno" pattern ="[6-9]{1}[0-9]{9}" title="Contact Number must be 10 digits" ></springform:input><BR>
  <springform:errors path="contactNumber" style="color:red"></springform:errors><br>
  <div id="message1">
  <p id="letter1" class="invalid1"></p>
 </div>
   
  <springform:input type = "text" placeholder ="Alternate Contact Number" path="altContactNumber"  id="acno" pattern ="[6-9]{1}[0-9]{9}"
   title="Alternate Contact Number must be 10 digits and not be same as Contact number" ></springform:input><br><br>
   <div id="message2">
  <p id="letter2" class="invalid2"></p>
 </div>
 
 
 <springform:input type ="text" placeholder="Emailid" path ="emailId" required="required" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" size="30"></springform:input><br><br>
   
 <springform:input type = "password" placeholder ="Password" path="password" required="required" id="psw" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
 title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></springform:input><br><br>
 <div id="message">
  <p id="letter" class="invalid"></p>
 </div>
 <springform:input type = "text" placeholder ="Address Line1" path="addressLine1" required="required"></springform:input><br><br>
 <springform:input type = "text" placeholder ="Address Line2" path="addressLine2" ></springform:input><br><br>

<select name="country" class="countries" id="countryId"  style="color:white;" required>
    <option value="">Select Country</option>
</select><br><br>

<select name="state" class="states" id="stateId"  style="color:white;" required>
    <option value="">Select State</option>
</select><br><br>

<select name="city" class="cities" id="cityId"  style="color:white;" required>
    <option value="">Select City</option>
</select><br><br>

 <springform:input type = "number" placeholder ="PinCode" path="zipCode" required="required" minlength="6"></springform:input><br><br>
 
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<script src="//geodata.solutions/includes/countrystatecity.js"></script> 

   <center><button type= "submit">SIGNUP</button></center>

</springform:form></center>



<center><springform:form modelAttribute="physician" id="PhysicianForm" style="height:750px;" action="addPhysicianDetails.htm" method="get">
 
   <button type= "submit" style ="width:100%; color:white; font-weight:900;">PHYSICIAN DETAILS</button><br><br>
  
  <springform:input  style="width:39%;" type ="text" placeholder="First Name" path ="firstName"  title="Username must be character" required="required"/>
   
 <springform:input style="width:39%;" type  ="text" placeholder ="Last Name" path ="lastName"  title="Username must be character" required="required" /><br><br>
 
<springform:input style="width:39%;" type ="number" placeholder="Age" path ="age" required="required" id="pagecal" ></springform:input>
   
<springform:input style="width:40%; color:white; padding-top:7.5px; padding-bottom:7.5px;" type ="date" placeholder ="Date of Birth" max="11-11-2001"
  path="doB" id="pdob" onchange="return pagecalculator(this);" onclick="return physicianvalidate(this);" onkeypress="return false" ></springform:input><br><br>
 
 <select name="gender" style="color:white;" required>
<option value="">Gender</option>
<option>Male</option>
<option>Female</option>

</select><br><br>
 
 <springform:input type ="tel" placeholder="Contact Number" path ="contactNumber"  required="required"  id="cno1" pattern ="[6-9]{1}[0-9]{9}" title="Contact Number must be 10 digits" ></springform:input><BR>
  <springform:errors path="contactNumber" style="color:red"></springform:errors><br>
  <div id="message3">
  <p id="letter3" class="invalid3"></p>
 </div>
   
  <springform:input type = "text" placeholder ="Alternate Contact Number" path="altContactNumber"  id="acno1" pattern ="[6-9]{1}[0-9]{9}"
   title="Alternate Contact Number must be 10 digits and not be same as Contact number" ></springform:input><br><br>
   <div id="message5">
  <p id="letter5" class="invalid5"></p>
 </div>
  

 <springform:input type ="email" placeholder="Emailid" path ="emailId" required="required"  pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,}$" size="30"/>
   <br><br>
 <springform:input type = "password" placeholder ="Password" path="password" required="required" id="psw1" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" 
 title="Must contain at least one number and one uppercase and lowercase letter, and at least 8 or more characters" ></springform:input><br><br>
 <div id="message4">
  <p id="letter4" class="invalid4"></p>
 </div>

 <springform:input style="width:39%;" type = "text" placeholder ="Degree" path="degree" required="required"  />
 <springform:input style="width:39%;" type = "text" placeholder ="Speciality" path="speciality" required="required" /><br><br>
 <select name="workHours" style="width:39%; color:white; required ">
     <option value="">Working Hours</option>
      <option style="padding:5px;">5 Hours</option>
       <option>6 Hours</option>
       <option>7 Hours</option>
       <option>8 Hours</option>
  
 </select>
 <springform:input style="width:39%;" type = "text" placeholder ="Hospital Name" path="hospitalName" required="required" /><br><br>
 <springform:input type = "text" placeholder ="Address Line" path="addressLine1" required="required" /><br><br>
 
<select name="country" class="countries" id="countryId"  style="color:white; width:40%;" required>
    <option value="">Select Country</option>
</select>

<select name="state" class="states" id="stateId"  style="color:white; width:40%; " required>
    <option value="">Select State</option>
</select><br><br>

<input type="text" name="city" placeholder="City" style="color:white; width:40%;" required>
   
</select>

 <springform:input type = "number" placeholder ="PinCode" path="zipCode"  minlength="6" required="required"  style="color:white; width:40%; "></springform:input><br><br>
 
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script> 
<script src="//geodata.solutions/includes/countrystatecity.js"></script> 
 
   <center><button type= "submit">SIGNUP</button></center>

</springform:form></center>




<button onclick="topFunction()" id="myBtn" title="Go to top"><i class="icon-arrow-up"></button>
</div>

<script>

//validation for patient Password
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

//validation for patient contact_number
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

//validation for patient alternate contact number
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


//validation for physician contact_number
var contact1 =  document.getElementById("cno1");

contact1.onfocus = function() 
{
  document.getElementById("message3").style.display = "block";
}

contact1.onblur = function()
{
  document.getElementById("message3").style.display = "none";
}

contact1.onkeyup = function() 
{
    var phonenumber = /^\d{10}$/;
    if(contact1.value.match(phonenumber))
   {  
    letter3.classList.remove("invalid3");
    letter3.classList.add("valid3");
   } else
   {
    letter3.classList.remove("valid3");
    letter3.classList.add("invalid3");
   }

 
}


//validation for physician Password
var myInput1 = document.getElementById("psw1");
var letter4 = document.getElementById("letter4");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");

myInput1.onfocus = function() {
document.getElementById("message4").style.display = "block";
}

myInput1.onblur = function() {
document.getElementById("message4").style.display = "none";
}

myInput1.onkeyup = function() {
// Validate lowercase letters
var lowerCaseLetters = /[a-z]/g;
var upperCaseLetters = /[A-Z]/g;
var numbers = /[0-9]/g;

if(myInput1.value.match(lowerCaseLetters) && myInput1.value.match(upperCaseLetters) && myInput1.value.match(numbers) &&myInput1.value.length >= 8) {  
  letter4.classList.remove("invalid4");
  letter4.classList.add("valid4");
} else {
  letter4.classList.remove("valid4");
  letter4.classList.add("invalid4");
}


}

//onscroll function
window.onscroll = function() {scrollFunction()};

function scrollFunction() {
  if (document.body.scrollTop > 20 || document.documentElement.scrollTop > 20) {
    document.getElementById("myBtn").style.display = "block";
  } else {
    document.getElementById("myBtn").style.display = "none";
  }
}

// When the user clicks on the button, scroll to the top of the document
function topFunction() {
  document.body.scrollTop = 0; // For Safari
  document.documentElement.scrollTop = 0; //For Chrome, Firefox, IE and Opera
}

</script>
</body>
</html>