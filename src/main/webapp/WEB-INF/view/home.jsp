<%@page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.*"%>
<%@page import="model.Bet" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="ISO-8859-1">
<title>Java Web Application</title>
</head>
<body>

	<h1>Bets Data</h1>

	<form id="form" action="<%=request.getContextPath()%>/HomeServlet"
		method="post">
		<input type="search" id="query" name="query"
			placeholder="Filter Keyword"> <label for="filter">Filter
			By:</label> <select name="filter" id="filter">
			<option value="game">Game</option>
			<option value="clientid">Client Id</option>
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
		ArrayList<Bet> listOfBets = (ArrayList<Bet>) request.getAttribute("betList");
		for (Bet bet : listOfBets) {
		%>
		<tr>
			<td><%=bet.getId()%></td>
			<td><%=bet.getNumbets()%></td>
			<td><%=bet.getGame()%></td>
			<td><%=bet.getStake()%></td>
			<td><%=bet.getReturns()%></td>
			<td><%=bet.getClientId()%></td>
			<td><%=bet.getDate()%></td>
		</tr>
		<%
		}
		%>
	</table>
</body>
</html>
