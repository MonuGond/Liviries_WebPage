<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@page import="gentsUniform.*" %>
    
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
</style>
</head>
<body>

<%
		GentsUniformPozo p = (GentsUniformPozo) request.getAttribute("GentsUniformPozo");
		String date=request.getAttribute("date").toString();
		String serialno = request.getParameter("serialno");
		System.out.println(p);
%>

	<div style="display: flex; justify-content: center;">
		<img src="Screenshot (2).png" style="width: 150px; height: 100px;" />
	</div>
	<h5>O/O THE RED(ER)#UNIFORM MATERIALS FOR MALE OFFICIAL(FOR 3
		YEARS)</h5>
<a href="Home.html"> Home</a>

	<table>
		<tr>
			<td>Book.No.</td>
			<td><%=p.getBookno()%></td>
			<td>Page No.</td>
			<td><%=p.getPgno()%></td>
			<td>C/Size</td>
			<td><%=p.getG_u_size()%></td>
		</tr>
		<tr>
			<td>EMP.No.</td>
			<td><%=p.getEmpno()%></td>
			<td>NAME</td>
			<td><%=p.getEname()%></td>
			<td>DESIGNATION</td>
			<td><%=p.getDesignation()%></td>
		</tr>
		<tr>
			<td>Date :</td>
			<td><%=date%></td>
			<td>Serial No.</td>
			<td><%=p.getSerialno()%> </td>
		</tr>

	</table>

	<table border="1">
		<tr>
			<th>Sl.No.</th>
			<th>Types Of Cloth</th>
			<th>Cloth Meters</th>
			<th>Cloth Pcs</th>
			<th>Total(Mtrs)</th>
			
		</tr>

		<!--  -->

		<tr>
			<th>1.</th>
			<th>Shirting Cloth</th>
			<td><%=p.getShirting_cloth_mtrs()%></td>
			<td><%=p.getShirting_cloth_pcs()%></td>
			<td><%=p.getShirting_cloth_qnt()%></td>


		</tr>

		<tr>
			<th>2.</th>
			<th>Pant Cloth</th>
			<td><%=p.getPaint_cloth_mtrs()%></td>
			<td><%=p.getPaint_cloth_pcs()%></td>
			<td><%=p.getPaint_cloth_qtn()%></td>

		</tr>

		<tr>
			<th>3.</th>
			<th>Suit Cloth</th>
			<td><%=p.getSuit_cloth_mtrs()%></td>
			<td><%=p.getSuit_cloth_pcs()%></td>
			<td><%=p.getSuit_cloth_qtn()%></td>

		</tr>

		<tr>
			<th>4.</th>
			<th>PullOver(Jersey)</th>
			<td></td>
			<td><%=p.getPullover()%></td>
			<td><%=p.getTotal_p_o_qtny()%></td>

		</tr>
		<tr>
			<th>5.</th>
			<th>Half Sleeve Gents Cardigan</th>
			<td></td>
			<td><%=p.getH_s_cardigan()%></td>
			<td><%=p.getTotal_h_s_g_c_qtny()%></td>

		</tr>

		<tr>
			<th>6.</th>
			<th>Nos. of Neck Ties</th>
			<td></td>
			<td><%=p.getNeck_tie_pcs()%></td>
			<td><%=p.getNeck_tie_qtn()%></td>

		</tr>
		<tr>
			<th>7.</th>
			<th>Ladies Scarves(opt.male uniform)</th>
			<td></td>
			<td><%=p.getScarves_pcs()%></td>
			<td><%=p.getScarves_qtn()%></td>

		</tr>
		<tr>
			<th>8.</th>
			<th>Fire PullOver</th>
			<td></td>
			<td><%=p.getF_p_over()%></td>
			<td><%=p.getTotal_f_p_o_qtny() %></td>

		</tr>


	</table>
	 <form action="GentsUniformPdfServlet" method="post"
		style="align-self: center;">
		<h3 align="center">
		<input name="serialno" id="serialno" value=<%=p.getSerialno()%>
			readonly="readonly"> <input type="submit" value="View Pdf"
			name="btnview"></h3>
	</form>
	<!-- <form action="GentsUniformPdfServlet" method="post"
		style="align-self: center;">
		<h3 align="center">
		<input type="submit" value="View Pdf"
			name="btnview"></h3>
	</form> -->
	<h3 align="center">
		<a href="Email.jsp">Send Email </a>
	</h3>




</body>
</html>