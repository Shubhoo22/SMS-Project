<%@page import="com.jsp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display Info</title>
</head>
<% 
Student s = (Student)session.getAttribute("student"); 
if(s!=null) {
	
%>
<body>
	<div>
		<h1>Hello <%= s.getName()%>, here is your details</h1>
		
		<table border="1px" cellpadding="5px" cellspacing="5px">
			<tr><th>Name: </th><td><%= s.getName()%></td></tr>
			<tr><th>Email: </th><td><%= s.getEmail()%></td></tr>
			<tr><th>Course: </th><td><%= s.getCourse()%></td></tr>
			<tr><th>Gender: </th><td><%= s.getGender()%></td></tr>
			<tr><th>Branch: </th><td><%= s.getBranch()%></td></tr>
			<tr><th>DoB: </th><td><%= s.getDob()%></td></tr>
			<tr><th>Address: </th><td><%= s.getAddress()%></td></tr>
			<tr><th>MobIle no: </th><td><%= s.getMob()%></td></tr>
			<tr><th>Relation: </th><td><%= s.getRelationshipStatus()%></td></tr>
			<td><a href="fetchForUpdate?id=<%=s.getId()%>"><button>update</button></a></td>
			<td><a href="logout"><button>Logout</button></a></td>
		</table>
	</div>

</body>

<%}else{
	response.getWriter().print("<h1>login first</h1>");
	request.getRequestDispatcher("login.jsp").include(request, response);
}%>
</html>