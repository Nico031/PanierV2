package fr.afpa.panier.dao.impl;


import fr.afpa.panier.dao.impl.FamilleDAO;
import fr.afpa.panier.dao.pojo.Elastique;


/**
 * @author nico
 */
public class TestDAO {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		/*FamilleDAO famDAO = new FamilleDAO();
		System.out.println(famDAO.find(1));
		System.out.println(famDAO.findAll());*/
		
		 

		
		  //ProduitDAO prodDAO = new ProduitDAO(); System.out.println(prodDAO.find(5));
		 
		 ElastiqueDAO elastDAO=new ElastiqueDAO();
		 //System.out.println(elastDAO.find(5, 2));
		 
		 System.out.println(elastDAO.findAll());
		 
	
		  
		//CouleurDAO coulDAO = new CouleurDAO();
		//System.out.println(coulDAO.find(24));

	}

}
