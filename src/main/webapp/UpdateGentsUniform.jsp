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
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
input{
font-weight: bold;
text-align: center;
font-family: Arial;
font-size: 15px;
}
</style>
</head>
<body>

<%
String serialno=request.getParameter("serialno");
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
String query = "select * from gentsuniform where serialno='"+serialno+"'";
PreparedStatement ps=conn.prepareStatement(query);
ResultSet rs=ps.executeQuery();
%>
<div style="display: flex; justify-content: center;">
		<img src="Screenshot (2).png" style="width: 150px; height: 100px;" />
	</div>
	<h5>O/O THE RED(ER)#UNIFORM MATERIALS FOR MALE OFFICIAL(FOR 3
		YEARS)</h5>
		<% while(rs.next()){ %>
	<form action="UpdateGentsUniformServlet" method="post">

		<table>
			<tr>
				<td style="font-weight: bold;">Book.No.</td>
				<td style="font-weight: bold; font-size: 15px;"><input type="text" size="10" name="bookno" value=<%=rs.getInt(1) %>
					readonly="readonly"></td>
				<td style="font-weight: bold;">PageNo.</td>
				<td style="font-weight: bold;"><input type="text" size="10" name="pgno" value=<%=rs.getInt(2) %>
					required="required"></td>
				<td style="font-weight: bold;">C/Size</td>
				<td style="font-weight: bold;"><input type="text" size="10" name="g_u_size" value=<%=rs.getInt(3) %>
					required="required"></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">EMP.No.</td>
				<td style="font-weight: bold;"><input type="text" size="15" name="empno" value=<%=rs.getInt(4) %>
					required="required"></td>
				<td style="font-weight: bold;">NAME</td>
				<td style="font-weight: bold;"><input type="text" size="30" name="ename" value=<%=rs.getString(5).replace(" ", "_") %>
					required="required"></td>
				<td style="font-weight: bold;">DESIGNATION</td>
				<td style="font-weight: bold;"><input type="text" size="25" name="designation" value=<%=rs.getString(6).replace(" ", "_") %>
					required="required"></td>
			</tr>
			<tr>
				<td style="font-weight: bold;">Date :</td>
				<td style="font-weight: bold;"><input type="date" name="gdate" value=<%=rs.getDate(7)%> readonly="readonly"></td>
				<td style="font-weight: bold;">Serial No.</td>
				<td style="font-weight: bold;"><input type="text" name="serialno" value=<%=rs.getString(8)%> readonly="readonly"> </td>
			</tr>

		</table>

		<table border="1">
			<tr>
				<th>Sl.No.</th>
				<th>Types Of Cloth</th>
				<th>Cloth Meters</th>
				<th>Cloth Pcs</th>
				<th></th>

			</tr>

			<!--  -->

			<tr>
				<th>1.</th>
				<th>Shirting Cloth</th>
				<td><input type="text" size="10" name="shirting_cloth_mtrs" value=<%=rs.getDouble(9) %>></td>
				<td><input type="text" size="10" name="shirting_cloth_pcs" value=<%=rs.getInt(10) %>></td>
				<td></td>


			</tr>

			<tr>
				<th>2.</th>
				<th>Pant Cloth</th>
				<td><input type="text" size="10" name="paint_cloth_mtrs" value=<%=rs.getDouble(12) %>></td>
				<td><input type="text" size="10" name="paint_cloth_pcs" value=<%=rs.getInt(13) %>></td>
				<td></td>

			</tr>

			<tr>
				<th>3.</th>
				<th>Suit Cloth</th>
				<td><input type="text" size="10" name="suit_cloth_mtrs" value=<%=rs.getDouble(15) %>></td>
				<td><input type="text" size="10" name="suit_cloth_pcs" value=<%=rs.getInt(16) %>></td>
				<td></td>


			</tr>





			<tr>
				<th>4.</th>
				<th>PullOver(Jersey)</th>
				<td></td>
				<td><input type="text" size="10" name="pullover" value=<%=rs.getInt(18) %>></td>
				<td></td>

			</tr>
			<tr>
				<th>5.</th>
				<th>Half Sleeve Gents Cardigan</th>
				<td></td>
				<td><input type="text" size="10" name="h_s_cardigan" value=<%=rs.getInt(20) %> ></td>
				<td></td>

			</tr>

			<tr>
				<th>6.</th>
				<th>Nos. of Neck Ties</th>
				<td></td>
				<td><input type="text" size="10" name="neck_tie_pcs" value=<%=rs.getInt(22) %> ></td>
				<td></td>

			</tr>
			<tr>
				<th>7.</th>
				<th>Ladies Scarves(opt. male uniform)</th>
				<td></td>
				<td><input type="text" size="10" name="scarves_pcs" value=<%=rs.getInt(24) %> ></td>
				<td></td>

			</tr>
			<tr>
				<th>8.</th>
				<th>Fire PullOver</th>
				<td></td>
				<td><input type="text" size="10" name="f_p_over" value=<%=rs.getInt(26) %> ></td>
				<td></td>

			</tr>


		</table>

		<h3 align="center">
			<input type="submit" value="Update Voucher"> <a href="UpdateGentsUniformList.jsp">Back To Page</a>
		</h3>
<%} %>

	</form>

</body>
</html>