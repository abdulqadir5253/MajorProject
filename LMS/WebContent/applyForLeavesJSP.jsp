<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Apply For Leave</title>

<link rel="stylesheet" type="text/css"
	href="webResources/styles/applyForLeaveCSS.css">

<script
	src="webResources/javaScripts/ApplyForLeaveInputValidation.js"></script>


</head>
<body onload="">

	<core:choose>
		<core:when test="${sessionScope.username == null }">
			${sessionScope.designation }
			<%response.sendRedirect("index.jsp"); %>
		</core:when>
		<core:otherwise>
			<h2></h2>
		</core:otherwise>
	</core:choose>
	
	<ul class="navigation">
	
		<li><a href="/LMS/Logout">LOGOUT</a></li>
		<li><a href="/LMS/ApplyForLeave" name="home">HOME</a></li>
		
	</ul>
	
	</br></br>
	<center>
		<h1>Apply For Leaves</h1>
	</center>

	<form action="ApplyForLeave" method="post" class="form"
		name="applyForleave" onsubmit="return validateInput()">
		<table align="center">
			<tr>
				<td>Type Of Leave</td>
				<td><select name="typeOfLeave">
						<option value="casual">Casual Leave</option>
						<option value="duty">Duty Leave</option>
						<option value="parental">Parental Leave</option>
						<option value="earned">Earned Leave</option>
						<option value="leaveWithoutPay">Leave Without Pay</option>
						<option value="maternity">Maternity Leave</option>
						<option value="sick">Sick Leave</option>
				</select></td>
			</tr>

			<tr class="chooseDate">
				<td>Select From Date</td>
				<td><input type="Date" name="fromDate"></td>
			</tr>

			<tr class="chooseDate">
				<td>Select To Date</td>
				<td><input type="Date" name="toDate"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="SUBMIT"></td>
			</tr>
		</table>
	</form>
</body>
</html>