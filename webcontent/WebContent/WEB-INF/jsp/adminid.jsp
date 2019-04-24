<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="springcore"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="springform" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
#adminid
{
 width:50%;
 height:350px;
 margin-top:10%;

}

h2
{
 background-color:orange;
 color:white;
 padding:15px 25px;
}

input
{
 padding:10px 30px;
 color:white;
 background-color:steelblue;
 border:none;
 box-shadow: 5px 10px black;
 cursor:pointer
}
</style>
</head>
<body> 
<center><div id="adminid">
<h2>Congratulation! You have registered Successfully</h2>

<h3>Your Admin ID is</h3><h3>${adminId}</h3>

<form action="login.htm">
<input type=submit value="LOGIN">
</form><br><br>
<img src="data:image/png;base64,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"/>
</div></center>

</body>
</html>