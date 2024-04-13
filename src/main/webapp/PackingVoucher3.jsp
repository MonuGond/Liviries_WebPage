<%@page import="packingVoucher.PackingVoucher2Pozo"%>
<%@page import="packingVoucher.PackingVoucher1Pozo"%>
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
	width: 65%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

table.center {
	width: 70%;
	margin-left: 15%;
	margin-right: 15%;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>

</head>
<body>
<%
		PackingVoucher1Pozo p = (PackingVoucher1Pozo) request.getAttribute("PackingVoucher1Pozo");
		String date = request.getAttribute("date").toString();
		System.out.println(p);
		PackingVoucher2Pozo p2 = (PackingVoucher2Pozo) request.getAttribute("PackingVoucher2Pozo");
	%>
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

	<div style="display: flex; justify-content: center;">
		<img src="Airports_Authority_of_India.png"
			style="width: 120px; height: 100px;" />
	</div>
	<h5>RECEIPT AND ISSUE VOUCHER</h5>
	<a href="Home.html">Home Page</a>
	<h1>
		<u>PACKING SLIP</u>
	</h1>

	<table class="center">
		<tr>
			<td>Name and Address of Consignee:</td>
			<td><input type="text" size="80" name="n_a_consignee"
				value=<%=p.getN_a_consignee()%> readonly="readonly"><br></td>

		</tr>
		<tr>
			<td>Our Reference :</td>
			<td><input type="text" size="80" name="ourreference"
				value=<%=p.getOurreference()%> readonly="readonly"></td>
		</tr>

		<tr>
			<td>Issue Voucher No:</td>
			<td><input type="text" size="20" name="issuevoucherno"
				value=<%=p.getIssuevoucherno()%> readonly="readonly"></td>
		</tr>

		<tr>
			<td>Date :</td>
			<td><input type="date" name="pdate" value=<%=date%>
				readonly="readonly"></td>
		</tr>
	</table>

	<table border="1" class="center">

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
			<td><input type="text" name="shirting1_cloth_mtrs"
				value=<%=p.getShirting1_cloth_mtrs()%> readonly="readonly">
				<input type="text" name="shirting2_cloth_mtrs"
				value=<%=p.getShirting2_cloth_mtrs()%> readonly="readonly"></td>
			<td><input type="text" name="shirting1_cloth_pcs"
				value=<%=p.getShirting1_cloth_pcs()%> readonly="readonly"> <input
				type="text" name="shirting2_cloth_pcs"
				value=<%=p.getShirting2_cloth_pcs()%> readonly="readonly"></td>
			<td><%=p.getShirting_cloth_qnt()%></td>
			<td><input type="text" name="shirting_cloth_remarks"
				value=<%=p.getShirting_cloth_remarks()%> readonly="readonly"></td>

		</tr>

		<tr>
			<th>2.</th>
			<th>Pant Cloth</th>
			<td><input type="text" name="paint1_cloth_mtrs"
				value=<%=p.getPaint1_cloth_mtrs()%> readonly="readonly"> <input
				type="text" name="paint2_cloth_mtrs"
				value=<%=p.getPaint2_cloth_mtrs()%> readonly="readonly"></td>
			<td><input type="text" name="paint1_cloth_pcs"
				value=<%=p.getPaint1_cloth_pcs()%> readonly="readonly"> <input
				type="text" name="paint2_cloth_pcs"
				value=<%=p.getPaint2_cloth_pcs()%> readonly="readonly"></td>
			<td><%=p.getPaint_cloth_qtn()%></td>
			<td><input type="text" name="paint_cloth_remarks"
				value=<%=p.getPaint_cloth_remarks()%> readonly="readonly"></td>
		</tr>

		<tr>
			<th>3.</th>
			<th>Suit Cloth</th>
			<td><input type="text" name="suit1_cloth_mtrs"
				value=<%=p.getSuit1_cloth_mtrs()%> readonly="readonly"> <input
				type="text" name="suit2_cloth_mtrs"
				value=<%=p.getSuit2_cloth_mtrs()%> readonly="readonly"></td>
			<td><input type="text" name="suit1_cloth_pcs"
				value=<%=p.getSuit1_cloth_pcs()%> readonly="readonly"> <input
				type="text" name="suit2_cloth_pcs" value=<%=p.getSuit2_cloth_pcs()%>
				readonly="readonly"></td>
			<td><%=p.getSuit_cloth_qtn()%></td>
			<td><input type="text" name="suit_cloth_remarks"
				value=<%=p.getSuit_cloth_remarks()%> readonly="readonly"></td>

		</tr>

		<tr>
			<th>4.</th>
			<th>Blazer Cloth</th>

			<td><input type="text" name="blaizer1_cloth_mtrs"
				value=<%=p.getBlaizer1_cloth_mtrs()%> readonly="readonly"> <input
				type="text" name="blaizer2_cloth_mtrs"
				value=<%=p.getBlaizer2_cloth_mtrs()%> readonly="readonly"></td>
			<td><input type="text" name="blaizer1_cloth_pcs"
				value=<%=p.getBlaizer1_cloth_pcs()%> readonly="readonly"> <input
				type="text" name="blaizer2_cloth_pcs"
				value=<%=p.getBlaizer2_cloth_pcs()%>></td>
			<td><%=p.getBlaizer_cloth_qtn()%></td>
			<td><input type="text" name="blaizer_cloth_remarks"
				value=<%=p.getBlaizer_cloth_remarks()%>></td>

		</tr>


		<!-- Upper wala sbhi ku6 shirt and pant cloth ke liye hai -->
		<tr>
			<th></th>
			<th>Sarees With Blouse</th>
			<th>Pcs</th>
			<th></th>
			<th>Total(Pcs)</th>
		</tr>
		<tr>
			<th>5.</th>
			<th>Silk Sarees</th>
			<td><input type="text" name="silk_saree_pcs"
				value=<%=p.getSilk_saree_pcs()%> readonly="readonly"></td>
			<td></td>
			<td><%=p.getSilk_saree_qtn()%></td>
			<td><input type="text" name="silk_saree_remark"
				value=<%=p.getSilk_saree_remark()%> readonly="readonly"></td>
		</tr>
		<tr>
			<th>6.</th>
			<th>Crape Sarees</th>
			<td><input type="text" name="crape_saree_pcs"
				value=<%=p.getCrape_saree_pcs()%> readonly="readonly"></td>
			<td></td>
			<td><%=p.getCrape_saree_qtn()%></td>
			<td><input type="text" name="crape_saree_remark"
				value=<%=p.getCrape_saree_remark()%> readonly="readonly"></td>
		</tr>
		<tr>
			<th>7.</th>
			<th>Synthetic Sarees</th>
			<td><input type="text" name="synthetic_saree_pcs"
				value=<%=p.getSynthetic_saree_pcs()%> readonly="readonly"></td>
			<td></td>
			<td><%=p.getSynthetic_saree_qtn()%></td>
			<td><input type="text" name="synthetic_saree_remark"
				value=<%=p.getSynthetic_saree_remark()%> readonly="readonly"></td>
		</tr>
		<tr>
			<th>8.</th>
			<th>Nos. of Neck Ties.</th>
			<td><input type="text" name="neck_tie_pcs"
				value=<%=p.getNeck_tie_pcs()%> readonly="readonly"></td>
			<td></td>
			<td><%=p.getNeck_tie_qtn()%></td>
			<td><input type="text" name="neck_tie_remark"
				value=<%=p.getNeck_tie_remark()%> readonly="readonly"></td>
		</tr>
		<tr>
			<th>9.</th>
			<th>Scarves for Ladies(opt. for male uniform)</th>
			<td><input type="text" name="scarves_pcs"
				value=<%=p.getScarves_pcs()%> readonly="readonly"></td>
			<td></td>
			<td><%=p.getScarves_qtn()%></td>
			<td><input type="text" name="scarves_remark"
				value=<%=p.getScarves_remark()%> readonly="readonly"></td>
		</tr>











		<!-- ...........................here we take input for below items from user............................................ -->
		<tr>
			<th>10. Half Sleeve Gents Cardigan</th>
			<th>11. Pull Over(Jersey)</th>
			<th>12. Fire Pull Over</th>
			<th>13. Ladies Cardigan</th>
			<th></th>
			<th>Remarks</th>
		</tr>
		<tr>
			<td>No.of pcs(32 Size ):<input type="text" name="h1_32_size"
				value=<%=p2.getH1_32_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p1_32_size"
				value=<%=p2.getP1_32_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f1_32_size"
				value=<%=p2.getF1_32_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc1_32_size"
				value=<%=p2.getLc1_32_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_32_size"
				value=<%=p2.getRemarks_32_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(34 Size):<input type="text" name="h2_34_size"
				value=<%=p2.getH2_34_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p2_34_size"
				value=<%=p2.getP2_34_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f2_34_size"
				value=<%=p2.getF2_34_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc2_34_size"
				value=<%=p2.getLc2_34_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_34_size"
				value=<%=p2.getRemarks_34_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(36 Size):<input type="text" name="h3_36_size"
				value=<%=p2.getH3_36_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p3_36_size"
				value=<%=p2.getP3_36_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f3_36_size"
				value=<%=p2.getF3_36_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc3_36_size"
				value=<%=p2.getLc3_36_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_36_size"
				value=<%=p2.getRemarks_36_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(38 Size):<input type="text" name="h4_38_size"
				value=<%=p2.getH4_38_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p4_38_size"
				value=<%=p2.getP4_38_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f4_38_size"
				value=<%=p2.getF4_38_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc4_38_size"
				value=<%=p2.getLc4_38_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_38_size"
				value=<%=p2.getRemarks_38_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(40 Size):<input type="text" name="h5_40_size"
				value=<%=p2.getH5_40_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p5_40_size"
				value=<%=p2.getP5_40_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f5_40_size"
				value=<%=p2.getF5_40_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc5_40_size"
				value=<%=p2.getLc5_40_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_40_size"
				value=<%=p2.getRemarks_40_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(42 Size):<input type="text" name="h6_42_size"
				value=<%=p2.getH6_42_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p6_42_size"
				value=<%=p2.getP6_42_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f6_42_size"
				value=<%=p2.getF6_42_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc6_42_size"
				value=<%=p2.getLc6_42_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_42_size"
				value=<%=p2.getRemarks_42_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(44 Size):<input type="text" name="h7_44_size"
				value=<%=p2.getH7_44_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p7_44_size"
				value=<%=p2.getP7_44_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f7_44_size"
				value=<%=p2.getF7_44_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc7_44_size"
				value=<%=p2.getLc7_44_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_44_size"
				value=<%=p2.getRemarks_44_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(46 Size):<input type="text" name="h8_46_size"
				value=<%=p2.getH8_46_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p8_46_size"
				value=<%=p2.getP8_46_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f8_46_size"
				value=<%=p2.getF8_46_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc8_46_size"
				value=<%=p2.getLc8_46_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_46_size"
				value=<%=p2.getRemarks_46_size()%> readonly="readonly"></td>
		</tr>
		<tr>
			<td>No.of pcs(48 Size):<input type="text" name="h9_48_size"
				value=<%=p2.getH9_48_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="p9_48_size"
				value=<%=p2.getP9_48_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="f9_48_size"
				value=<%=p2.getF9_48_size()%> readonly="readonly"></td>
			<td>:<input type="text" name="lc9_48_size"
				value=<%=p2.getLc9_48_size()%> readonly="readonly"></td>
			<td></td>
			<td>:<input type="text" name="remarks_48_size"
				value=<%=p2.getRemarks_48_size()%> readonly="readonly"></td>
		</tr>
		<tr>
		
			<td>Total :<input type="text" name="total_h_s_g_c_qtny"
				value=<%=p2.getTotal_h_s_g_c_qtny()%> readonly></td>
			<td>:<input type="text" name="total_p_o_qtny"
				value=<%=p2.getTotal_p_o_qtny()%> readonly></td>
			<td>:<input type="text" name="total_f_p_o_qtny"
				value=<%=p2.getTotal_f_p_o_qtny()%> readonly></td>
			<td>:<input type="text" name="total_l_c_qtny"
				value=<%=p2.getTotal_l_c_qtny()%> readonly></td>
			<td></td>
			<td>:<input type="text" name="total_remarks"
				value=<%=p2.getTotal_remarks()%> readonly></td>
		</tr>

	</table>


	<form action="PackingVoucherPdfServlet" method="post" style="align-self: center;">
	<h3 align="center">
		 <input name="issuevoucherno" id="issuevoucherno" value=<%=p.getIssuevoucherno()%> readonly>
		  <input type="submit" value="View PDF" name="btnview">
		  </h3>
	</form>

	<h3 align="center">
		<a href="Email.jsp">Send Email </a>
	</h3>


</body>
</html>