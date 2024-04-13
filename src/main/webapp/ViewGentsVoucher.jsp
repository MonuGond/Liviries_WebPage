
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
	font-family: arial, sans-serif;
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
		String serialno = request.getParameter("serialno");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "select * from gentsuniform where serialno='" +serialno+"'";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery(query);
	%>
<%
		while (rs.next()) {
	%>

	<div style="display: flex; justify-content: center;">
		<img src="Screenshot (2).png" style="width: 150px; height: 100px;" />
	</div>
	<h5>O/O THE RED(ER)#UNIFORM MATERIALS FOR MALE OFFICIAL(FOR 3
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
			<td style="font-weight: bolder;">Date :</td>
			<td style="font-weight: bolder;"><%=rs.getDate(7)%></td>
			<td style="color: red; font-family: sans-serif; font-weight: bold;">Serial
				No.</td>
			<td style="color: red; font-family: sans-serif; font-weight: bold;"><%=rs.getString(8)%>
			</td>
		</tr>

	</table>

	<table border="1">
		<tr>
			<th>Sl.No.</th>
			<th>Types Of Cloth</th>
			<th>Cloth Meters</th>
			<th>Cloth Pcs</th>
			<th>Total(Mtrs)</th>

		</tr>

		<!--  -->

		<tr>
			<th>1.</th>
			<th>Shirting Cloth</th>
			<td><%=rs.getDouble(9)%></td>
			<td><%=rs.getInt(10)%></td>
			<td><%=rs.getDouble(11)%></td>


		</tr>

		<tr>
			<th>2.</th>
			<th>Pant Cloth</th>
			<td><%=rs.getDouble(12)%></td>
			<td><%=rs.getInt(13)%></td>
			<td><%=rs.getDouble(14)%></td>

		</tr>

		<tr>
			<th>3.</th>
			<th>Suit Cloth</th>
			<td><%=rs.getDouble(15)%></td>
			<td><%=rs.getInt(16)%></td>
			<td><%=rs.getDouble(17)%></td>

		</tr>

		<tr>
			<th>4.</th>
			<th>PullOver(Jersey)</th>
			<td></td>
			<td><%=rs.getInt(18)%></td>
			<td><%=rs.getDouble(19)%></td>

		</tr>
		<tr>
			<th>5.</th>
			<th>Half Sleeve Gents Cardigan</th>
			<td></td>
			<td><%=rs.getInt(20)%></td>
			<td><%=rs.getDouble(21)%></td>

		</tr>

		<tr>
			<th>6.</th>
			<th>Nos. of Neck Ties</th>
			<td></td>
			<td><%=rs.getInt(22)%></td>
			<td><%=rs.getDouble(23)%></td>

		</tr>
		<tr>
			<th>7.</th>
			<th>Ladies Scarves(opt.male uniform)</th>
			<td></td>
			<td><%=rs.getInt(24)%></td>
			<td><%=rs.getDouble(25)%></td>

		</tr>
		<tr>
			<th>8.</th>
			<th>Fire PullOver</th>
			<td></td>
			<td><%=rs.getInt(26)%></td>
			<td><%=rs.getDouble(27)%></td>

		</tr>
	</table>
	<br>
	<h5><a href="ViewAllGentsVoucherList.jsp">Back To Page</a></h5>
	<br>
	<br>
	<br>

	<%
		}
	%>

</body>
</html>