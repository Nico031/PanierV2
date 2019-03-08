<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Formulaire d'inscription</title>
		<link rel="stylesheet" href="inscription.css">
	</head>
	
	<body>
		<form action="" method="post">
		
			<fieldset>
				<legend>Votre identité</legend>
				
				<div>
					<label for="nom">Nom</label>
					<input type="text" name="prénom et nom" id="nom" placeholder="Prénom et nom" required autofocus><br><br>	<!--requiered = saisi obligatoire sinon pas de validaiton. autofocus = le curseur se met dasn le champs à l'ouverture de lapage-->
				</div>
				<div>
					<label for="mail">Email</label>
					<input type="email" name="mail" id="mail" placeholder="exemple@domaine.com" required><br><br>
				</div>
				<div>
					<label for="tel">Téléphone</label>
					<input type="number" name="number" id="tel" placeholder="par ex : +33755000000" required><br><br>
				</div>
			</fieldset>
		
			<fieldset>
				<legend>Adresse</legend>
		
				<div>
					<label for="adresse">Adresse</label>
					<textarea name="adresse" id="adresse"></textarea><br><br>
				</div>
				<div>
					<label for="cp">Code postal</label>
					<input type="text" name="cp" id="cp" required><br><br>
				</div>
				<div>
					<label for="pays">Pays</label>
					<input type="text" name="pays" id="pays" required><br><br>
				</div>
			</fieldset>
			
			<fieldset>
				<input type="button" value="Valider">
				
				<a href="login">Annuler</a>
				
			</fieldset>
		</form>
	</body>
</html>