package fr.afpa.panier.dao2;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * ConnectBDD est la classe qui a pour role de cherger le driver, etablir la connexion � la BDD, mettre � disposition 
 * la connexion au d�veloppeur, et fermer la connexion
 * 
 * @author nico
 */
public class ConnectBDD {
	
	/**
	 * attribut connect de la classe Connexion qu'on va utiliser pour la connexion et l'identification entre la couche m�tier et la BDD
	 */
	private static Connection connect = null;
	   
	/**
	 * Constructeur
	 */
	 public ConnectBDD(){
	 }
	
	
	/**
	 * Getter pour utiliser l'objet ailleurs car attribut d�fint comme private
	 * @return connect
	 */
	public static Connection getConnect() {
		 // configuration du driver selon le SGBD
		 String driver="oracle.jdbc.driver.OracleDriver";
		 
		 // configuration de la connexion (toujours de type protocole: sous-protocole: nom)
	     String url = "jdbc:oracle:thin:@localhost:1521/xe";
	     String user = "AdminApp";
	     String psswd = "AdminApp";
		try {
	    	 // chargement du pilote qui construit un pont entre couche m�tier et la BDD
	    	 Class.forName(driver);
	    	 System.out.println("Driver ok");
	    	 
	    	 // instruction pour donner l'autorisation d'acc�s � la BDD
	         connect = DriverManager.getConnection(url, user, psswd);
	         System.out.println("Connexion ok");
	         
	     } catch (ClassNotFoundException e) {	// declenchee en cas d'echec de chargement du driver
	    	 e.printStackTrace();
	    	 
	     } catch (SQLException e) {		// declenchee en cas d'echec de la connexion
	         e.printStackTrace();
	     } 
		
		return connect;
	}
	
	/**
	 * methode pour fermer la connexion
	 */
	public void closeConnexion() {
		
		try {
		connect.close();
		
		} catch (SQLException e){
			e.printStackTrace();
			
		}
	}	 

}
