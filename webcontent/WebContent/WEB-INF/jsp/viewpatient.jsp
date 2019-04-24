<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
        <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%--     <%@ page isELIgnored="false" %> --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
     <link href="//netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css" rel="stylesheet">
<title>VIEW PATIENT</title>
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
 height:1200px;

}

#viewPatient
{
 margin-top:5%;
}
#viewPatient input {
	outline: none;
	color:black;
	background-color:rgba(0,0,0,0.5);
	margin-top:-4%;
	position:fixed;

	}
#viewPatient  input[type=text] {
	-webkit-appearance: textfield;
	-webkit-box-sizing: content-box;
	font-family: inherit;
	font-size: 100%;
}


#viewPatient  input[type=text] {
	background: #ededed url(https://static.tumblr.com/ftv85bp/MIXmud4tx/search-icon.png) no-repeat 9px center;
	border: solid 1px #ccc;
	padding: 9px 10px 9px 32px;
	width: 200px;	
	border-radius:25px;
	-webkit-transition: all .5s;
	-moz-transition: all .5s;
	transition: all .5s;
}
#viewPatient  input[type=text]:focus {
	width: 300px;
	background-color:rgba(255,255,255,0.5);
	border-color: #66CC75;
	
	-webkit-box-shadow: 0 0 5px rgba(109,207,246,.5);
	-moz-box-shadow: 0 0 5px rgba(109,207,246,.5);
	box-shadow: 0 0 5px rgba(109,207,246,.5);
}


#viewPatient  input:-moz-placeholder {
	color: black;
}
#viewPatient input::-webkit-input-placeholder {
	color: black;
}


#myBtn {
 
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
</style>
<script type="text/javascript">
$(document).ready(function(){
	  $("#patientSearch").on("keyup", function() {
	    var value = $(this).val().toLowerCase();
	    $("#patientTable #patientdata").filter(function() {
	      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
	    });
	  });
	});
	
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
<div id="viewPatient">
<center><input id="patientSearch" type="text" placeholder="Search.. &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp; &nbsp;&nbsp; &nbsp; &nbsp;&#x1F50D;"></center><br><br>
<center><table id="patientTable" >
<tr >
	<th>Patient_Id</th>
	<th>First_Name</th>
	<th>Last_Name</th>
	<th>Gender</th>
	<th>Contact</th>
	<th>Diagnosis</th>
</tr>

<c:forEach items="${patientList}" var="patient">
<c:url var="showPatient" value="showPatientDetails.htm">
<c:param name="patientId" value="${patient.patientId}"></c:param>
</c:url>

<c:url var="addDiagnosis" value="showDiagnosisDetails.htm">
<c:param name="patientId" value="${patient.patientId}"></c:param>
</c:url>

<tr id="patientdata">
<td><a style="color:white; "href="${showPatient}" >${patient.patientId}</a></td>
<td><c:out value="${patient.firstName}"/></td>
<td><c:out value="${patient.lastName}"/></td>
<td><c:out value="${patient.gender}"/></td>
<td><c:out value="${patient.contactNumber}"/></td>

<td><a style="text-decoration:none; color:steelblue; " href="displayDiagnosis.htm?patientId=${patient.patientId}" >DIAGNOSIS</a></td>
</tr>

</c:forEach>
</table></center>
</div>
<button onclick="topFunction()" id="myBtn" title="Go to top"><i class="icon-arrow-up"></button>
</div>
</body>
</html>