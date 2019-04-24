<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
    <th>Report_Id:</th>
    <td><c:out value="${updateDiagnosis.reportId}"/></td>
</tr>

<tr>
    <th>Patient_Id:</th>
    <td><c:out value="${updateDiagnosis.patientId}"/></td>
</tr>

<tr>
    <th>Physician_Id</th>
    <td><c:out value="${updateDiagnosis.physicianId}"/></td>
</tr>

<tr>
    <th>Blood_WBC_AR:</th>
    <td><c:out value="${updateDiagnosis.wbcActualRange}"/></td>
</tr>

<tr>
    <th>Blood_RBC_AR:</th>
    <td><c:out value="${updateDiagnosis.rbcActualRange}"/></td>
</tr>

<tr>
    <th>Blood_HGB_AR:</th>
    <td><c:out value="${updateDiagnosis.hgbActualRange}"/></td>
</tr>

<tr>
    <th>Blood_HCT_AR:</th>
    <td><c:out value="${updateDiagnosis.hctActualRange}"/></td>
</tr>

<tr>
    <th>Blood_MCV_AR:</th>
    <td><c:out value="${updateDiagnosis.mvcActualRange}"/></td>
</tr>

<tr>
    <th>Blood_MCH_AR:</th>
    <td><c:out value="${updateDiagnosis.mchActualRange}"/></td>
</tr>

<tr>
    <th>Physician_Comments:</th>
    <td><c:out value="${updateDiagnosis.physicianComments}"/></td>
</tr>

</table>
<table style=" width:30%; margin-left:30%; margin-top:5%;">
<tr>
    <th>Service_date:</th>
    <td><c:out value="${updateDiagnosis.serviceDate}"/></td>
</tr>
<tr>
    <th>Test_Result_Date:</th>
    <td><c:out value="${updateDiagnosis.testResultDate}"/></td>
</tr>

<tr>
    <th>Blood_WBC_NR:</th>
    <td><c:out value="${updateDiagnosis.wbcNormalrange}"/></td>
</tr>


<tr>
    <th>Blood_RBC_NR:</th>
    <td><c:out value="${updateDiagnosis.rbcNormalrange}"/></td>
</tr>


<tr>
    <th>Blood_HGB_NR:</th>
    <td><c:out value="${updateDiagnosis.hgbNormalrange}"/></td>
</tr>


<tr>
    <th>Blood_HCT_NR:</th>
    <td><c:out value="${updateDiagnosis.hctNormalrange}"/></td>
</tr>

<tr>
    <th>Blood_MVC_NR:</th>
    <td><c:out value="${updateDiagnosis.mvcNormalrange}"/></td>
</tr>

<tr>
    <th>Blood_MCH_NR:</th>
    <td><c:out value="${updateDiagnosis.mchNormalrange}"/></td>
</tr>



<tr>
    <th>Other_Info:</th>
    <td><c:out value="${updateDiagnosis.otherInfo}"/></td>
</tr>

</table>


<form action="editDiagnosis.htm" >
<input type=submit value="Edit">
</form><br>
</div>
</body>
</html>