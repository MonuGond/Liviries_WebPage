<%@page import="otherAirportLocation.LocationOtherAirport1Pozo"%>
<%@page import="sendReceive.SenderReceiverPozo"%>
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
<title>Receipt voucher Generate page for other Airport</title>
<style>
h1 {
	text-align: center;
	text-shadow: 10px 10px 5px grey;
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
<body onmouseleave="onChange()">
<%		
int issue_vr_no=0;
Class.forName("oracle.jdbc.driver.OracleDriver");
Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
String querypdf="select ReceiptOtherAirport1_sequence.nextval from dual";
PreparedStatement ps=conn.prepareStatement(querypdf);
ResultSet rs=ps.executeQuery();
while(rs.next()){
	issue_vr_no=rs.getInt(1);
}
		
 		SenderReceiverPozo sr = (SenderReceiverPozo)request.getAttribute("SenderReceiverPozo");
		LocationOtherAirport1Pozo l1=(LocationOtherAirport1Pozo)request.getAttribute("LocationOtherAirport1Pozo1");
		LocationOtherAirport1Pozo l2 =(LocationOtherAirport1Pozo) request.getAttribute("LocationOtherAirport1Pozo2");
	%>
	
	<form action="ReceiptOtherAirport1Servlet" method="post">

		<a href="Home.html">Home Page</a>
		
		<div style="display: flex; justify-content: center;">
			<img src="Airports_Authority_of_India.png"
				style="width: 120px; height: 100px;" />
		</div>
		<h5>RECEIPT AND ISSUE VOUCHER</h5>
	

		
			<table class="center">
				<tr>
					<td>
						<p align="left">To</p>
						<p align="left">Receiver<input type="text" name="t_receiver" size="20" value=<%=sr.getF_sender()%> readonly="readonly"> </p>
						<p align="left">
							Airport Name:
							<input type="text" name="t_airportname" size="30" value=<%=l1.getAirportname()%> readonly></p>
						<p align="left">
							Address:<input type="text" size="30" name="t_airportaddress" value=<%=l1.getAirportaddress()%> readonly></p>
					</td>

					<td>
						<p align="left">From </p>
						<p align="left">Sender:<input type="text" name="f_sender" size="20" value=<%=sr.getT_receiver() %> readonly="readonly"></p>
						<p align="left">Airport Name:<input type="text" name="f_airportname" size="30" value=<%=l2.getAirportname()%> readonly></p>
						<p align="left">Airport Address:<input type="text" size="30" name="f_airportaddress" value=<%=l2.getAirportaddress()%> readonly></p>
					</td>
				</tr>

			</table>


			<!-- yha se shirting cloth ke liye table hai -->
			<table border="1"  class="center">
				<tr>
					<td>I/Vr No : <input type="text" size="10" name="issue_vr_no" value=<%="OR"+issue_vr_no %> readonly> </td>
					<td>Date :<input type="date" size="10" name="issue_date" required="required">
					</td>
					<td><p>FOR 03 YEAR</p></td>
				</tr>
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
					<td><input type="text" name="shirting1_cloth_mtrs" id="shirting_cloth_mtrs">
						<input type="text" name="shirting2_cloth_mtrs" id="shirting_cloth_mtrs"></td>
					<td>
					 	<input type="text" name="shirting1_cloth_pcs" id="shirting_cloth_pcs">
						<input type="text" name="shirting2_cloth_pcs" id="shirting_cloth_pcs"></td>
					<td></td>
					<td><input type="text" name="shirting_cloth_remarks"></td>

				</tr>

				<tr>
					<th>2.</th>
					<th>Pant Cloth</th>
					<td><input type="text" name="paint1_cloth_mtrs">
					 	<input type="text" name="paint2_cloth_mtrs"></td>
					<td><input type="text" name="paint1_cloth_pcs">
					<input type="text" name="paint2_cloth_pcs"></td>
					<td></td>
					<td><input type="text" name="paint_cloth_remarks"></td>
				</tr>

				<tr>
					<th>3.</th>
					<th>Suit Cloth</th>
					<td><input type="text" name="suit1_cloth_mtrs">
						<input type="text" name="suit2_cloth_mtrs"></td>
					<td><input type="text" name="suit1_cloth_pcs">
					<input type="text" name="suit2_cloth_pcs"></td>
					<td></td>
					<td><input type="text" name="suit_cloth_remarks"></td>

				</tr>

				<tr>
					<th>4.</th>
					<th>Blazer Cloth</th>

					<td><input type="text" name="blaizer1_cloth_mtrs">
						<input type="text" name="blaizer2_cloth_mtrs"></td>
					<td><input type="text" name="blaizer1_cloth_pcs">
					<input type="text" name="blaizer2_cloth_pcs"></td>
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
				<input type="submit" value="Go to next Page2">
			</h3>
			<a href="ReceiptOtherAirport2.jsp">Go to next Page</a>
	</form>
	
</body>
</html>