<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0"
	crossorigin="anonymous">
</head>
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-md navbar-dark"
			style="background-color: tomato">
			<div>
				<a href="#" class="navbar-brand">Gestión de Usuarios</a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/list"
					class="nav-link">Usuarios</a></li>
			</ul>
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${usuario != null}">
					<form action="update" method="post">

				</c:if>
				<c:if test="${usuario == null}">
					<form action="insert" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${usuario != null}">
						Editar Usuario
						</c:if>
						<c:if test="${usuario == null}">
						Agregar nuevo usuario
						</c:if>
					</h2>
				</caption>
				<c:if test="${usuario != null}">
					<input type="hidden" name="id"
						value="<c:out value='${usuario.id}'/>"/>
				</c:if>
				<fieldset class="form-group">
					<label>nombre de usuario</label> <input type="text"
						value="<c:out value='${usuario.nombre}'/>" class="form-control"
						name="nombre" required="required" />
				</fieldset>
				<fieldset class="form-group">
					<label>email de usuario</label> <input type="text"
						value="<c:out value='${usuario.email}'/>" class="form-control"
						name="email" />
				</fieldset>
				<fieldset class="form-group">
					<label>pais de usuario</label> <input type="text"
						value="<c:out value='${usuario.pais}'/>" class="form-control"
						name="pais" />
				</fieldset>
				<button type="submit" class="btn btn-success">Guardar</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>