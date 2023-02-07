<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="model.Curso,java.util.List"%>
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
		<h1>Tabla de cursos</h1>
		<%List<Curso> cursos=(List<Curso>)request.getAttribute("cursos"); %>
		<table class="table table-striped table-bordered">
			<tr><th>Nombre</th><th>Precio</th><th>Duración</th><th>Fecha inicio</th></tr>
	
			<%for(Curso c:cursos){ %>
				<tr>
					<td><%=c.getNombre()%></td>
					<td><%=c.getPrecio()%></td>
					<td><%=c.getDuracion()%></td>
					<td><%=c.getFechaInicio()%></td>
				</tr>
			<%} %>
		</table>
		<br><br>
		<a href="datos.html">Volver</a>
	</div>
</body>
</html>