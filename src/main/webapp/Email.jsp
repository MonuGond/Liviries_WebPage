<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%System.out.println("Mail Jsp run Successfully................."); %>

<form action="SendMailAttachServlet" method="post" enctype="multipart/form-data">
		<table>
		<caption><h2>Send an Email</h2></caption>
		<tr>
		<td width="50%">To : </td>
		<td> <input type="text" name="receipient" size="50"/> </td>
		</tr>
		<tr>
		<td>Subject</td>
		<td> <input type="text" name="subject" size="50"/> </td>
		</tr>
		<tr>
		<td>Content </td>
		<td> <textarea rows="10" cols="40" name="content"></textarea> </td>
		</tr>
		<tr>
		<td>Attach File </td>
		<td> <input type="file" name="file" size="50" multiple="multiple" required /> </td>
		</tr>
		<tr>
		<td colspan="2" align="center"> <input type="submit" value="Send"> </td>
		</tr>
		
		</table>
</form>

</body>
</html>