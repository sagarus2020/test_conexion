<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>aplicacion gestion de usuarios</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">Gesti�n de Usuarios</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Usuarios</a></li>
			</ul>
		</nav>
	</header>
	<br />
	<div class="row">
		<div class="contaier">
			<h3 class="text-center">Listado de Usuarios</h3>
			<hr>
			<div class="container text-left">
				<a href="<%=request.getContextPath()%>/new" class="btn btn-success">Agregar
					Nuevo Usuario</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Email</th>
						<th>Pais</th>
						<th>Acciones</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="usuario" items="${listUsuarios}">
						<tr>
							<td><c:out value="${usuario.id}" /></td>
							<td><c:out value="${usuario.nombre}" /></td>
							<td><c:out value="${usuario.email}" /></td>
							<td><c:out value="${usuario.pais}" /></td>
							<td><a href="edit?id=<c:out value='${usuario.id}'/>">Editar</a>&nbsp;&nbsp;&nbsp;&nbsp;<a
								href="delete?id=<c:out value='${usuario.id}'/>">eliminar</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>