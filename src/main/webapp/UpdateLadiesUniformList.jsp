<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
h1 {
	text-align: center;
	color: blue;
}

h5 {
	margin-top: 1px;
	text-align: center;
}

body {
	background-color: #C0C0C0;
}

body {
	background-color: #C0C0C0;
}

table {
	font-family: sans-serif;
	border-collapse: collapse;
	width: 75%;
	margin-left: auto;
	margin-right: auto;
}

td, th {
	border: 3px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "select * from ladiesUniform";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
	%>
	<div style="display: flex; justify-content: center;">
		<img src="Screenshot (2).png" style="width: 150px; height: 100px;" />
	</div>
	<h5>O/O THE RED(ER)#UNIFORM MATERIALS FOR FEMALE OFFICIAL(FOR 3
		YEARS)</h5>

	<%
		while (rs.next()) {
	%>

	
		
		<table>
		
		<tr>
			<td style="color: black; font-family: sans-serif; font-weight: bold;">EMP.No.</td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;"><%=rs.getInt(4)%></td>
			<td style="color: black; font-family: sans-serif; font-weight: bold;">NAME</td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;"><%=rs.getString(5)%></td>
			<td style="color: black; font-family: sans-serif; font-weight: bold;">DESIGNATION</td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;"><%=rs.getString(6)%></td>
			<td style="font-weight: bold; color: black;">V_Serial No.</td>
			<td style="font-weight: bold; color: red;"><%=rs.getString(8)%></td>
			
			<td><a href="UpdateLadiesUniform.jsp?serialno=<%=rs.getString("serialno")%>">Update Data </a></td>
		</tr>
		

	</table>
		

<%} %>

</body>
</html>