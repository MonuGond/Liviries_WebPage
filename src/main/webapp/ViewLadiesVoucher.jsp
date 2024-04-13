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
		String serialno=request.getParameter("serialno");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "select * from ladiesUniform where serialno='" +serialno+"'";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
	%>

	<%
		while (rs.next()) {
	%>

	<div style="display: flex; justify-content: center;">
		<img src="Screenshot (2).png" style="width: 150px; height: 100px;" />
	</div>
	<h5>O/O THE RED(ER)#UNIFORM MATERIALS FOR FEMALE OFFICIAL(FOR 3
		YEARS)</h5>

	<table>
		<tr>
			<td style="font-weight: bold;">Book.No.</td>
			<td style="font-weight: bold;"><%=rs.getInt(1)%></td>
			<td style="font-weight: bold;">Page No.</td>
			<td style="font-weight: bold;"><%=rs.getInt(2)%></td>
			<td style="font-weight: bold;">C/Size</td>
			<td style="font-weight: bold;"><%=rs.getInt(3)%></td>
		</tr>
		<tr>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;">EMP.No.</td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;"><%=rs.getInt(4)%></td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;">NAME</td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;"><%=rs.getString(5)%></td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;">DESIGNATION</td>
			<td style="color: blue; font-family: sans-serif; font-weight: bold;"><%=rs.getString(6)%></td>
		</tr>
		<tr>
			<td style="font-weight: bold;">Date :</td>
			<td style="font-weight: bold;"><%=rs.getDate(7)%></td>
			<td style="font-weight: bold; color: red;">Serial No.</td>
			<td style="font-weight: bold; color: red;"><%=rs.getString(8)%></td>
		</tr>

	</table>

	<table border="1">
		<tr>
			<th>Sl.No.</th>
			<th>Sarees With Blouse</th>
			<th>Cloth Pcs</th>
			<th></th>
		</tr>

		<tr>
			<th>1.</th>
			<th>Silk Sarees</th>
			<td><%=rs.getInt(9)%></td>
			<td></td>
		</tr>
		<tr>
			<th>2.</th>
			<th>Crape Sarees</th>
			<td><%=rs.getInt(11)%></td>
			<td></td>
		</tr>
		<tr>
			<th>3.</th>
			<th>Synthetic Sarees</th>
			<td><%=rs.getInt(13)%></td>
			<td></td>
		</tr>
		<tr>
			<th>4.</th>
			<th>PullOver(Jersey)</th>
			<td><%=rs.getInt(15)%></td>
			<td></td>
		</tr>
		<tr>
			<th>5.</th>
			<th>Half Sleeve Cardigan</th>

			<td><%=rs.getInt(17)%></td>
			<td></td>
		</tr>
		<tr>
			<th>6.</th>
			<th>Ladies Cardigan</th>
			<td><%=rs.getInt(19)%></td>
			<td></td>
		</tr>
		<tr>
			<th>7.</th>
			<th>Ladies Scarves(opt.male uniform)</th>
			<td><%=rs.getInt(21)%></td>
			<td></td>
		</tr>
		<tr>
			<th>8.</th>
			<th>Fire PullOver</th>
			<td><%=rs.getInt(23)%></td>
			<td></td>
		</tr>

	</table>
	<h5 align="center"><a href="ViewAllLadiesVoucherList.jsp">Back To Page</a></h5>
	<br>
	<br>
	<br>
	<br>
	<%
		}
	%>
</body>
</html>