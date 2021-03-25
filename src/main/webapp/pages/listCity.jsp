<%@ page language = "java" contentType ="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All cities</title>
</head>
<body>
<h2>All cities</h2>
<p>${message}</p>
	<table>
		<thead>
			<tr>
			<td>id</td>
				<td>Naziv</td>
				<td>Postanski broj</td>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach items = "${listCity}" var = "element" varStatus = "loop" >
				<tr>
				<td>${loop.index}</td>
				<td>${element.name}</td>
				<td>${element.postalCode}</td>
					
					<c:url value ="/addCity?name=delete" var = "urlDelete">
					<c:param name ="index" value = "${loop.index}"></c:param>
					
					</c:url>
					<c:url value ="/addCity?name=show" var = "urlShowOne">
					<c:param name ="index" value = "${loop.index}"></c:param>
					
					</c:url>
					
					<c:url value ="/addCity?name=update" var = "urlUpdate">
					<c:param name ="index" value = "${loop.index}"></c:param>
					
					</c:url>
					
					<td>
					<a href = "${urlDelete}">delete</a href></td>
					<td><a href = "${urlShowOne}">show</a href></td>
					<td><a href = "${urlUpdate}">update</a href></td>
					

				</tr>

			</c:forEach>


		</tbody>
	</table>

</body>
</html>