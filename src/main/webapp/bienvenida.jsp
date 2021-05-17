<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>email</title>

</head>
<body>
<jsp:useBean id="persona" class="co.edu.ufps.mvcjsp.beans.Persona" scope="request"/>

<h1 style="color:Red">Tu email: <jsp:getProperty name="persona" property="email"/></h1>
<h1 style="color:Blue">Tu nombre: <jsp:getProperty name="persona" property="nombre"/></h1>
<% String email = request.getParameter("email"); 
String nombre = request.getParameter("nombre"); 
%>
 <h1 style="color:Red">tu email: <%= email %></h1>
<h1 style="color:Blue"> tu nombre: <%= nombre %></h1>
</body>
</html>