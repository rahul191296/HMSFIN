<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PATIENT DETAILS</title>
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
 background-color:steelblue;
border:none;
}
th ,td
{
 padding:10px;
 color:white;
 font-family:bold;
}

input
{
 padding:10px 30px;
 color:white;
 background-color:steelblue;
 border:none;
 box-shadow: 5px 10px black;
 cursor:pointer;
 
}

input:hover
{
 padding:10px 40px;
}

form
{
 padding:15px 35px;
 float:right;
 margin-right:10%;

}
.overlay
{
 background-color:rgba(0,0,0,0.7);
 width:100%;
 height:680px;

 
}
</style>
</head>
<body>
<div class="overlay">
<ul>
  <li><a class="active" href="home.htm" style ="color:white;"><strong>Medicenter</strong></a></li>
  
  <li style="float:right; "><a style="color:white;"href="logoutUser.htm">Logout</a></li>
  <li style="float:right; color:white;"><a>Welcome!:${adminId} </a></li>
 
</ul>
<table style="float:left; width:30%; margin-left:30%; margin-top:5%">

<tr>
    <th>Patient_Id:</th>
    <td><c:out value="${updatePatient.patientId}"/></td>
</tr>

<tr>
    <th>First_Name:</th>
    <td><c:out value="${updatePatient.firstName}"/></td>
</tr>

<tr>
    <th>Last_Name:</th>
    <td><c:out value="${updatePatient.lastName}"/></td>
</tr>



<tr>
    <th>Age:</th>
    <td><c:out value="${updatePatient.age}"/></td>
</tr>

<tr>
    <th>Gender:</th>
    <td><c:out value="${updatePatient.gender}"/></td>
</tr>

<tr>
    <th>Date of Birth:</th>
    <td><c:out value="${updatePatient.doB}"/></td>
</tr>

<tr>
    <th>Contact_Number:</th>
    <td><c:out value="${updatePatient.contactNumber}"/></td>
</tr>
</table>
<table style=" width:30%; margin-left:30%; margin-top:5%;">
<tr>
    <th>Alternate Contact Number:</th>
    <td><c:out value="${updatePatient.altContactNumber}"/></td>
</tr>

<tr>
    <th>Email-Id:</th>
    <td><c:out value="${updatePatient.emailId}"/></td>
</tr>

<tr>
    <th>Address Line1:</th>
    <td><c:out value="${updatePatient.addressLine1}"/></td>
</tr>
<tr>
    <th>Address Line2:</th>
    <td><c:out value="${updatePatient.addressLine2}"/></td>
</tr>

<tr>
    <th>City</th>
    <td><c:out value="${updatePatient.city}"/></td>
</tr>
<tr>
    <th>State</th>
    <td><c:out value="${updatePatient.state}"/></td>
</tr>

<tr>
    <th>Zipcode:</th>
    <td><c:out value="${updatePatient.zipCode}"/></td>
</tr>
</table>
<form action="editPatient.htm" method="get">
<input type="submit" value="EDIT">
</form>


</div>
</body>
</html>