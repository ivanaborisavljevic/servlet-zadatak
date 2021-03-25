<%@ page language = "java" contentType ="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add city</title>
</head>
<body>
<h2>Unos grada</h2>
<form action="addCity" method="post">
		<table>
			<tr>
				<td>Ime:</td>
				<td><input type="text" id="name" name="name" value ="${city.name}"></td>
				<td>Postanski broj:</td>
				<td><input type="text" id="postalCode" name="postalCode" value ="${city.postalCode}"></td>
			</tr>
			<tr>	
			<td><input type="submit" name="button" value="addCity"></td>
			<td><input type="submit" name="button" value="close""></td>
			</tr>

		</table>
	</form>
</body>
</html>