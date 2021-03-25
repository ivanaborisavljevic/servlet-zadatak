<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<style>
input {
margin: 5px;
}
</style>
</head>
<body>
<form action="${pageContext.request.contextPath}/navigation" method="post">
		<table>
			<tr>
				<td>Grad</td>
				</tr>
				<tr>
<td><input type="submit" name="button" value="addCity"></td>
<td><input type="submit" name="button" value="updateCity"></td>
<td><input type="submit" name="button" value="showAllCity"></td>
<td><input type="submit" name="button" value="showCity"></td>
<td><input type="submit" name="button" value="deleteCity"></td>


			</tr>

<tr>
				<td>Proizvodjac</td>
				</tr>
				<tr>
<td><input type="submit" name="button" value="addManufacturer"></td>
<td><input type="submit" name="button" value="showAllManufacturer"></td>


			</tr>

<tr>
				<td>Proizvod</td>
				</tr>
				<tr>
<td><input type="submit" name="button" value="addProduct"></td>
<td><input type="submit" name="button" value="showAllProduct"></td>


			</tr>
		
		</table>
	</form>
</body>
</html>