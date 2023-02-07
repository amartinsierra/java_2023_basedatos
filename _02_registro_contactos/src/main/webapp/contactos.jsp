<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Contacto,java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> 
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>Tabla de contactos</h1>
		<%List<Contacto> contactos=(List<Contacto>)request.getAttribute("contactos"); %>
		<table class="table table-striped table-bordered">
			<tr><th>Nombre</th><th>Email</th><th>Edad</th></tr>
			<!-- Recorro la lista de contactos y generamos una fila en la tabla por cada contacto -->
			<%for(Contacto c:contactos){ %>
				<tr>
					<td><%=c.getNombre()%></td>
					<td><%=c.getEmail()%></td>
					<td><%=c.getEdad()%></td>
				</tr>
			<%} %>
		</table>
		<br><br>
		<a href="inicio.html">Volver</a>
	</div>
</body>
</html>