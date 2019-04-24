<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
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
 background-color:STEELBLUE;
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
background:rgba(255,255,255, 0.6);
}

button
{
  padding:10px 30px;
 color:white;
 background-color:steelblue;
 border:none;
 box-shadow: 5px 10px black;
 cursor:pointer;
 float:right;
 margin-right:5%;
}
.overlay
{
 background-color:rgba(0,0,0,0.7);
 width:100%;
 height:680px;
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
	document.getElementById("dob").setAttribute("max",today);
	return true;
}

function tvalidate(tdob)
{
	var today= new Date();
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
	document.getElementById("tdob").setAttribute("max",today);
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
<springform:form modelAttribute="updateDiagnosis" method="get" action="updateDiagnosisDetails.htm" >
<center><table>
<tr>
<td><springform:label path="reportId">Report_Id:</springform:label>
<td><springform:input path="reportId" readonly="true"></springform:input>

</tr>

<tr>
<td><springform:label path="patientId">Patient_Id:</springform:label>
<td><springform:input path="patientId" readonly="true"></springform:input>
<td><springform:label path="physicianId">Physician_Id:</springform:label>
<td><springform:input path="physicianId" readonly="true"></springform:input>

</tr>

<tr>
<td><springform:label path="serviceDate">Service_date:</springform:label>
<td><springform:input path="serviceDate" type="date" required="required" style="width:75%;"  min ="1900-01-01"  id="dob" onclick="return validate(this);" onkeypress="return false"></springform:input>
<td><springform:label path="testResultDate" >Test_Result_Date:</springform:label>
<td><springform:input path="testResultDate"  type="date" required="required" style="width:75%;" id="tdob" onclick="return talidate(this);" onkeypress="return false"></springform:input>
</tr>
<tr>
<td><springform:label path="wbcActualRange">Blood_WBC_AR:</springform:label>
<td><springform:input path="wbcActualRange" value="4.0-15.5" readonly="true"></springform:input>
<td><springform:label path="wbcNormalrange">Blood_WBC_NR:</springform:label>
<td><springform:input type="number" path="wbcNormalrange" min ="4.0" max="15.5"  step="any"></springform:input>
</tr>

<tr>
<td><springform:label path="rbcActualRange">Blood_RBC_AR:</springform:label>
<td><springform:input path="rbcActualRange" value="4.8-9.3" readonly="true"></springform:input>
<td><springform:label path="rbcNormalrange">Blood_RBC_NR:</springform:label>
<td><springform:input type="number" path="rbcNormalrange" min ="4.8" max="9.3"  step="any" ></springform:input>
</tr>
<tr>
<td><springform:label path="hgbActualRange">Blood_HGB_AR:</springform:label>
<td><springform:input path="hgbActualRange" value="12.1-20.3" readonly="true"></springform:input>
<td><springform:label path="hgbNormalrange">Blood_HGB_NR:</springform:label>
<td><springform:input type="number" path="hgbNormalrange" min ="12.1" max="20.3"  step="any"></springform:input>
</tr>

<tr>


<td><springform:label path="hctActualRange">Blood_HCT_AR:</springform:label>
<td><springform:input path="hctActualRange" value="36.0-60.0" readonly="true"></springform:input>
<td><springform:label path="hctNormalrange">Blood_HCT_NR:</springform:label>
<td><springform:input type="number" path="hctNormalrange" min ="36" max="60"   step="any"></springform:input>

</tr>

<tr>
<td><springform:label path="mchActualRange">Blood_MCH_AR:</springform:label>
<td><springform:input path="mchActualRange" value="19.0-28.0" readonly="true"></springform:input>
<td><springform:label path="mchNormalrange">Blood_MCH_NR:</springform:label>
<td><springform:input type="number" path="mchNormalrange"  min ="19.0" max="28.0"   step="any"></springform:input>
</tr>

<tr>
<td><springform:label path="mvcActualRange">Blood_MCV_AR:</springform:label>
<td><springform:input path="mvcActualRange" value="58.0-79.0" readonly="true"></springform:input>
<td><springform:label path="mvcNormalrange">Blood_MVC_NR:</springform:label>
<td><springform:input type="number" path="mvcNormalrange"  min ="58.0" max="79.0"   step="any"></springform:input>
</tr>

<tr>
<td><springform:label path="physicianComments">Physician_Comments:</springform:label>
<td><springform:input path="physicianComments" required="required"></springform:input>
<td><springform:label path="otherInfo">Other_Info:</springform:label>
<td><springform:input path="otherInfo"></springform:input>

</tr>

<tr>
<td><button style= "float:right;" type="submit" >UPDATE</button></td><br>
</tr>
</table>
</springform:form>
</body>
</html>