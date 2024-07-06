<%@page import="java.io.PrintWriter"%>
<%@page import="com.jsp.dto.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>All Students</title>
</head>
<style>
span{
	margin-right: 15px;
}
li{
	margin-bottom: 10px;
}
</style>
<%
@SuppressWarnings("unchecked")
List<Student> lOS = (List<Student>) session.getAttribute("lOS");
PrintWriter p = response.getWriter();
%>

<body>
	<div>
	<h1>List of all students</h1>
		<table border="1px" cellpadding = "5px" cellspacing = "5px" width="100%">
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Course</th>
				<th>Gender</th>
				<th>Branch</th>
				<th>DOB</th>
				<th>Address</th>
				<th>Ph No</th>
				<th>Relationship Status</th>
			</tr>
			<%
			for (Student s : lOS) {
				
			%>	
			<tr>
				<td><%=s.getId() %></td>
				<td><%=s.getName() %></td>
				<td><%=s.getEmail() %></td>
				<td><%=s.getCourse() %></td>
				<td><%=s.getGender() %></td>
				<td><%=s.getBranch() %></td>
				<td><%=s.getDob() %></td>
				<td><%=s.getAddress() %></td>
				<td><%=s.getMob() %></td>
				<td><%=s.getRelationshipStatus() %></td>
				<td><a href="deleteDetails?id=<%=s.getId()%>"><button>delete</button></a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>