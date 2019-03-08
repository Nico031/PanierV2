package fr.afpa.panier.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.afpa.panier.dao.pojo.SousFamille;
import fr.afpa.panier.dao2.ConnectBDD;
import fr.afpa.panier.dao2.DAO;

/**
 * @author nico
 */
public class SousFamilleDAO implements DAO<SousFamille> {

	/* (non-Javadoc)
	 * @see modele.DAO#create(java.lang.Object)
	 */
	@Override
	public SousFamille create(SousFamille obj) {
		
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#delete(java.lang.Object)
	 */
	@Override
	public SousFamille delete(SousFamille obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#update(java.lang.Object)
	 */
	@Override
	public SousFamille update(SousFamille obj) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#find(int)
	 */
	@Override
	public SousFamille find(int id) {
		
		SousFamille ssFam = null;
		String requete = ("SELECT * FROM ss_famille WHERE id = " + id);
		
		try {
			
			Statement stmt = ConnectBDD.getConnect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//s'il y a un resultat, je cree l'objet fam avec les donnees trouvees
		    if(result.first()) {
		    	ssFam = new SousFamille(id, result.getString("intitulé"));
		    	System.out.println("sous_famille trouvee");
			}
		    // puis fermeture de la connexion
		    
		    stmt.close();
		    System.out.println("Fermeture connexion ssFam ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return ssFam;
	}

	/* (non-Javadoc)
	 * @see modele.DAO#findAll()
	 */
	@Override
	public List<SousFamille> findAll() {
		
		ArrayList <SousFamille> listeSousFam = new ArrayList<SousFamille>();
		
		String requete = "SELECT id FROM ss_famille ORDER BY id";
		
		try {
			
			Statement stmt = ConnectBDD.getConnect().createStatement();
		    // execution de la requete
			ResultSet result = stmt.executeQuery(requete);
			
			//tant que...
			while (result.next()) {
				listeSousFam.add(this.find(result.getInt("id")));
				
			}
		    // puis fermeture de la connexion
		    stmt.close();
		    System.out.println("Fermeture connexion ok");
		    	
		    } catch (SQLException e) {
		    	e.printStackTrace();
		    }
		return listeSousFam;
	}

}
