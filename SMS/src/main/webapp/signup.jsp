<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>SignUp</h1>
	<form action="register">
		name: <input type=text name="name"><br><br>
		email: <input type=email name="email"><br><br> 
		password: <input type=password name="pass"><br><br> 
		course: <input type=text name="course"><br><br> 
		gender: <input type=radio name="gender" value="male">Male <input type=radio name="gender" value="female">Female <input type=radio name="gender" value="other">Other <br><br> 
		branch: <input type=text name="branch"><br><br> 
		date of birth: <input type=date name="dob"> <br><br>
		address: <input type=text name="address"> <br><br>
		mobile no: <input type="tel" name="mob"><br><br>
		relation status: <select name="relation">
			<option value="single" selected="selected">Single</option>
			<option value="mingle">Mingle</option>
			<option value="married">Married</option>
		</select><br><br>
		<input type="submit" value="SignUp">
		<input type="reset" value="Cancel">
	</form>
</body>
</html>