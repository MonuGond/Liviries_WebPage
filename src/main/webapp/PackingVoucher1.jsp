
<%@page import="java.util.ArrayList"%>
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
	width: 85%;
	margin-left: auto;
	margin-right: auto;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 5px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
<%
	int issuevoucherno=0;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
	String querypdf="select packingvoucher1_sequence.nextVal from dual";
	PreparedStatement ps=conn.prepareStatement(querypdf);
	ResultSet rs=ps.executeQuery();
	while(rs.next()){
		issuevoucherno=rs.getInt(1);
	}
	%>
	<form action="PackingVoucher1Servlet" method="post">
		<div style="display: flex; justify-content: center;">
			<img src="Airports_Authority_of_India.png"
				style="width: 120px; height: 100px;" />
		</div>

		<h5>RECEIPT AND ISSUE VOUCHER</h5>
		<h1>
			<u>PACKING SLIP</u>
		</h1>

		<table>

			<tr>
				<td>Name and Address of Consignee:</td>
				<td><input type="text" size="80" name="n_a_consignee"
					required="required"><br></td>

			</tr>
			<tr>
				<td>Our Reference :</td>
				<td><input type="text" size="80" name="ourreference"
					required="required"></td>
			</tr>

			<tr>
				<td>Issue Voucher No:</td>
				<td><input type="text" size="20" name="issuevoucherno" value=<%="P"+issuevoucherno %>
					readonly="readonly"></td>
			</tr>

			<tr>
				<td>Date :</td>
				<td><input type="date" name="pdate" required="required"></td>
			</tr>


		</table>

		<table border="1">

			<tr>
				<th>Sl.No.</th>
				<th>Types Of Cloth</th>
				<th>Cloth Meters</th>
				<th>Cloth Pcs</th>
				<th></th>
				<th>Remarks</th>
			</tr>

			<!--  -->

			<tr>
				<th>1.</th>
				<th>Shirting Cloth</th>
				<td><input type="text" name="shirting1_cloth_mtrs"> <input
					type="text" name="shirting2_cloth_mtrs"></td>
				<td><input type="text" name="shirting1_cloth_pcs"> <input
					type="text" name="shirting2_cloth_pcs"></td>
				<td></td>
				<td><input type="text" name="shirting_cloth_remarks"></td>

			</tr>

			<tr>
				<th>2.</th>
				<th>Pant Cloth</th>
				<td><input type="text" name="paint1_cloth_mtrs"> <input
					type="text" name="paint2_cloth_mtrs"></td>
				<td><input type="text" name="paint1_cloth_pcs"> <input
					type="text" name="paint2_cloth_pcs"></td>
				<td></td>
				<td><input type="text" name="paint_cloth_remarks"></td>
			</tr>

			<tr>
				<th>3.</th>
				<th>Suit Cloth</th>
				<td><input type="text" name="suit1_cloth_mtrs"> <input
					type="text" name="suit2_cloth_mtrs"></td>
				<td><input type="text" name="suit1_cloth_pcs"> <input
					type="text" name="suit2_cloth_pcs"></td>
				<td></td>
				<td><input type="text" name="suit_cloth_remarks"></td>

			</tr>

			<tr>
				<th>4.</th>
				<th>Blazer Cloth</th>

				<td><input type="text" name="blaizer1_cloth_mtrs"> <input
					type="text" name="blaizer2_cloth_mtrs"></td>
				<td><input type="text" name="blaizer1_cloth_pcs"> <input
					type="text" name="blaizer2_cloth_pcs"></td>
				<td></td>
				<td><input type="text" name="blaizer_cloth_remarks"></td>

			</tr>


			<!-- Upper wala sbhi ku6 shirt and pant cloth ke liye hai -->
			<tr>
				<th></th>
				<th>Sarees With Blouse</th>
				<th>Pcs</th>
			</tr>
			<tr>
				<th>5.</th>
				<th>Silk Sarees</th>
				<td><input type="text" name="silk_saree_pcs"></td>
				<td></td>
				<td></td>
				<td><input type="text" name="silk_saree_remark"></td>
			</tr>
			<tr>
				<th>6.</th>
				<th>Crape Sarees</th>
				<td><input type="text" name="crape_saree_pcs"></td>
				<td></td>
				<td></td>
				<td><input type="text" name="crape_saree_remark"></td>
			</tr>
			<tr>
				<th>7.</th>
				<th>Synthetic Sarees</th>
				<td><input type="text" name="synthetic_saree_pcs"></td>
				<td></td>
				<td></td>
				<td><input type="text" name="synthetic_saree_remark"></td>
			</tr>
			<tr>
				<th>8.</th>
				<th>Nos. of Neck Ties.</th>
				<td><input type="text" name="neck_tie_pcs"></td>
				<td></td>
				<td></td>
				<td><input type="text" name="neck_tie_remark"></td>
			</tr>
			<tr>
				<th>9.</th>
				<th>Ladies Scarves(opt.male uniform)</th>
				<td><input type="text" name="scarves_pcs"></td>
				<td></td>
				<td></td>
				<td><input type="text" name="scarves_remark"></td>
			</tr>
		</table>
		<h3 align="center">
			<input type="submit" value="Go to next Page">
			<!-- yha se servlet me jata -->
		</h3>
		<a href="PackingVoucher2.jsp">Jsp page </a>

	</form>
</body>
</html>