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
<style>
h1 {
	text-align: center;
	text-shadow: 10px 10px 5px grey;
}

h5 {
	margin-top: 1px;
	text-align: center;
}

h3 {
	text-align: left;
}

h4 {
	color: red;
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
	padding: 5px;
	font-family: arial;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
<%		
		String issue_vr_no=request.getParameter("issue_vr_no");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "SELECT * FROM ReceiptOtherAirport1 R1 inner join receipt_other_airport2 R2 on r1.issue_vr_no=r2.issue_vr_no";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
	%>
	
<div style="display: flex; justify-content: center;">
		<img src="Airports_Authority_of_India.png"
			style="width: 180px; height: 90px;" />
	</div>
	<h5>RECEIPT AND ISSUE VOUCHER</h5>
	
	<a href="Home.html">Home</a>
	
	<%
		while (rs.next()) {
	%>
	
	

	<table>
		
		<tr style="font-weight: bold; color: red">
			<td>I/Vr No :</td>
			<td><%=rs.getString(7)%></td>
			<td>Date :</td>
			<td><%=rs.getDate(8)%></td>
			<td><a href="ViewReceiptVoucher.jsp?issue_vr_no=<%=rs.getString("issue_vr_no")%>">View Save Data </a></td>
		</tr>

	</table>
	
	<%} %>
</body>
</html>