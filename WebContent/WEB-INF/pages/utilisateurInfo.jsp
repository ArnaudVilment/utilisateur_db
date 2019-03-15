<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Information de l'utilisateur</title>
<link rel="stylesheet" href="ressources/css/utilisateurInfo.css"/>
</head>
<body>
	<div id="conteneur">		
		<div id="intitule">
				<p>${ utilisateur.nom }</p>
				<p>${ utilisateur.prenom }</p>
		</div>
		<div id="photo">				
				<img src= ${ utilisateur.photo }>	
		</div>		
		<div id="infos">								
				<a href="https://www.google.com/intl/fr/gmail/about/#">${ utilisateur.email }</a>
				<p>Adresse : ${ utilisateur.adresse }</p>					
		</div>				
	</div>					
</body>
</html>