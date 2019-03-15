<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Pizzas</title>
<link rel="stylesheet" href="ressources/css/listPizza.css" />
</head>
<body>
	<c:import url="inc/menu.jsp" ></c:import>
	<h1>Les des Pizzas</h1>

	<div id=conteneur>
		<c:forEach items="${ pizzas }" var="pizza">
			<div class=blockPhoto>
				<div>${ pizza.libelle }</div>
				<a href="utilisateurInfo?id=${ pizza.id }"><img src="${ pizza.urlImage }" /></a>
				<div>${ pizza.description }
				<a href="supPizza?id=${ pizza.id }"><img class="icon" src="ressources/images/icone_sup.jpg"/></a>
				<a href="modPizza?id=${ pizza.id }"><img class="icon" src="ressources/images/icone_mod2.jpg"/></a>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>