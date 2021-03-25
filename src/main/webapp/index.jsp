<%@ page language = "java" contentType ="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<title>Login</title>
<style>
input {
display:block;
margin: 5px;
}
input[type ="submit"]{
margin:10px;
}

</style>
<body>
<div>
		<form name="form" method="post" action="navigation">
			
			<label for="email">E-mail:</label>
			<input type="text" id="email" name="email" placeholder="Enter E-mail" />
			
			<label for="password">Password:</label>
			<input type="password" id="password" name="password" placeholder="Enter Password" />
			<p>${message}</p>
			<input type="submit" value="login" name="button" />
		</form>
	</div>

</body>
</html>
