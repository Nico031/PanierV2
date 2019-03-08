package fr.afpa.panier.dao.pojo;

/**
 * @author nico
 */
public class Marque {
	
	private int id;
	
	private String nomMarque;
	
	/**
	 * Constructeur sans parametre
	 */
	public Marque() {
		
	}
	
	/**
	 * Constructeur avec le nom de la amrque
	 */
	public Marque(String marque) {
		this.nomMarque=marque;
		
	}
	
	/**
	 * Constructeur avec id + nom de la marque
	 */
	public Marque(int id, String marque) {
		this.id=id;
		this.nomMarque=marque;
		
	}

	/**
	 * @return the hello
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the hello
	 */
	public String getNomMarque() {
		return nomMarque;
	}

	/**
	 * @param nomMarque the nomMarque to set
	 */
	public void setNomMarque(String nomMarque) {
		this.nomMarque = nomMarque;
	}
	
	public String toString() {
		return this.id + " - " + this.nomMarque + " - ";
	}
}
