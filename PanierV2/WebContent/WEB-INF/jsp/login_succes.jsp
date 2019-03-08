<%@page import="fr.afpa.panier.beans.BlocFiltre"%>
<%@page import="fr.afpa.panier.beans.LigneFiltre"%>
<%@page import="fr.afpa.panier.dao.pojo.Client"%>
<%@page import="java.util.ArrayList"%>
<%@page import="fr.afpa.panier.commun.IConstantes"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>



<!--mon objet client récupère les données client envoyé depuis le controleur-->
<%
	Client client = (Client) request.getSession().getAttribute("client");
%>



<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<link rel='stylesheet' href='catalogue.css'>
<title>Catalogue</title>
</head>

<body>

	<header>
		<p>
			Connexion réussie. Bonjour <%=client.getIdentifiant()%> !
			
		</p>
		<h1>ElastiCity</h1>
	</header>

	<main>

	<section id='filtres'>

		<form method='post' action='frontControler?cmd=CheckboxChecked'>

			<legend>Filtres</legend>

			<fieldset id='filtre'>
				<%
					// on affiche la liste des filtres dans des checkbox
					//récupération de la liste depuis la servlet
					ArrayList<BlocFiltre> listeBlocFiltre = (ArrayList<BlocFiltre>) request.getSession()
							.getAttribute(IConstantes.CLEF_LISTE_FILTRE);
	
				
				if (listeBlocFiltre != null) {
			
				%>		
				<% 		// pour chaque elt de la listeBlocflitre quo'n palce dans une var blocFilter de type BlocFiltre => afficher titre du bloc + sa liste de lignes
						for (BlocFiltre blocFiltre : listeBlocFiltre) {
				%>
					
							<p><%=blocFiltre.getLibelle()%></p>
							
			<%
					//pour chaque ligne de la liste de lignes => afficher les lignes dans chaque bloc comme checkbox
							for (LigneFiltre ligneFiltre : blocFiltre.getListLigneFiltre()) {										
				%>
									
								<input type='checkbox' id='<%=ligneFiltre.getId()%>'
								name='<%=blocFiltre.getLibelle()%>'
								value='<%=ligneFiltre.getId()%>' <%=ligneFiltre.getValueChecked()%> />

								<label for='<%=ligneFiltre.getId()%>'><%=ligneFiltre.getIntitule()%></label><br>
					
				<%
			
							}
				%>
				<hr>
				<%
						}
				
					}
				%>

			</fieldset>

			<fieldset id='boutonRechercher'>
				<input type='submit' name='boutonRechercher' value='Rechercher'>
			</fieldset>

		</form>

	</section>

	<section id='catalogue'>

		<legend>Catalogue</legend>

		<%
			if (listeBlocFiltre != null) {

				// affichage de la liste selectionnée
				for (BlocFiltre blocFiltre : listeBlocFiltre) {
		%>

				<h4><%=blocFiltre.getLibelle()%></h4>
		<%
					for (LigneFiltre ligneFiltre : blocFiltre.getListLigneFiltre()) {

						if (ligneFiltre.isChecked()) {
		%>
							<p><%=ligneFiltre.getIntitule()%></p>
		<%
						}
					}
				}
			}
		%>

	</section>

	<section id='panier'>
		<legend>Panier</legend>
	</section>

	</main>


	<footer>
		<p>Copyright (c) Copyright ElastiCity</p>
	</footer>

</body>

</html>