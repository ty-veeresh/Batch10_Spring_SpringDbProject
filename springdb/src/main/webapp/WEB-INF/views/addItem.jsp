<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<jsp:include page="headerPage.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Items</title>
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
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red;">
		<%=errMsg%></h1>
	<%
		}
	%>
	<fieldset>
		<legend>Add Items</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Item ID</td>
					<td>:</td>
					<td><input type="number" name="iId"
						placeholder="Enter the ID" required="required"></td>
				</tr>
				<tr>
					<td>Item Name</td>
					<td>:</td>
					<td><input type="text" name="iname"
						placeholder="Enter the Name" required="required"></td>
				</tr>
				<tr>
					<td>Item Price</td>
					<td>:</td>
					<td><input type="number" name="icost"
						placeholder="Enter the price" required="required"></td>
				</tr>
				<tr>
					<td>Admin id</td>
					<td>:</td>
					<td><input type="number" name="aId"
						placeholder="Enter the id" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>