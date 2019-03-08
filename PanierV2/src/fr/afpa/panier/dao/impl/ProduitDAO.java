package fr.afpa.panier.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.afpa.panier.dao.pojo.Produit;
import fr.afpa.panier.dao2.ConnectBDD;
import fr.afpa.panier.dao2.DAO;

/**
 * @author nico
 */
public class ProduitDAO implements DAO<Produit> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public Produit create(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public Produit delete(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public Produit update(Produit obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.DAO#find(int)
	 */
	@Override
	public Produit find(int id) {

		Produit prod = null;

		// reuete emise
		String requete = "SELECT * FROM PRODUIT WHERE ID =" + id;

		try {
			// connexion � la BDD
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);

			// execution de la requete
			ResultSet result = stmt.executeQuery(requete);

			// s'il y a un resultat, je cree l'objet produit avec les donnees trouvees
			if (result.first()) {

				FamilleDAO famDAO = new FamilleDAO();
				SousFamilleDAO ssFamDAO = new SousFamilleDAO();
				MarqueDAO marqueDAO = new MarqueDAO();

				prod = new Produit(id, result.getString("intitule_elastique"), famDAO.find(result.getInt("id_famille")),
						ssFamDAO.find(result.getInt("id_sous_famille")), marqueDAO.find(result.getInt("id_marque")));

				System.out.println("produit trouve");
			}

			stmt.close();
			System.out.println("connexion produit fermee");

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return prod;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<Produit> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
