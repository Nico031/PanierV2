<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Login</title>
	</head>
	
	<body>
		
		<h1>Accès au catalogue</h1>
		<h2>Veuillez vous identifier</h2>

		<!--  important: on indique le type de requete (post ou get) + l'url liée à la servlet qui va traiter l'envoi des données, sans le / -->
		<form method='POST' action='frontControler?cmd=Login'>
		
			<label for='ident'>Identifiant : </label>
			<input name='ident' type='text' id='ident' required autofocus/><br><br>

			<label for='mdp'>Mot de passe : </label>
			<input name='pass' type='password' id='mdp' required/><br><br> <%-- type='password' =>masque le mdp qd l'utilisateur le tape --%>
																									
			<input name='boutonValider' type='submit' value='Se connecter'>
			
			<a href='inscription'>Créer un compte</a>
			

		</form>
	</body>
</html>