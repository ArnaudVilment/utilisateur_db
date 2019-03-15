<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des Utilisateurs</title>
<link rel="stylesheet" href="ressources/css/utilisateurs.css" />
</head>
<body>
	<c:import url="inc/menu.jsp" ></c:import>
	<h1>Les Utilisateurs</h1>

	<div id=conteneur>
		<c:forEach items="${ utilisateurs }" var="utilisateur">
			<div class=blockPhoto>
				<a href="utilisateurInfo?id=${ utilisateur.id }"><img src="${ utilisateur.photo }" /></a>
				<div>${ utilisateur.nom } ${ utilisateur.prenom }
				<a href="supUtilisateur?id=${ utilisateur.id }"><img class="icon" src="ressources/images/icone_sup.jpg"/></a>
				<a href="modUtilisateur?id=${ utilisateur.id }"><img class="icon" src="ressources/images/icone_mod2.jpg"/></a>
				</div>
			</div>
		</c:forEach>
	</div>

</body>
</html>