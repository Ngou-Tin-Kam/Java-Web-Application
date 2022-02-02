<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>

<%
String driver = "com.mysql.cj.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/gambling?autoReconnect=true&useSSL=false";
String userId = "root";
String password = "password";

try {
	Class.forName(driver);
} catch (Exception ex) {
	ex.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<h1>Data from database</h1>

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
		try {
			connection = DriverManager.getConnection(url, userId, password);
			String query = "select * from bets";
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
		%>
		<tr>
			<td><%=resultSet.getInt("id")%></td>
			<td><%=resultSet.getInt("numbets")%></td>
			<td><%=resultSet.getString("game")%></td>
			<td><%=resultSet.getDouble("stake")%></td>
			<td><%=resultSet.getDouble("returns")%></td>
			<td><%=resultSet.getInt("clientid")%></td>
			<td><%=resultSet.getString("date")%></td>
		</tr>
		<%
		}
		connection.close();
		} catch (Exception ex) {
		ex.printStackTrace();
		}
		%>

	</table>
</body>
</html>
