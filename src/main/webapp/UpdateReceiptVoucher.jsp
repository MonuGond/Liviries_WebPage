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
	width: 85%;
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
<form action="UpdateReceiptVoucherServlet" method="post">
	
	<table>
		<tr>
			<td style="font-weight: bold;">
				<p align="left">To</p>
				<p align="left"><input type="text" size="35" name="t_receiver" style="text-align: left;" value=<%=rs.getString(1) %>> </p>
				<p align="left"><input type="text" size="35" name="t_airportname" style="text-align: left;" value=<%=rs.getString(2)%>></p>
				<p align="left"><input type="text" size="35" name="t_airportaddress" style="text-align: left;" value=<%=rs.getString(3)%>></p>
			</td>

			<td style="font-weight: bold;">
				<p align="left">From</p>
				<p align="left"><input type="text" size="35" name="f_sender" style="text-align: left;" value=<%=rs.getString(4) %>> </p>
				<p align="left"><input type="text" size="35" name="f_airportname" style="text-align: left;" value=<%=rs.getString(5) %>> </p>
				<p align="left"><input type="text" size="35" name="f_airportaddress" style="text-align: left;" value=<%=rs.getString(6) %>> </p>
			</td>
		</tr>

	</table>




	<!-- yha se shirting cloth ke liye table hai -->
	<table border="1">
		<tr style="font-weight: bold; color: red">
			<td>I/Vr No :</td>
			<td><input type="text" name="issue_vr_no" value=<%=rs.getString(7)%> readonly="readonly"></td>
			<td>Date :</td>
			<td><input type="text" name="issue_date" value=<%=rs.getDate(8)%> readonly="readonly"></td>
			<td>For 3 Year</td>
		</tr>
		<tr>
			<th>Sl.No.</th>
			<th>Types Of Cloth</th>
			<th>Cloth Meters</th>
			<th>Cloth Pcs</th>
			
			<th>Remarks</th>
		</tr>

		<!--  -->

		<tr>
				<th>1.</th>
				<th>Shirting Cloth</th>
				<td><input type="text" size="15" name="shirting1_cloth_mtrs" value=<%=rs.getDouble(9)%> >
					<input type="text" size="15" name="shirting2_cloth_mtrs" value=<%=rs.getDouble(11) %>>
				</td>
				<td><input type="text" size="15" name="shirting1_cloth_pcs" value=<%=rs.getInt(10)%>>
					<input type="text" size="15" name="shirting2_cloth_pcs" value=<%=rs.getInt(12) %>>
				</td>
				<td><input type="text" size="18" name="shirting_cloth_remarks" value=<%=rs.getDouble(14)%>></td>

			</tr>

			<tr>
				<th>2.</th>
				<th>Pant Cloth</th>
				<td><input type="text" size="15" name="paint1_cloth_mtrs"	value=<%=rs.getDouble(15)%>>
					<input type="text" size="15" name="paint2_cloth_mtrs" value=<%=rs.getDouble(17) %>>
				</td>
				<td><input type="text" size="15" name="paint1_cloth_pcs" value=<%=rs.getInt(16)%>>
					<input type="text" size="15" name="paint2_cloth_pcs" value=<%=rs.getInt(18)%>></td>
					
				<td><input type="text" size="18" name="paint_cloth_remarks" value=<%=rs.getDouble(20)%>></td>
			</tr>

			<tr>
				<th>3.</th>
				<th>Suit Cloth</th>
				<td><input type="text" size="15" name="suit1_cloth_mtrs" value=<%=rs.getDouble(21)%>>
					<input type="text" size="15" name="suit2_cloth_mtrs" value=<%=rs.getDouble(23) %>>
				</td>
				<td><input type="text" size="15" name="suit1_cloth_pcs" value=<%=rs.getInt(22)%>>
					<input type="text" size="15" name="suit2_cloth_pcs" value=<%=rs.getInt(24)%>>
				</td>
				<td><input type="text" size="18" name="suit_cloth_remarks" value=<%=rs.getDouble(26)%>></td>

			</tr>

			<tr>
				<th>4.</th>
				<th>Blazer Cloth</th>

				<td><input type="text" size="15" name="blaizer1_cloth_mtrs" value=<%=rs.getDouble(27)%>>
					<input type="text" size="15" name="blaizer2_cloth_mtrs" value=<%=rs.getDouble(29)%>>
				</td>
				<td><input type="text" size="15" name="blaizer1_cloth_pcs" value=<%=rs.getInt(28)%>>
					<input type="text" size="15" name="blaizer2_cloth_pcs" value=<%=rs.getInt(30) %>>
				</td>
				
				<td><input type="text" size="18" name="blaizer_cloth_remarks" value=<%=rs.getDouble(32) %>></td>

			</tr>


		<!-- Upper wala sbhi ku6 shirt and pant cloth ke liye hai -->
		<tr>
			<th></th>
			<th>Sarees With Blouse</th>
			<th>Pcs</th>
			<th></th>
			<th>Remarks</th>
		</tr>
		<tr>
			<th>5.</th>
			<th>Silk Sarees</th>
			<td><input type="text" size="15" name="silk_saree_pcs"  value=<%=rs.getInt(33)%>></td>
			<td></td>
			<td><input type="text" size="18" name="silk_saree_remark" value=<%=rs.getDouble(35)%>></td>
		</tr>
		<tr>
			<th>6.</th>
			<th>Crape Sarees</th>
			<td><input type="text" size="15" name="crape_saree_pcs" value=<%=rs.getInt(36)%>></td>
			<td></td>
			
			<td><input type="text" size="18" name="crape_saree_remark" value=<%=rs.getDouble(38)%>></td>
		</tr>
		<tr>
			<th>7.</th>
			<th>Synthetic Sarees</th>
			<td><input type="text" size="15" name="synthetic_saree_pcs" value=<%=rs.getInt(39)%>></td>
			<td></td>
			
			<td><input type="text" size="18" name="synthetic_saree_remark" value=<%=rs.getDouble(41)%>></td>
		</tr>
		<tr>
			<th>8.</th>
			<th>Nos. of Neck Ties</th>
			<td><input type="text" size="15" name="neck_tie_pcs" value=<%=rs.getInt(42)%>></td>
			<td></td>
			
			<td><input type="text" size="18" name="neck_tie_remark" value=<%=rs.getDouble(44)%>></td>
		</tr>
		<tr>
			<th>9.</th>
			<th>Ladies Scarves(opt.male uniform)</th>
			<td><input type="text" size="15" name="scarves_pcs" value=<%=rs.getInt(45)%>></td>
			<td></td>
			
			<td><input type="text" size="18" name="scarves_remark" value=<%=rs.getDouble(47)%>></td>
		</tr>




		<!-- ...........................here we take input for below items from user............................................ -->
		<tr>
			<th>10.Half Sleeve Gents Cardigan(No.of pcs)</th>
			<th>11.PullOver/Jersey(No.of pcs)</th>
			<th>12.Fire PullOver(No.of pcs)</th>
			<th>13.Ladies Cardigan(No.of pcs)</th>
			
			<th> Remarks</th>
		</tr>
		<tr>
		<!--here no 48 is used for is_ voucherno rs.getInt(48) -->
			<td>(32 Size):<input type="text" size="15" name="h1_32_size" value=<%=rs.getInt(49)%>></td>
			<td>:<input type="text" size="15" name="p1_32_size" value=<%=rs.getInt(50)%>></td>
			<td>:<input type="text" size="15" name="f1_32_size" value=<%=rs.getInt(51)%>></td>
			<td>:<input type="text" size="15" name="lc1_32_size" value=<%=rs.getInt(52)%>></td>
			
			<td>:<input type="text" size="18" name="remarks_32_size" value=<%=rs.getDouble(53)%>></td>
		</tr>
		<tr>
			<td>(34 Size ):<input type="text" size="15" name="h2_34_size" value=<%=rs.getInt(54)%>></td>
			<td>:<input type="text" size="15" name="p2_34_size" value=<%=rs.getInt(55)%>></td>
			<td>:<input type="text" size="15" name="f2_34_size" value=<%=rs.getInt(56)%>></td>
			<td>:<input type="text" size="15" name="lc2_34_size" value=<%=rs.getInt(57)%>></td>
			<td>:<input type="text" size="18" name="remarks_34_size" value=<%=rs.getDouble(58)%>></td>
		</tr>
		<tr>
			<td>(36 Size):<input type="text" size="15" name="h3_36_size" value=<%=rs.getInt(59)%>></td>
			<td>:<input type="text" size="15" name="p3_36_size" value=<%=rs.getInt(60)%>></td>
			<td>:<input type="text" size="15" name="f3_36_size" value=<%=rs.getInt(61)%>></td>
			<td>:<input type="text" size="15" name="lc3_36_size" value=<%=rs.getInt(62)%>></td>
			
			<td>:<input type="text" size="18" name="remarks_36_size" value=<%=rs.getDouble(63)%>></td>
		</tr>
		<tr>
			<td>(38 Size):<input type="text" size="15" name="h4_38_size" value=<%=rs.getInt(64)%>></td>
			<td>:<input type="text" size="15" name="p4_38_size" value=<%=rs.getInt(65)%>></td>
			<td>:<input type="text" size="15" name="f4_38_size" value=<%=rs.getInt(66)%>></td>
			<td>:<input type="text" size="15" name="lc4_38_size" value=<%=rs.getInt(67)%>></td>
			
			<td>:<input type="text" size="18" name="remarks_38_size" value=<%=rs.getDouble(68)%>></td>
		</tr>
		<tr>
			<td>(40 Size):<input type="text" size="15" name="h5_40_size" value=<%=rs.getInt(69)%>></td>
			<td>:<input type="text" size="15" name="p5_40_size" value=<%=rs.getInt(70)%>></td>
			<td>:<input type="text" size="15" name="f5_40_size" value=<%=rs.getInt(71)%>></td>
			<td>:<input type="text" size="15" name="lc5_40_size" value=<%=rs.getInt(72)%>></td>
			
			<td>:<input type="text" size="18" name="remarks_40_size" value=<%=rs.getDouble(73)%>></td>
		</tr>
		<tr>
			<td>(42 Size):<input type="text" size="15" name="h6_42_size" value=<%=rs.getInt(74)%>></td>
			<td>:<input type="text" size="15" name="p6_42_size" value=<%=rs.getInt(75)%>></td>
			<td>:<input type="text" size="15" name="f6_42_size" value=<%=rs.getInt(76)%>></td>
			<td>:<input type="text" size="15" name="lc6_42_size" value=<%=rs.getInt(77)%>></td>
			
			<td>:<input type="text" size="18" name="remarks_42_size" value=<%=rs.getDouble(78)%>></td>
		</tr>
		<tr>
			<td>(44 Size):<input type="text" size="15" name="h7_44_size" value=<%=rs.getInt(79)%>></td>
			<td>:<input type="text" size="15" name="p7_44_size" value=<%=rs.getInt(80) %>></td>
			<td>:<input type="text" size="15" name="f7_44_size" value=<%=rs.getInt(81) %> ></td>
			<td>:<input type="text" size="15" name="lc7_44_size" value=<%=rs.getInt(82) %> ></td>
			
			<td>:<input type="text" size="18" name="remarks_44_size" value=<%=rs.getDouble(83) %> ></td>
		</tr>
		<tr>
			<td>(46 Size):<input type="text" size="15" name="h8_46_size" value=<%=rs.getInt(84)%>></td>
			<td>:<input type="text" size="15" name="p8_46_size" value=<%=rs.getInt(85) %>> </td>
			<td>:<input type="text" size="15" name="f8_46_size" value=<%=rs.getInt(86) %> > </td>
			<td>:<input type="text" size="15" name="lc8_46_size" value=<%=rs.getInt(87) %> > </td>
		
			<td>:<input type="text" size="18" name="remarks_46_size" value=<%=rs.getDouble(88) %> > </td>
		</tr>
		<tr>
			<td>(48 Size):<input type="text" size="15" name="h9_48_size" value=<%=rs.getInt(89) %> ></td>
			<td>:<input type="text" size="15" name="p9_48_size" value=<%=rs.getInt(90)%>></td>
			<td>:<input type="text" size="15" name="f9_48_size" value=<%=rs.getInt(91)%>></td>
			<td>:<input type="text" size="15" name="lc9_48_size" value=<%=rs.getInt(92)%>></td>
			
			<td>:<input type="text" size="18" name="remarks_48_size" value=<%=rs.getDouble(93)%>></td>
		</tr>
	

	</table>
	
	
	
	<h5><input type="submit" value="Update Voucher">
	 <a href="UpdateReceiptVoucherList.jsp">Back To Page</a> </h5>
	
	<%} %>
</form>
</body>
</html>