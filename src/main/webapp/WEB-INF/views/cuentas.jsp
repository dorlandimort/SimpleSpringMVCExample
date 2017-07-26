<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" 
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<title>Cuentas</title>
</head>
<body>

	<div class="alert alert-success">
		<h1>Bienvenido ${ cuenta.persona.nombre }</h1>
	</div>
	
	<p>
	<a href="generar" target="_blank" class="btn btn-default btn-sm">Exportar datos</a>
	<a href="logout" class="btn btn-danger btn-sm">Cerrar sesión</a>
	</p>
	<table class="table table-striped table-hover table-bordered table-condensed">
		<thead>
			<tr>
				<th>Usuario</th>
				<th>Nombre</th>
				<th>Perfil</th>
			<tr>
		</thead>
		<tody>
		
		<c:forEach items="${cuentas}" var="cuenta">
			<tr>
				<td> ${cuenta.usuario }</td>
				<td> ${cuenta.persona.nombre }</td>
				<td> ${cuenta.perfil.nombre }</td>
			</tr>
		</c:forEach>
		</tody>
	</table>
	
	
</body>
</html>