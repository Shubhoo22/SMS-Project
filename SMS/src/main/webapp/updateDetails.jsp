<%@page import="com.jsp.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%Student s = (Student) session.getAttribute("student"); %>
<h1>Update Your Details</h1>
	<form action="updateDetails">
		name: <input type=text name="name" value="<%=s.getName() %>"><br><br>
		email: <input type=email name="email" value="<%=s.getEmail() %>"><br><br> 
		password: <input type=password name="pass" value="<%=s.getPassword() %>"><br><br> 
		course: <input type=text name="course" value="<%=s.getCourse() %>"><br><br> 
		<%if(s.getGender().equals("male")){ %>
		gender: <input type=radio name="gender" value="male" checked>Male <input type=radio name="gender" value="female">Female <input type=radio name="gender" value="other">Other <br><br>
		<%}else if(s.getGender().equals("female")){ %>
		gender: <input type=radio name="gender" value="male">Male <input type=radio name="gender" value="female" checked>Female <input type=radio name="gender" value="other">Other <br><br>
		<%}else if(s.getGender().equals("other")){ %>
		gender: <input type=radio name="gender" value="male">Male <input type=radio name="gender" value="female">Female <input type=radio name="gender" value="other" checked>Other <br><br>
		<%}%>
		branch: <input type=text name="branch" value="<%=s.getBranch() %>"><br><br> 
		date of birth: <input type=date name="dob" value="<%=s.getDob() %>"> <br><br>
		address: <input type=text name="address" value="<%=s.getAddress() %>"> <br><br>
		mobile no: <input type="tel" name="mob" value="<%=s.getMob() %>"><br><br>
		relation status: <select name="relation" data-val = "<%=s.getRelationshipStatus() %>">
			<option value="single">Single</option>
			<option value="mingle">Mingle</option>
			<option value="married">Married</option>
		</select><br><br>
		<input type="submit" value="submit">
	</form>
	
	<script type="text/javascript">
		let selectVal = document.querySelector("select");
		let selectedValue = selectVal.dataset.val 
		let selectValChildren = [...selectVal.children] 
		
		selectValChildren.map((x)=>{
				if(x.value === selectedValue){
					x.setAttribute("selected","selected");
				}
		})
	</script>
</body>
</html>