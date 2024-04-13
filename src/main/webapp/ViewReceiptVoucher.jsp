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
	width: 80%;
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
<body>
	<%
		String issue_vr_no=request.getParameter("issue_vr_no");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "SELECT * FROM ReceiptOtherAirport1 R1 inner join receipt_other_airport2 R2 on  r1.issue_vr_no=r2.issue_vr_no where r1.issue_vr_no='" + issue_vr_no +"'";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
	%>

	<%
		while (rs.next()) {
	%>


	<div style="display: flex; justify-content: center;">
		<img src="Airports_Authority_of_India.png"
			style="width: 180px; height: 90px;" />
	</div>
	<h5>RECEIPT AND ISSUE VOUCHER</h5>

	<table>
		<tr>
			<td style="font-weight: bold;">
				<p align="left">To</p>
				<p align="left"><%=rs.getString(1) %> </p>
				<p align="left"><%=rs.getString(2)%></p>
				<p align="left"><%=rs.getString(3)%></p>
			</td>

			<td style="font-weight: bold;">
				<p align="left">From</p>
				<p align="left"><%=rs.getString(4) %> </p>
				<p align="left"><%=rs.getString(5) %> </p>
				<p align="left"><%=rs.getString(6) %> </p>
			</td>
		</tr>

	</table>




	<!-- yha se shirting cloth ke liye table hai -->
	<table border="1">
		<tr style="font-weight: bold; color: red">
			<td>I/Vr No :</td>
			<td><%=rs.getString(7)%></td>
			<td>Date :</td>
			<td><%=rs.getDate(8)%></td>
			<td></td>
			<td>For 3 Year</td>
		</tr>
		<tr>
			<th>Sl.No.</th>
			<th>Types Of Cloth</th>
			<th>Cloth Meters</th>
			<th>Cloth Pcs</th>
			<th>Total(Mtrs)</th>
			<th>Remarks</th>
		</tr>

		<!--  -->

		<tr>
				<th>1.</th>
				<th>Shirting Cloth</th>
				<td><input type="text" size="15" name="shirting1_cloth_mtrs" value=<%=rs.getDouble(9)%> readonly>
					<input type="text" size="15" name="shirting2_cloth_mtrs" value=<%=rs.getDouble(11) %> readonly="readonly">
				</td>
				<td><input type="text" size="15" name="shirting1_cloth_pcs" value=<%=rs.getInt(10)%> readonly>
					<input type="text" size="15" name="shirting2_cloth_pcs" value=<%=rs.getInt(12) %> readonly="readonly">
				</td>
					
				<td><%=rs.getDouble(13)%></td>
				<td><input type="text" name="shirting_cloth_remarks"
					value=<%=rs.getDouble(14)%> readonly></td>

			</tr>

			<tr>
				<th>2.</th>
				<th>Pant Cloth</th>
				<td><input type="text" size="15" name="paint1_cloth_mtrs"	value=<%=rs.getDouble(15)%> readonly>
					<input type="text" size="15" name="paint2_cloth_mtrs" value=<%=rs.getDouble(17) %> readonly="readonly">
				</td>
				<td><input type="text" size="15" name="paint1_cloth_pcs" value=<%=rs.getInt(16)%> readonly>
					<input type="text" size="15" name="paint2_cloth_pcs" value=<%=rs.getInt(18) %> readonly="readonly">
				</td>
				<td><%=rs.getDouble(19)%></td>
				<td><input type="text" name="paint_cloth_remarks"
					value=<%=rs.getDouble(20)%> readonly></td>
			</tr>

			<tr>
				<th>3.</th>
				<th>Suit Cloth</th>
				<td><input type="text" size="15" name="suit1_cloth_mtrs" value=<%=rs.getDouble(21)%> readonly>
					<input type="text" size="15" name="suit2_cloth_mtrs" value=<%=rs.getDouble(23) %> readonly="readonly">
				</td>
				<td><input type="text" size="15" name="suit1_cloth_pcs" value=<%=rs.getInt(22)%> readonly>
					<input type="text" size="15" name="suit2_cloth_pcs" value=<%=rs.getInt(24)%> readonly="readonly">
				</td>
				<td><%=rs.getDouble(25)%></td>
				<td><input type="text" name="suit_cloth_remarks"
					value=<%=rs.getDouble(26)%> readonly></td>

			</tr>

			<tr>
				<th>4.</th>
				<th>Blazer Cloth</th>

				<td><input type="text" size="15" name="blaizer1_cloth_mtrs" value=<%=rs.getDouble(27)%> readonly>
					<input type="text" size="15" name="blaizer2_cloth_mtrs" value=<%=rs.getDouble(29)%> readonly="readonly">
				</td>
				<td><input type="text" size="15" name="blaizer1_cloth_pcs" value=<%=rs.getInt(28)%> readonly>
					<input type="text" size="15" name="blaizer2_cloth_pcs" value=<%=rs.getInt(30) %> readonly="readonly">
				</td>
				<td><%=rs.getInt(31)%></td>
				<td><input type="text" name="blaizer_cloth_remarks"
					value=<%=rs.getDouble(32) %> readonly></td>

			</tr>


		<!-- Upper wala sbhi ku6 shirt and pant cloth ke liye hai -->
		<tr>
			<th></th>
			<th>Sarees With Blouse</th>
			<th>Pcs</th>
			<th></th>
			<th>Total(Pcs)</th>
			<th>Remarks</th>
		</tr>
		<tr>
			<th>5.</th>
			<th>Silk Sarees</th>
			<td><%=rs.getInt(33)%></td>
			<td></td>
			<td><%=rs.getInt(34)%></td>
			<td><%=rs.getDouble(35)%></td>
		</tr>
		<tr>
			<th>6.</th>
			<th>Crape Sarees</th>
			<td><%=rs.getInt(36)%></td>
			<td></td>
			<td><%=rs.getInt(37)%></td>
			<td><%=rs.getDouble(38)%></td>
		</tr>
		<tr>
			<th>7.</th>
			<th>Synthetic Sarees</th>
			<td><%=rs.getInt(39)%></td>
			<td></td>
			<td><%=rs.getInt(40)%></td>
			<td><%=rs.getDouble(41)%></td>
		</tr>
		<tr>
			<th>8.</th>
			<th>Nos. of Neck Ties</th>
			<td><%=rs.getInt(42)%></td>
			<td></td>
			<td><%=rs.getInt(43)%>
			</td>
			<td><%=rs.getDouble(44)%></td>
		</tr>
		<tr>
			<th>9.</th>
			<th>Ladies Scarves(opt.male uniform)</th>
			<td><%=rs.getInt(45)%></td>
			<td></td>
			<td><%=rs.getInt(46)%></td>
			<td><%=rs.getDouble(47)%></td>
		</tr>




		<!-- ...........................here we take input for below items from user............................................ -->
		<tr>
			<th>10.Half Sleeve Gents Cardigan(No.of pcs)</th>
			<th>11.PullOver/Jersey(No.of pcs)</th>
			<th>12.Fire PullOver(No.of pcs)</th>
			<th>13.Ladies Cardigan(No.of pcs)</th>
			<th></th>
			<th> Remarks</th>
		</tr>
		<tr>
		<!--here no 48 is used for is_ voucherno rs.getInt(48) -->
			<td>(32 Size): <%=rs.getInt(49)%></td>
			<td>: <%=rs.getInt(50)%></td>
			<td>: <%=rs.getInt(51)%></td>
			<td>: <%=rs.getInt(52)%></td>
			<td></td>
			<td>: <%=rs.getDouble(53)%></td>
		</tr>
		<tr>
			<td>(34 Size ): <%=rs.getInt(54)%></td>
			<td>: <%=rs.getInt(55)%></td>
			<td>: <%=rs.getInt(56)%></td>
			<td>: <%=rs.getInt(57)%></td>
			<td></td>
			<td>: <%=rs.getDouble(58)%></td>
		</tr>
		<tr>
			<td>(36 Size): <%=rs.getInt(59)%></td>
			<td>: <%=rs.getInt(60)%>
			</td>
			<td>: <%=rs.getInt(61)%>
			</td>
			<td>: <%=rs.getInt(62)%></td>
			<td></td>
			<td>: <%=rs.getDouble(63)%></td>
		</tr>
		<tr>
			<td>(38 Size): <%=rs.getInt(64)%></td>
			<td>: <%=rs.getInt(65)%></td>
			<td>: <%=rs.getInt(66)%></td>
			<td>: <%=rs.getInt(67)%></td>
			<td></td>
			<td>: <%=rs.getDouble(68)%></td>
		</tr>
		<tr>
			<td>(40 Size): <%=rs.getInt(69)%></td>
			<td>: <%=rs.getInt(70)%></td>
			<td>: <%=rs.getInt(71)%></td>
			<td>: <%=rs.getInt(72)%></td>
			<td></td>
			<td>: <%=rs.getDouble(73)%></td>
		</tr>
		<tr>
			<td>(42 Size): <%=rs.getInt(74)%></td>
			<td>: <%=rs.getInt(75)%></td>
			<td>: <%=rs.getInt(76)%></td>
			<td>: <%=rs.getInt(77)%></td>
			<td></td>
			<td>: <%=rs.getDouble(78)%></td>
		</tr>
		<tr>
			<td>(44 Size): <%=rs.getInt(79)%></td>
			<td>: <%=rs.getInt(80)%></td>
			<td>: <%=rs.getInt(81)%></td>
			<td>: <%=rs.getInt(82)%></td>
			<td></td>
			<td>: <%=rs.getDouble(83)%></td>
		</tr>
		<tr>
			<td>(46 Size):<%=rs.getInt(84)%></td>
			<td>: <%=rs.getInt(85)%></td>
			<td>: <%=rs.getInt(86)%></td>
			<td>: <%=rs.getInt(87)%></td>
			<td></td>
			<td>: <%=rs.getDouble(88)%></td>
		</tr>
		<tr>
			<td>(48 Size): <%=rs.getInt(89)%></td>
			<td>: <%=rs.getInt(90)%></td>
			<td>: <%=rs.getInt(91)%></td>
			<td>: <%=rs.getInt(92)%></td>
			<td></td>
			<td>: <%=rs.getDouble(93)%></td>
		</tr>
		<tr style="font-weight: bold;">
			<td style="font-weight: bold;">Total:<%=rs.getDouble(94)%></td>
			<td>: <%=rs.getDouble(95)%></td>
			<td>: <%=rs.getDouble(96)%></td>
			<td>: <%=rs.getDouble(97)%></td>
			<td></td>
			<td>: <%=rs.getDouble(98)%></td>
		</tr>

	</table>
	<br>
	<h5><a href="ViewReceiptVoucherList.jsp">Back To Page</a> </h5>
	<br>
	<br>
	<br>
	<%
		}
	%>

</body>
</html>