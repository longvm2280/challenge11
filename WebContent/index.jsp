<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="TestServlet">
		<table>
			<tr>
				<td style="text-align:left;">Username:</td>
				<td><input type="text" name="username"></td>
			<tr>
			<tr>
				<td style="text-align:left;">Email:</td>
				<td><input type="text" name="email"></td>
			<tr>
			<tr>
				<td style="text-align:left;">Date of birth:</td>
				<td><input type="text" name="dob"></td>
			<tr>
			<tr>
				<td style="text-align:left;">Gender:</td>
				<td><input type="text" name="gender"></td>
			<tr>
		</table>
	  	<button type="submit" name="submit" value="serialize">Serialize</button>
	</form><br>
	Base-64 (Serialized):
	<form method="post" action="TestServlet_Fixed">
		<textarea rows="5" cols="50" name="serialized">${serialized}</textarea><br>
		<button type="submit" name="submit" value="deserialize">Deserialize</button>
	</form><br>
	Deserialized:
	<table>
		<tr>
			<td style="text-align: left;">Username:</td>
			<td>${deserialized.username}</td>
		<tr>
		<tr>
			<td style="text-align: left;">Email:</td>
			<td>${deserialized.email}</td>
		<tr>
		<tr>
			<td style="text-align: left;">Date of birth:</td>
			<td>${deserialized.dob}</td>
		<tr>
		<tr>
			<td style="text-align: left;">Gender:</td>
			<td>${deserialized.gender}</td>
		<tr>
	</table>
</body>
</html>