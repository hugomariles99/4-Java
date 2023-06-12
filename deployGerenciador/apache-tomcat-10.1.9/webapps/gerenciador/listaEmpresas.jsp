<%@page import="com.alura.gerenciador.servlet.Empresa"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${not empty empresa }">
		Empresa ${empresa} registrada! <br>
	</c:if>

	Lista de empresas:
	<br>

	<ul>
		<c:forEach items="${ empresas }" var="empresa">
			<li>
				${ empresa.nombre }-<fmt:formatDate value="${ empresa.fechaAbertura }" pattern="dd/MM/yyyy" />
				<a href="/gerenciador/mostrarEmpresa?id=${ empresa.id }">Modificar</a>
				<a href="/gerenciador/eliminarEmpresa?id=${ empresa.id }">Eliminar</a>
			</li>
		</c:forEach>
	</ul>

</body>
</html>