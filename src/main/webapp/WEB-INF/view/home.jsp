<%@page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="ISO-8859-1">
<title>Java Web Application</title>
</head>
<body>

	<h1>Data from database</h1>

	<form id="form" action="<%=request.getContextPath()%>/HomeServlet" method="post">
		<input type="search" id="query" name="q" placeholder="Filter Keyword">
		<label for="filter">Filter By:</label> <select name="filter"
			id="filter">
			<option value="game">Game</option>
			<option value="clientId">Client Id</option>
			<option value="date">Date</option>
		</select>
		<button>Filter</button>
	</form>
	<br>
	<table border="1">
		<tr>
			<td>Id</td>
			<td>Number of Bets</td>
			<td>Game</td>
			<td>Stake</td>
			<td>Returns</td>
			<td>Client Id</td>
			<td>Date</td>
		</tr>
		
		<%
		Iterator iterator;
		List listOfBets = (List) request.getAttribute("betList");
		for (iterator = listOfBets.iterator(); iterator.hasNext();) {
		%>
		<tr>
			<td><%=iterator.next()%></td>
			<td><%=iterator.next()%></td>
			<td><%=iterator.next()%></td>
			<td><%=iterator.next()%></td>
			<td><%=iterator.next()%></td>
			<td><%=iterator.next()%></td>
			<td><%=iterator.next()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
