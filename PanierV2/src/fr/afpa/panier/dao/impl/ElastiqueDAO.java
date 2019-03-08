package fr.afpa.panier.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.panier.dao.pojo.Elastique;
import fr.afpa.panier.dao.pojo.Famille;
import fr.afpa.panier.dao2.ConnectBDD;
import fr.afpa.panier.dao2.DAO;

public class ElastiqueDAO implements DAO<Elastique> {

	@Override
	public Elastique create(Elastique obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elastique delete(Elastique obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Elastique update(Elastique obj) {
		// TODO Auto-generated method stub
		return null;
	}

	public Elastique find(int id, int id2) {

		// declaration d'une variable de Elastique
		Elastique elastique = null;

		// requete emise
		String requete = ("SELECT * FROM stock WHERE id_produit = " + id + "AND id_couleur = " + id2);
		
		
		/*String requete = ("SELECT * FROM stock WHERE" +
														 "(id_produit IN SELECT id_produit FROM produit)" +
				       									 "WHERE" +
				                								"id_famille in(?)" +
				            									"AND id_sous_famille in(?)" + 
				            									"AND id_marque IN(?)" +
				        									")" +
				        									"AND id_couleur IN (?)" + 
				        									";");*/

		try {

			// connexion a la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			

			CouleurDAO couleurDAO = new CouleurDAO();
			ProduitDAO prodDAO = new ProduitDAO();
			// s'il y a un resultat, je cree l'objet elastique avec les donnees trouvees
			if (result.first()) {
				elastique = new Elastique(prodDAO.find(result.getInt("id_produit")), couleurDAO.find(result.getInt("id_couleur")), 
														result.getInt("stock"), result.getFloat("prix_catalogue"));
				System.out.println("objet elastique trouve");
			}

			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return elastique;

	}

	@Override
	public Elastique find(int id) {

		return null;
	}

	@Override
	public List<Elastique> findAll() {
		
		ArrayList<Elastique> listElastique = new ArrayList<Elastique>();

		String requete = "SELECT * FROM stock WHERE id_produit IN 	(SELECT id FROM produit WHERE " +
																							"id_famille 		IN (3,4) AND " +
																							"id_sous_famille 	IN (1,2) AND " +
																							"id_marque 			IN (1,2)" +
																	") AND " +
																	"id_couleur IN (75,76)"
																	;

		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que que le curseur peut aller à la ligne suivante de la table temp resultat du SELECT
			while (result.next()) {
				// j'ajoute dasn la listElastique, mon objet obtenu via le find d'elastique qui prend 2 param
				//listElastique.add(this.find(result.getInt("id"),result.getInt("id_couleur")));
				System.out.println(result.getInt("id_produit"));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listElastique;
	}
	
	public List<Elastique> finByCriteria(String fam, String ssFam, String marque, String couleur) {
		
		ArrayList<Elastique> listElastique = new ArrayList<Elastique>();

		String requete = "SELECT * FROM stock WHERE id_produit IN (SELECT id FROM produit WHERE " +
																							"id_famille 		IN (3,4) AND " +
																							"id_sous_famille 	IN (1,2) AND " +
																							"id_marque 			IN (1,2)" +
																	") AND " +
																	"id_couleur IN (75,76)"
																	;

		try {

			Statement stmt = ConnectBDD.getConnect().createStatement();
			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// tant que que le curseur peut aller à la ligne suivante de la table temp resultat du SELECT
			while (result.next()) {
				// j'ajoute dasn la listElastique, mon objet obtenu via le find d'elastique qui prend 2 param
				//listElastique.add(this.find(result.getInt("id"),result.getInt("id_couleur")));
				System.out.println(result.getInt("id_produit"));

			}
			// puis fermeture de la connexion
			stmt.close();
			System.out.println("Fermeture connexion ok");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return listElastique;
	}
	

}
