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
font-family: Arial;
font-size: 15px;
font-weight: bold;
text-align: center;
}
</style>
</head>
<body>
	<%
		String serialno =request.getParameter("serialno");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "select * from ladiesUniform where serialno='" +serialno+"'";
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
	<form action="UpdateLadiesUniformServlet" method="post">

		<table>
			<tr>
				<td>Book.No.</td>
				<td><input type="text" size="15" name="bookno" value=<%=rs.getInt(1) %>
					required="required"></td>
				<td>Page No.</td>
				<td><input type="text" size="15" name="pgno" value=<%=rs.getInt(2) %>
					required="required"></td>
				<td>C/Size</td>
				<td><input type="text" size="15" name="g_u_size" value=<%=rs.getInt(3) %>
					required="required"></td>
			</tr>
			<tr>
				<td>EMP.No.</td>
				<td><input type="text" size="15" name="empno" value=<%=rs.getInt(4) %>
					required="required"></td>
				<td>NAME</td>
				<td><input type="text" size="35" name="ename" value=<%=rs.getString(5).replace(" ", "_") %>
					required="required"></td>
				<td>DESIGNATION</td>
				<td><input type="text" size="15" name="designation" value=<%=rs.getString(6).replace(" ", "_") %>
					required="required"></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><input type="date" name="gdate" value=<%=rs.getDate(7) %> readonly="readonly"></td>
				<td>Serial No.</td>
				<td><input type="text" name="serialno" value=<%=rs.getString(8) %> readonly="readonly"> </td>
			</tr>

		</table>

		<table border="1">
			<tr>
				<th>Sl.No.</th>
				<th>Sarees With Blouse</th>
				<th>Cloth Pcs</th>
				

			</tr>

			<!--  -->

			<tr>
				<th>1.</th>
				<th>Silk Sarees</th>
				<td><input type="text" size="10" name="s_saree_pcs" value=<%=rs.getInt(9) %> ></td>
				<td></td>


			</tr>

			<tr>
				<th>2.</th>
				<th>Crape Sarees</th>
				<td><input type="text" size="10" name="c_saree_pcs" value=<%=rs.getInt(11) %> ></td>
				<td></td>

			</tr>

			<tr>
				<th>3.</th>
				<th>Synthetic Sarees</th>
				<td><input type="text" size="10" name="syn_saree_pcs" value=<%=rs.getInt(13) %> ></td>
				<td></td>
			</tr>


			<tr>
				<th>4.</th>
				<th>PullOver(Jersey)</th>
				<td><input type="text" size="10" name="pullover" value=<%=rs.getInt(15) %> ></td>
				<td></td>

			</tr>
			<tr>
				<th>5.</th>
				<th>Half Sleeve Cardigan</th>
				<td><input type="text" size="10" name="h_s_cardigan" value=<%=rs.getInt(17) %> ></td>
				<td></td>

			</tr>

			<tr>
				<th>6.</th>
				<th>Ladies Cardigan</th>
				<td><input type="text" size="10" name="cardigan_pcs" value=<%=rs.getInt(19) %> ></td>
				<td></td>

			</tr>
			<tr>
				<th>7.</th>
				<th>Ladies Scarves</th>
				<td><input type="text" size="10" name="scarves_pcs" value=<%=rs.getInt(21) %> ></td>
				<td></td>

			</tr>
			<tr>
				<th>8.</th>
				<th>Fire PullOver</th>
				<td><input type="text" size="10" name="f_p_over" , value=<%=rs.getInt(23) %>></td>
				<td></td>

			</tr>


		</table>

		<h3 align="center">
			<input type="submit" value="Update Voucher">
		</h3>

<%} %>
	</form>

</body>
</html>