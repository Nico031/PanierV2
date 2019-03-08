package fr.afpa.panier.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.panier.dao.pojo.Couleur;
import fr.afpa.panier.dao2.ConnectBDD;
import fr.afpa.panier.dao2.DAO;



public class CouleurDAO implements DAO<Couleur> {

	@Override
	public Couleur create(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur delete(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur update(Couleur obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Couleur find(int id) {

		Couleur couleur = null;
		String requete = ("SELECT * FROM couleur WHERE id = " + id);

		try {

			// connexion � la bdd
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet couleur avec les donnees trouvees
			if (result.first()) {
				couleur = new Couleur(id, result.getString("nom_couleur"));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return couleur;

	}

	@Override
	public List<Couleur> findAll() {

		ArrayList<Couleur> listeCouleur = new ArrayList<Couleur>();

		String requete = "SELECT id FROM couleur ORDER BY id";

		try {

			// connexion � la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement();

			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que...
			while (result.next()) {
				listeCouleur.add(this.find(result.getInt("id")));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listeCouleur;

	}

}