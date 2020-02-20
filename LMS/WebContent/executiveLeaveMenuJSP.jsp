<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/webResources/styles/executiveLeaveMenuCSS.css">
</head>
<body>
	<h1>Welcome ${sessionScope.username }</h1>

	<div class="nav">

		<a href="/LMS/Logout" value="logout">Logout</a>

	</div>

	</br>
	</br>
	<form action="ExecutiveLeaveMenu" method="get">
		<input class="btn" type="submit" name="applyForLeave"
			value="Apply For Leave"> 
		<input class="btn" type="submit"
			name="checkLeaveStatus" value="Check For Leave Status">
	</form>

</body>
</html>