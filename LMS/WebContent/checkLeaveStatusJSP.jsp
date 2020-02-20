<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Leave Status</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/webResources/styles/checkLeaveStatusCSS.css">

</head>
<body>
	<%
		if(session.getAttribute("username") == null)
			response.sendRedirect("index.jsp");
		else{
			String username = (String) session.getAttribute("username"); 
			out.write(username);
		}
			
	%>
	<ul class="nav">

		<li><a href="/LMS/Logout" value="logout">Logout</a></li>
		<li><a href="/LMS/executiveLeaveMenuJSP.jsp" value="home">Home</a></li>

	</ul>
	</br>
	</br>
	<center>
		<h1>All Leave Applications</h1>
	</center>
	</br>
	<table id="leaves" align="center">

		<tr>
			<th>LEAVE TYPE</th>
			<th>From Date</th>
			<th>To Date</th>
			<th>Status</th>
		</tr>


		<core:forEach var="leaveData" items="${allLeaveData }">
			<tr>
				<td><core:out value="${leaveData.getLeaveType() }" /></td>
				<td><core:out value="${leaveData.getFromDate() }" /></td>
				<td><core:out value="${leaveData.getToDate() }" /></td>
				<td><core:out value="${leaveData.getStatus() }" /></td>
			</tr>
		</core:forEach>

	</table>


</body>
</html>