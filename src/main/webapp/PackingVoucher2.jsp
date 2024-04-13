<%@page import="packingVoucher.PackingVoucher1Pozo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>

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

table.center {
	width: 70%;
	margin-left: 15%;
	margin-right: 15%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
</head>
<body>
<%
		PackingVoucher1Pozo p = (PackingVoucher1Pozo) request.getAttribute("PackingVoucher1Pozo");
	/* int issuevoucherno=0;
	Class.forName("oracle.jdbc.driver.OracleDriver");
	Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
	String querypdf="select * from packingvoucher1 where issuevoucherno ='"+issuevoucherno+"'";
	PreparedStatement ps=conn.prepareStatement(querypdf);
	ResultSet rs=ps.executeQuery();
	ArrayList<PackingVoucher1Pozo>issue_number1=new ArrayList<>();
	//ArrayList<PackingVoucher1Pozo>packingpdf=new ArrayList<>();
	while(rs.next()){
		PackingVoucher1Pozo p1 = new PackingVoucher1Pozo();
		p1.setIssuevoucherno(rs.getInt(3));
		issue_number1.add(p1);
	} */

		String date = request.getAttribute("date").toString();
		System.out.println(p);
		//String date =request.getAttribute("pdate").toString();
		//System.out.println(p);
	%>
	<div style="display: flex; justify-content: center;">
		<img src="Airports_Authority_of_India.png"
			style="width: 120px; height: 100px;" />
	</div>
	<h5>RECEIPT AND ISSUE VOUCHER</h5>
	<h1>
		<u>PACKING SLIP</u>
	</h1>



	<form action="PackingVoucher2Servlet" method="post">
		<table class="center">

			<tr>
				<td>Name and Address of Consignee:</td>
				<td><input type="text" size="80" name="n_a_consignee"
					value=<%=p.getN_a_consignee().replace(" ", "_")%>
					readonly="readonly">
					<%
						p.getN_a_consignee();
					%><br></td>
			</tr>
			<tr>
				<td>Our Reference :</td>
				<td><input type="text" size="80" name="ourreference"
					value=<%=p.getOurreference().replace(" ", "_")%> readonly="readonly"></td>
			</tr>

			<tr>
				<td>Issue Voucher No:</td>
				<td><input type="text" size="20" name="issuevoucherno"
					value=<%=p.getIssuevoucherno()%> readonly="readonly"></td>
			</tr>

			<tr>
				<td>Date :</td>
				<%-- <h3>Here <%=p.getPdate() %></h3> --%>
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
					value=<%=p.getShirting1_cloth_pcs()%> readonly="readonly">
					<input type="text" name="shirting2_cloth_pcs"
					value=<%=p.getShirting2_cloth_pcs()%> readonly="readonly"></td>
				<td> <%=p.getShirting_cloth_qnt() %> </td>
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
				<td> <%=p.getPaint_cloth_qtn() %> </td>
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
					type="text" name="suit2_cloth_pcs"
					value=<%=p.getSuit2_cloth_pcs()%> readonly="readonly"></td>
				<td> <%=p.getSuit_cloth_qtn() %> </td>
				<td><input type="text" name="suit_cloth_remarks"
					value=<%=p.getSuit_cloth_remarks()%> readonly="readonly"></td>

			</tr>

			<tr>
				<th>4.</th>
				<th>Blazer Cloth</th>

				<td><input type="text" name="blaizer1_cloth_mtrs"
					value=<%=p.getBlaizer1_cloth_mtrs()%> readonly="readonly">
					<input type="text" name="blaizer2_cloth_mtrs"
					value=<%=p.getBlaizer2_cloth_mtrs()%> readonly="readonly"></td>
				<td><input type="text" name="blaizer1_cloth_pcs"
					value=<%=p.getBlaizer1_cloth_pcs()%> readonly="readonly"> <input
					type="text" name="blaizer2_cloth_pcs"
					value=<%=p.getBlaizer2_cloth_pcs()%> readonly="readonly"></td>
				<td> <%=p.getBlaizer_cloth_qtn() %> </td>
				<td><input type="text" name="blaizer_cloth_remarks"
					value=<%=p.getBlaizer_cloth_remarks()%> readonly="readonly"></td>

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
					value=<%=p.getSilk_saree_pcs()%> readonly></td>
				<td></td>
				<td> <%=p.getSilk_saree_qtn() %> </td>
				<td><input type="text" name="silk_saree_remark"
					value=<%=p.getSilk_saree_remark()%> readonly></td>
			</tr>
			<tr>
				<th>6.</th>
				<th>Crape Sarees</th>
				<td><input type="text" name="crape_saree_pcs"
					value=<%=p.getCrape_saree_pcs()%> readonly></td>
				<td></td>
				<td> <%=p.getCrape_saree_qtn() %> </td>
				<td><input type="text" name="crape_saree_remark"
					value=<%=p.getCrape_saree_remark()%> readonly></td>
			</tr>
			<tr>
				<th>7.</th>
				<th>Synthetic Sarees</th>
				<td><input type="text" name="synthetic_saree_pcs"
					value=<%=p.getSynthetic_saree_pcs()%> readonly></td>
				<td></td>
				<td> <%=p.getSynthetic_saree_qtn() %> </td>
				<td><input type="text" name="synthetic_saree_remark"
					value=<%=p.getSynthetic_saree_remark()%> readonly></td>
			</tr>
			<tr>
				<th>8.</th>
				<th>Nos. of Neck Ties.</th>
				<td><input type="text" name="neck_tie_pcs"
					value=<%=p.getNeck_tie_pcs()%> readonly></td>
				<td></td>
				<td> <%=p.getNeck_tie_qtn() %> </td>
				<td><input type="text" name="neck_tie_remark"
					value=<%=p.getNeck_tie_remark()%> readonly></td>
			</tr>
			<tr>
				<th>9.</th>
				<th>Scarves for Ladies(opt. for male uniform)</th>
				<td><input type="text" name="scarves_pcs"
					value=<%=p.getScarves_pcs()%> readonly></td>
				<td></td>
				<td> <%=p.getScarves_qtn() %> </td>
				<td><input type="text" name="scarves_remark"
					value=<%=p.getScarves_remark()%> readonly></td>
			</tr>













			<!-- ...........................here we take input for below items from user............................................ -->
			<!-- <form action="PackingVoucher2Servlet" method="post"> -->
			<tr>
				<th>10. Half Sleeve Gents Cardigan</th>
				<th>11. Pull Over(Jersey)</th>
				<th>12. Fire Pull Over</th>
				<th>13. Ladies Cardigan</th>
				<th></th>
				<th>Remarks</th>
			</tr>
			<tr>
				<td>No.of pcs(32 Size ):<input type="text" name="h1_32_size"></td>
				<td>:<input type="text" name="p1_32_size"></td>
				<td>:<input type="text" name="f1_32_size"></td>
				<td>:<input type="text" name="lc1_32_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_32_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(34 Size):<input type="text" name="h2_34_size"></td>
				<td>:<input type="text" name="p2_34_size"></td>
				<td>:<input type="text" name="f2_34_size"></td>
				<td>:<input type="text" name="lc2_34_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_34_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(36 Size):<input type="text" name="h3_36_size"></td>
				<td>:<input type="text" name="p3_36_size"></td>
				<td>:<input type="text" name="f3_36_size"></td>
				<td>:<input type="text" name="lc3_36_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_36_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(38 Size):<input type="text" name="h4_38_size"></td>
				<td>:<input type="text" name="p4_38_size"></td>
				<td>:<input type="text" name="f4_38_size"></td>
				<td>:<input type="text" name="lc4_38_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_38_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(40 Size):<input type="text" name="h5_40_size"></td>
				<td>:<input type="text" name="p5_40_size"></td>
				<td>:<input type="text" name="f5_40_size"></td>
				<td>:<input type="text" name="lc5_40_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_40_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(42 Size):<input type="text" name="h6_42_size"></td>
				<td>:<input type="text" name="p6_42_size"></td>
				<td>:<input type="text" name="f6_42_size"></td>
				<td>:<input type="text" name="lc6_42_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_42_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(44 Size):<input type="text" name="h7_44_size"></td>
				<td>:<input type="text" name="p7_44_size"></td>
				<td>:<input type="text" name="f7_44_size"></td>
				<td>:<input type="text" name="lc7_44_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_44_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(46 Size):<input type="text" name="h8_46_size"></td>
				<td>:<input type="text" name="p8_46_size"></td>
				<td>:<input type="text" name="f8_46_size"></td>
				<td>:<input type="text" name="lc8_46_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_46_size"></td>
			</tr>
			<tr>
				<td>No.of pcs(48 Size):<input type="text" name="h9_48_size"></td>
				<td>:<input type="text" name="p9_48_size"></td>
				<td>:<input type="text" name="f9_48_size"></td>
				<td>:<input type="text" name="lc9_48_size"></td>
				<td></td>
				<td>:<input type="text" name="remarks_48_size"></td>
			</tr>
			<!-- <tr>
				<td>Total :<input type="text" name="total_h_s_g_c_qtny"
					readonly></td>
				<td>:<input type="text" name="total_p_o_qtny" readonly></td>
				<td>:<input type="text" name="total_f_p_o_qtny" readonly></td>
				<td>:<input type="text" name="total_l_c_qtny" readonly></td>
				<td></td>
				<td>:<input type="text" name="total_remarks" readonly></td>
			</tr> -->
		</table>
		<h3 align="center">
			<input type="submit" value="Generate Voucher">
		</h3>

	</form>
	<a href="PackingVoucher3.jsp">Jsp page </a>




	<h3>

		<!-- yha se servlet me jata -->
	</h3>


</body>
</html>