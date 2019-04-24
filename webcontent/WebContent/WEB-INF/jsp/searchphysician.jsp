<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
	<th>Physicain_Id</th>
	<th>First_Name</th>
	<th>Last_Name</th>
	<th>Speciality</th>
	<th>Contact_Number</th>
</tr>

<c:forEach items="${physicianList}" var="physician">
<c:url var="showPhysician" value="showPhysicianDetails.htm">
<c:param name="physicianId" value="${physician.physicianId}"></c:param>
</c:url>
<tr>


<td><a href="${showPhysician}" >${physician.physicianId}</a></td>
<td><c:out value="${physician.firstName}"/></td>
<td><c:out value="${physician.lastName}"/></td>
<td><c:out value="${physician.speciality}"/></td>
<td><c:out value="${physician.contactNumber}"/></td>

</tr>

</c:forEach>
</table>
</body>
</html>