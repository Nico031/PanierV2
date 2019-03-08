package fr.afpa.panier.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.panier.dao.pojo.Marque;
import fr.afpa.panier.dao2.ConnectBDD;
import fr.afpa.panier.dao2.DAO;

/**
 * @author nico
 */
public class MarqueDAO implements DAO<Marque> {

	/* (non-Javadoc)
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public Marque create(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public Marque delete(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public Marque update(Marque obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#find(int)
	 */
	@Override
	public Marque find(int id) {
		
		Marque marque = null;
		String requete = ("SELECT * FROM marque WHERE id = " + id);
		
		try {
			
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	marque = new Marque(id, result.getString("marque"));
		    	System.out.println("marque trouvee");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion marque ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return marque;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<Marque> findAll() {
		
		ArrayList <Marque> listeMarque = new ArrayList<Marque>();
		
		String requete = "SELECT id FROM marque ORDER BY id";
		
		try {
			
			Statement stmt = ConnectBDD.getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//tant que...
			while (result.next()) {
				listeMarque.add(this.find(result.getInt("id")));
				
			}
		    // puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion marque ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeMarque;
	}

}
