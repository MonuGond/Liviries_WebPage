<%@page import="sendReceive.SenderReceiverPozo"%>
<%@page import="otherAirportLocation.LocationOtherAirport1Pozo"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.ArrayList"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
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

h5 {
	text-align: center;
	margin-top: 1px;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

h1 {
	text-align: center;
	text-shadow: 10px 10px 5px grey;
}
input{
font-family: Arial;
font-size:15px;
}
</style>
</head>
<body>

<h1>Welcome to Receipt Voucher Generate Page</h1>
	<div style="display: flex; justify-content: center;">
		<img src="Airports_Authority_of_India.png"
			style="width: 180px; height: 100px;" />
	</div>
	<h5>RECEIPT AND ISSUE VOUCHER</h5>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query = "select * from location_Other_Airport1";
		PreparedStatement ps = conn.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		ArrayList<LocationOtherAirport1Pozo> locationList = new ArrayList<>();
		while (rs.next()) {
			LocationOtherAirport1Pozo p = new LocationOtherAirport1Pozo();
			p.setAirportname(rs.getString(1));
			p.setAirportaddress(rs.getString(2));
			locationList.add(p);
		}
	%>
	<%
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn1 = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "System", "tiger1");
		String query1 = "select * from  senderreceiver";
		PreparedStatement ps1 = conn1.prepareStatement(query1);
		ResultSet rs1 = ps1.executeQuery();
		ArrayList<SenderReceiverPozo> senderList = new ArrayList<>();
		while (rs1.next()) {
			SenderReceiverPozo sr = new SenderReceiverPozo();
			sr.setT_receiver(rs1.getString(1));
			sr.setF_sender(rs1.getString(2));
			senderList.add(sr);
		}
	%>
	<form action="LocationOtherAirport1Servlet" method="post">

		<table class="center">

			<tr>
				<td>
					<p align="left">To</p>
					<p align="left">
						Receiver: <select name="t_receiver">
							<%
								for (SenderReceiverPozo sr : senderList) {
							%>
							<option value=<%=sr.getT_receiver().replace(" ", "_")%>><%=sr.getT_receiver()%>
							</option>

							<%
								}
							%>

						</select>
					</p>


					<p align="left">
						Airport Name: <select name="t_airportname">
							<%
								for (LocationOtherAirport1Pozo l : locationList) {
							%>
							<option value=<%=l.getAirportname().replace(" ", "_")%>><%=l.getAirportname()%></option>
							<%
								}
							%>
						</select>

					</p>
					<p align="left">
						Airport Address: <select name="t_airportaddress">
							<%
								for (LocationOtherAirport1Pozo l : locationList) {
							%>
							<option value=<%=l.getAirportaddress().replace(" ", "_")%>><%=l.getAirportaddress()%></option>
							<%
								}
							%>
						</select>


					</p>
				</td>

				<td>
					<p align="left">From</p>
					<p align="left">
						Sender: <select name="f_sender">
							<%
								for (SenderReceiverPozo sr : senderList) {
							%>
							<option value=<%=sr.getF_sender().replace(" ", "_")%>><%=sr.getF_sender()%>
							</option>
							<%
								}
							%>

						</select>
					</p>



					<p align="left">
						Airport Name:<select name="f_airportname">
							<%
								for (LocationOtherAirport1Pozo l : locationList) {
							%>
							<option value=<%=l.getAirportname().replace(" ", "_")%>><%=l.getAirportname()%></option>
							<%
								}
							%>
						</select>
					</p>

					<p align="left">
						Airport Address:<select name="f_airportaddress">
							<%
								for (LocationOtherAirport1Pozo l : locationList) {
							%>
							<option value=<%=l.getAirportaddress().replace(" ", "_")%>><%=l.getAirportaddress()%></option>
							<%
								}
							%>
						</select>
					</p>
				</td>

			</tr>
		</table>


		<h3 align="center">
			<input type="submit" value="Go to next Page1">
		</h3>
	</form>

	<h3>
		<a href="ReceiptOtherAirport1.jsp"> Go to Next Page</a>
	</h3>


</body>
</html>