<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add User</title>
</head>
<body>
<%@include file="../partials/header.html" %>
	<form action="add" method="post">
		<span>First Name</span><input type="text" name="first_name" maxlength="10" required /><br>
		<span>Last Name</span><input type="text" name="last_name" maxlength="10" required /><br>
		<span>Contact Number</span><input type="number" pattern="[0-9] {10}" name="contact_number" required /><br>
	    <span>Email Id</span><input type="email" name="email" required /><br> 
	    <input type="submit" value="submit">
	</form>
</body>
</html>