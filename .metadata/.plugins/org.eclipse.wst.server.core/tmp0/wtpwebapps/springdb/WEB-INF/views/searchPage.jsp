<%@page import="comm.tyss.springdb.beans.ItemBean"%>
<%@page import="java.util.List"%>
<%@page import="comm.tyss.springdb.beans.ItemBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	ItemBean infoBean = (ItemBean) request.getAttribute("data");
String msg = (String) request.getAttribute("msg");
List<ItemBean> infoBeans = (List) request.getAttribute("infobeans");
%>
<%@ include file="headerPage.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search page</title>
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
		<legend>Search</legend>
		<form action="./search" method="get">
			<table>
				<tr>
					<td>Admin ID</td>
					<td>:</td>
					<td><input type="number" name="id" placeholder="Enter the Admin ID"></td>
				</tr>
				<tr>
					<td>Item ID</td>
					<td>:</td>
					<td><input type="number" name="iid" placeholder="Enter the Item ID"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
		if (infoBean != null) {
	%>
	<h1>
		Name :
		<%=infoBean.getIname()%></h1>
	<h1>
		cost :
		<%=infoBean.getIcost()%></h1>
	<h1>
		Admin id :
		<%=infoBean.getAId()%></h1>
	<%
		}
	%>

	<%
		if (infoBeans != null) {
	%>
	<table>
		<tr>
			<th>Name</th>
			<th>Cost</th>
			<th>Admin</th>
		</tr>
		<%
			for (ItemBean bean : infoBeans) {
		%>
		<tr>
			<td><%=bean.getIname()%></td>
			<td><%=bean.getIcost()%></td>
			<td><%=bean.getAId()%></td>
		</tr>

	</table>

	<%
		}
	}
	%>











</body>
</html>