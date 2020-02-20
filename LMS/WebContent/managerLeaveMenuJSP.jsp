<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Menu</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/webResources/styles/managerLeaveMenuCSS.css">

</head>
<body>

	<core:if test="${sessionScope.username eq null} ">
		response.sendRedirect("index.jsp");
	</core:if>
	
	<h2>
		Hi		
		<core:out value="${sessionScope.username}" />
	</h2>
	
	<ul class="nav">
		<li><a href="/LMS/Logout" value="logout">Logout</a></li>
	</ul>

	<form action="ManagerMenu">
		<input class="btn" type="submit" name="manageExecutiveLeave"
			value="Manage Executive Leave Application"> 
		<input class="btn" type="submit" name="creditDebitLeave"
			value="Credit/Debit Leaves">
	</form>
	
</body>
</html>