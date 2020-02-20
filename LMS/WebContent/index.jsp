<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LMS LOGIN</title>

<script src="http://code.jquery.com/jquery-latest.min.js"></script>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/webResources/styles/loginForm.css">

<script
	src="<%=request.getContextPath()%>/webResources/javaScripts/loginInputValidation.js"></script>
</head>

<body>

	<center>
		<a href="http://www.intimetec.com"> <img src="img/intimetec.png">
		</a>
	</center>
	</br>

	</br>

	<div class="login-box">
		<h2>LMS SYSTEM LOGIN</h2>

		<div class="textbox">
			<i class="fa fa-user" aria-hidden="true"></i> <input type="text"
				name="username" placeholder="Username" id="username"
				onkeyup="validate()">
		</div>

		<div class="textbox">
			<i class="fa fa-lock" aria-hidden="true"></i> <input type="password"
				placeholder="Password" id="password" onkeyup="validate()"
				name="password">
		</div>

		<center>
			<strong>
				</br>
					<div id="somediv"></div>
				</br>
			</strong>
		</center>

		<input class="btn" type="submit" value="Sign in" id="submitBtn" disabled="disabled">

	</div>

</body>
</html>