<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pending Applications</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath() %>/webResources/styles/displayPendingLeavesCSS.css">

</head>
<body>
	
	<ul class="nav">

		<li><a href="/LMS/Logout" value="logout">Logout</a></li>
		<li><a href="/LMS/managerLeaveMenuJSP.jsp" value="home">Home</a></li>

	</ul>

	<center>
		<form action="DisplayPendingLeave" method="post">
			<h1>All Pending Applications</h1>
			</br></br>
			<table>
				<tr>
					<th>Username</th>									
					<th>Leave Type</th>
					<th>From Date</th>
					<th>To Date</th>
					<th colspan="2">Decision</th>
				</tr>

				<core:forEach var="leaveApplication"
					items="${allPendingApplication }">

					<tr>
						<td><core:out value="${leaveApplication.getUsername() }" /></td>
						<td><core:out value="${leaveApplication.getLeaveType() }" /></td>
						<td><core:out value="${leaveApplication.getFromDate() }" /></td>
						<td><core:out value="${leaveApplication.getToDate() }" /></td>
						<td><input type="submit" name="approve" value="Approve" /></td>
						<td><input type="submit" name="cancel" value="Cancel" /></td>
					</tr>
					<input type="hidden" name="leaveId" value="${leaveApplication.getLeaveId() }"/>
				</core:forEach>

			</table>
		</form>
	</center>
</body>
</html>