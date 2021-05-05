<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	String msg = (String) request.getAttribute("msg");
%>
<%@ include file="headerPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1>
		<%=msg%></h1>
	<%
		}
	%>
	<fieldset>
		<legend>Delete</legend>
		<form action="./deleteEmp">
			<label>Item ID : </label> <input type="number" name="iId"
				required="required" placeholder="Enter Item ID"> <br>
			<hr>
			<input type="submit" value="Delete">
		</form>
	</fieldset>
</body>
</html>