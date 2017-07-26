<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Login</title>

</head>
<body>
<div class="row"></div>
		<div class="col-lg-4 col-md4 col-sm-4 col-md-offset-4">
		<c:if test="${ mensaje != null}">  
			<div class="alert alert-danger">
				${mensaje }
			</div>
		</c:if>
		
		
			<form method="post" action="login" class="center">
				<div class="form-group">
					<label for="usuario">Usuario:</label>
					<input type="text" id="usuario" name="usuario" class="form-control">
				</div>
				<div class="form-group">
					<label for="contrasena">Password:</label>
					<input type="password" id="contrasena" name="password" class="form-control">
				</div>
				<div class="form-group col-md4 col-sm-4 col-md-offset-4">
					<input type="submit" value="Entrar" class="btn btn-default">
				</div>
				
			</form>
		</div>
</body>
</html>