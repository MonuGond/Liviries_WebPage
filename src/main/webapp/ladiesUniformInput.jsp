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
font-size:15px;
}
</style>
</head>
<body>

<%
		int serialno = 0;
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String querypdf = "select ladiesUniform_sequence.nextVal from dual";
		PreparedStatement ps = conn.prepareStatement(querypdf);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			serialno = rs.getInt(1);

		}
	%>
	<div style="display: flex; justify-content: center;">
		<img src="Screenshot (2).png" style="width: 150px; height: 100px;" />
	</div>
	<h5>O/O THE RED(ER)#UNIFORM MATERIALS FOR FEMALE OFFICIAL(FOR 3
		YEARS)</h5>
	<form action="LadiesUniformServlet" method="post">

		<table>
			<tr>
				<td>Book.No.</td>
				<td><input type="text" size="15" name="bookno"
					required="required"></td>
				<td>Page No.</td>
				<td><input type="text" size="15" name="pgno"
					required="required"></td>
				<td>C/Size</td>
				<td><input type="text" size="15" name="g_u_size"
					required="required"></td>
			</tr>
			<tr>
				<td>EMP.No.</td>
				<td><input type="text" size="15" name="empno"
					required="required"></td>
				<td>NAME</td>
				<td><input type="text" size="35" name="ename"
					required="required"></td>
				<td>DESIGNATION</td>
				<td><input type="text" size="15" name="designation"
					required="required"></td>
			</tr>
			<tr>
				<td>Date :</td>
				<td><input type="date" name="gdate" required="required"></td>
				<td>Serial No.</td>
				<td><input type="text" name="serialno" value=<%="L" + serialno%> readonly="readonly"> </td>
			</tr>

		</table>

		<table border="1">
			<tr>
				<th>Sl.No.</th>
				<th>Sarees With Blouse</th>
				<th>Cloth Pcs</th>
				
				<th>Remarks</th>

			</tr>

			<!--  -->

			<tr>
				<th>1.</th>
				<th>Silk Sarees</th>
				<td><input type="text" size="10" name="s_saree_pcs"></td>
				<td></td>


			</tr>

			<tr>
				<th>2.</th>
				<th>Crape Sarees</th>
				<td><input type="text" size="10" name="c_saree_pcs"></td>
				<td></td>

			</tr>

			<tr>
				<th>3.</th>
				<th>Synthetic Sarees</th>
				<td><input type="text" size="10" name="syn_saree_pcs"></td>
				<td></td>
			</tr>


			<tr>
				<th>4.</th>
				<th>PullOver(Jersey)</th>
				<td><input type="text" size="10" name="pullover"></td>
				<td></td>

			</tr>
			<tr>
				<th>5.</th>
				<th>Half Sleeve Cardigan</th>
				<td><input type="text" size="10" name="h_s_cardigan"></td>
				<td></td>

			</tr>

			<tr>
				<th>6.</th>
				<th>Ladies Cardigan</th>
				<td><input type="text" size="10" name="cardigan_pcs"></td>
				<td></td>

			</tr>
			<tr>
				<th>7.</th>
				<th>Ladies Scarves</th>
				<td><input type="text" size="10" name="scarves_pcs"></td>
				<td></td>

			</tr>
			<tr>
				<th>8.</th>
				<th>Fire PullOver</th>
				<td><input type="text" size="10" name="f_p_over"></td>
				<td></td>

			</tr>


		</table>

		<h3 align="center">
			<input type="submit" value="Generate Voucher">
		</h3>


	</form>

</body>
</html>