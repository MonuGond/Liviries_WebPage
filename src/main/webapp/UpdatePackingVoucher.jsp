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
<%
		String issuevoucherno=request.getParameter("issuevoucherno");
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "SELECT * FROM PackingVoucher1 P1 inner join packingvoucher2 P2 on  p1.issuevoucherno=p2.issuevoucherno where p1.issuevoucherno='" + issuevoucherno +"'" ;
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
	<h1>
		<u>PACKING SLIP</u>
	</h1>
	<form action="UpdatePackingVoucherServlet" method="post">
	<table class="center">
		<tr style="font-weight: bold;">
			<td>Name and Address of Consignee:</td>
			<td><input type="text" size="80" name="n_a_consignee"
				value=<%=rs.getString(1)%>> <br></td>

		</tr>
		<tr style="font-weight: bold;">
			<td>Our Reference :</td>
			<td><input type="text" size="80" name="ourreference"
				value=<%=rs.getString(2)%>></td>
		</tr>

		<tr style="font-weight: bold;">
			<td style="color: red; font-family: verdana;">Issue Voucher No:</td>
			<td style="color: red; font-family: verdana; font-weight: bold;"><input type="text" size="20" name="issuevoucherno"
				value=<%=rs.getString(3)%> readonly="readonly">
			</td>
		</tr>

		<tr style="font-weight: bold;">
			<td style="color: red; font-family: verdana;">Date :</td>
			<td style="color: red; font-family: verdana;"><input type="date" name="pdate" value=<%=rs.getDate(4)%>
				readonly="readonly"></td>
		</tr>
	</table>

	<table border="1" class="center">

		<tr>
			<th>Sl.No.</th>
			<th>Types Of Cloth</th>
			<th>Cloth Meters</th>
			<th>Cloth Pcs</th>
			<!-- <th>Total(Mtrs)</th> -->
			<th>Remarks</th>
		</tr>



		<tr>
			<th>1.</th>
			<th>Shirting Cloth</th>
			<td><input type="text" name="shirting1_cloth_mtrs"
				value=<%=rs.getDouble(5)%> > <input
				type="text" name="shirting2_cloth_mtrs" value=<%=rs.getDouble(6)%>
			></td>
			<td><input type="text" name="shirting1_cloth_pcs"
				value=<%=rs.getInt(7)%>> <input
				type="text" name="shirting2_cloth_pcs" value=<%=rs.getInt(8)%>
				></td>
			<%-- <td><%=rs.getDouble(9)%></td> --%>
			<td><input type="text" name="shirting_cloth_remarks"
				value=<%=rs.getDouble(10)%>></td>

		</tr>

		<tr>
			<th>2.</th>
			<th>Pant Cloth</th>
			<td><input type="text" name="paint1_cloth_mtrs"
				value=<%=rs.getDouble(11)%>> <input
				type="text" name="paint2_cloth_mtrs" value=<%=rs.getDouble(12)%>></td>
			<td><input type="text" name="paint1_cloth_pcs"
				value=<%=rs.getInt(13)%>> <input
				type="text" name="paint2_cloth_pcs" value=<%=rs.getInt(14)%>></td>
			<%-- <td><%=rs.getDouble(15)%></td> --%>
			<td><input type="text" name="paint_cloth_remarks"
				value=<%=rs.getDouble(16)%>></td>
		</tr>

		<tr>
			<th>3.</th>
			<th>Suit Cloth</th>
			<td><input type="text" name="suit1_cloth_mtrs"
				value=<%=rs.getDouble(17)%>> <input
				type="text" name="suit2_cloth_mtrs" value=<%=rs.getDouble(18)%>></td>
			<td><input type="text" name="suit1_cloth_pcs"
				value=<%=rs.getInt(19)%>> <input
				type="text" name="suit2_cloth_pcs" value=<%=rs.getInt(20)%>></td>
			<%-- <td><%=rs.getDouble(21)%></td> --%>
			<td><input type="text" name="suit_cloth_remarks"
				value=<%=rs.getDouble(22)%>></td>

		</tr>

		<tr>
			<th>4.</th>
			<th>Blazer Cloth</th>

			<td><input type="text" name="blaizer1_cloth_mtrs"
				value=<%=rs.getDouble(23)%>> <input
				type="text" name="blaizer2_cloth_mtrs" value=<%=rs.getDouble(24)%>></td>
			<td><input type="text" name="blaizer1_cloth_pcs"
				value=<%=rs.getInt(25)%>> <input
				type="text" name="blaizer2_cloth_pcs" value=<%=rs.getInt(26)%>></td>
			<%-- <td><%=rs.getDouble(27)%></td> --%>
			<td><input type="text" name="blaizer_cloth_remarks"
				value=<%=rs.getDouble(28)%>></td>

		</tr>


		<!-- Upper wala sbhi ku6 shirt and pant cloth ke liye hai -->
		<tr>
			<th></th>
			<th>Sarees With Blouse</th>
			<th>Pcs</th>
			<th></th>
			<!-- <th>Total(Pcs)</th> -->
			<th>Remarks</th>
		</tr>
		<tr>
			<th>5.</th>
			<th>Silk Sarees</th>
			<td><input type="text" name="silk_saree_pcs" value=<%=rs.getInt(29)%>></td>
			<td></td>
			<%-- <td> <%=rs.getDouble(30)%>></td> --%>
			<td><input type="text" name="silk_saree_remark" value=<%=rs.getDouble(31)%>></td>
		</tr>
		<tr>
			<th>6.</th>
			<th>Crape Sarees</th>
			<td><input type="text" name="crape_saree_pcs" value=<%=rs.getInt(32)%>></td>
			<td></td>
			<%-- <td><%=rs.getDouble(33)%></td> --%>
			<td><input type="text" name="crape_saree_remark" value=<%=rs.getDouble(34)%>></td>
		</tr>
		<tr>
			<th>7.</th>
			<th>Synthetic Sarees</th>
			<td><input type="text" name="synthetic_saree_pcs"
				value=<%=rs.getInt(35)%>></td>
			<td></td>
			<%-- <td><%=rs.getDouble(36)%></td> --%>
			<td><input type="text" name="synthetic_saree_remark"
				value=<%=rs.getDouble(37)%>></td>
		</tr>
		<tr>
			<th>8.</th>
			<th>Nos. of Neck Ties</th>
			<td><input type="text" name="neck_tie_pcs"
				value=<%=rs.getInt(38)%>></td>
			<td></td>
			<%-- <td><%=rs.getDouble(39)%></td> --%>
			<td><input type="text" name="neck_tie_remark"
				value=<%=rs.getDouble(40)%>></td>
		</tr>
		<tr>
			<th>9.</th>
			<th>Ladies Scarves(opt.male uniform)</th>
			<td><input type="text" name="scarves_pcs"
				value=<%=rs.getInt(41)%>></td>
			<td></td>
			<%-- <td><%=rs.getDouble(42)%></td> --%>
			<td><input type="text" name="scarves_remark"
				value=<%=rs.getDouble(43)%>></td>
		</tr>











		<!-- ...........................here we take input for below items from user............................................ -->
		<tr>
			<th>10.Half Sleeve Gents Cardigan(No.of pcs)</th>
			<th>11.PullOver(Jersey)(No.of pcs)</th>
			<th>12.Fire PullOver(No.of pcs)</th>
			<th>13.Ladies Cardigan(No.of pcs)</th>
			<th>Remarks</th>
		</tr>
		<tr>
		<td>No.of pcs(32 Size ):<input type="text" name="h1_32_size"
				value=<%=rs.getInt(45)%>></td>
			<td>:<input type="text" name="p1_32_size"
				value=<%=rs.getInt(46)%>></td>
			<td>:<input type="text" name="f1_32_size"
				value=<%=rs.getInt(47)%>></td>
			<td>:<input type="text" name="lc1_32_size"
				value=<%=rs.getInt(48)%>></td>
			<td>:<input type="text" name="remarks_32_size"
				value=<%=rs.getDouble(49)%>></td>
		</tr>
		<tr>
		
		<td>No.of pcs(34 Size):<input type="text" name="h2_34_size"
				value=<%=rs.getInt(50)%>></td>
			<td>:<input type="text" name="p2_34_size"
				value=<%=rs.getInt(51)%>></td>
			<td>:<input type="text" name="f2_34_size"
				value=<%=rs.getInt(52)%>></td>
			<td>:<input type="text" name="lc2_34_size"
				value=<%=rs.getInt(53)%>></td>
			<td>:<input type="text" name="remarks_34_size"
				value=<%=rs.getDouble(54)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(36 Size):<input type="text" name="h3_36_size"
				value=<%=rs.getInt(55)%>></td>
			<td>:<input type="text" name="p3_36_size"
				value=<%=rs.getInt(56)%>></td>
			<td>:<input type="text" name="f3_36_size"
				value=<%=rs.getInt(57)%>></td>
			<td>:<input type="text" name="lc3_36_size"
				value=<%=rs.getInt(58)%>></td>
			<td>:<input type="text" name="remarks_36_size"
				value=<%=rs.getDouble(59)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(38 Size):<input type="text" name="h4_38_size"
				value=<%=rs.getInt(60)%>></td>
			<td>:<input type="text" name="p4_38_size"
				value=<%=rs.getInt(61)%>></td>
			<td>:<input type="text" name="f4_38_size"
				value=<%=rs.getInt(62)%>></td>
			<td>:<input type="text" name="lc4_38_size"
				value=<%=rs.getInt(63)%>></td>
			<td>:<input type="text" name="remarks_38_size"
				value=<%=rs.getDouble(64)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(40 Size):<input type="text" name="h5_40_size"
				value=<%=rs.getInt(65)%>></td>
			<td>:<input type="text" name="p5_40_size"
				value=<%=rs.getInt(66)%>></td>
			<td>:<input type="text" name="f5_40_size"
				value=<%=rs.getInt(67)%>></td>
			<td>:<input type="text" name="lc5_40_size"
				value=<%=rs.getInt(68)%>></td>
			<td>:<input type="text" name="remarks_40_size"
				value=<%=rs.getDouble(69)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(42 Size):<input type="text" name="h6_42_size"
				value=<%=rs.getInt(70)%>></td>
			<td>:<input type="text" name="p6_42_size"
				value=<%=rs.getInt(71)%>></td>
			<td>:<input type="text" name="f6_42_size"
				value=<%=rs.getInt(72)%>></td>
			<td>:<input type="text" name="lc6_42_size"
				value=<%=rs.getInt(73)%>></td>
			<td>:<input type="text" name="remarks_42_size"
				value=<%=rs.getDouble(74)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(44 Size):<input type="text" name="h7_44_size"
				value=<%=rs.getInt(75)%>></td>
			<td>:<input type="text" name="p7_44_size"
				value=<%=rs.getInt(76)%>></td>
			<td>:<input type="text" name="f7_44_size"
				value=<%=rs.getInt(77)%>></td>
			<td>:<input type="text" name="lc7_44_size"
				value=<%=rs.getInt(78)%>></td>
			<td>:<input type="text" name="remarks_44_size"
				value=<%=rs.getDouble(79)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(46 Size):<input type="text" name="h8_46_size"
				value=<%=rs.getInt(80)%>></td>
			<td>:<input type="text" name="p8_46_size"
				value=<%=rs.getInt(81)%>></td>
			<td>:<input type="text" name="f8_46_size"
				value=<%=rs.getInt(82)%>></td>
			<td>:<input type="text" name="lc8_46_size"
				value=<%=rs.getInt(83)%>></td>
			<td>:<input type="text" name="remarks_46_size"
				value=<%=rs.getDouble(84)%>></td>
		</tr>
		<tr>
		<td>No.of pcs(48 Size):<input type="text" name="h9_48_size"
				value=<%=rs.getInt(85)%>></td>
			<td>:<input type="text" name="p9_48_size"
				value=<%=rs.getInt(86)%>></td>
			<td>:<input type="text" name="f9_48_size"
				value=<%=rs.getInt(87)%>></td>
			<td>:<input type="text" name="lc9_48_size"
				value=<%=rs.getInt(88)%>></td>
			<td>:<input type="text" name="remarks_48_size"
				value=<%=rs.getDouble(89)%>></td>
			</tr>
		<%-- <tr style="font-weight: bold;">

			<td>Total :<%=rs.getDouble(90)%>
			</td>
			<td>:<%=rs.getDouble(91)%>
			</td>
			<td>:<%=rs.getDouble(92)%>
			</td>
			<td>:<%=rs.getDouble(93)%></td>
			<td></td>
			<td>:<%=rs.getDouble(94)%></td>
		</tr> --%>

	</table>
	
	<h5><input type="submit" value="Update Voucher">
	 <a href="UpdatePackingVoucherList.jsp">Back To Page</a> </h5>
	<br>
	<br>
	<br>
	<br>
	
	<%
		}
	%>
</form>

</body>
</html>