<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Menu</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/webResources/styles/leadLeaveMenuCSS.css">

</head>
<body>
	<h2>
		Hi
		<core:out value="${sessionScope.username}" />
	</h2>

	<a href="applyForLeavesJSP.jsp">Apply For Leave</a>
	<a href="checkLeaveStatusJSP.jsp">Check Leave Status</a>
	<a href="/LMS/Logout">Logout</a>
	</br></br></br></br></br></br>
	<form action="ManagerMenu">
		<input class="btn" type="submit" name="manageExecutiveLeave" 
			value="Pending Leaves">
	</form>

</body>
</html>