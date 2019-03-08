package fr.afpa.panier.dao.pojo;

/**
 * @author nico
 */
public class Famille {
	
	int		id;
	String 	intitule;
	
	/**
	 * Constructeur sans param�tre
	 */
	public Famille() {	
	}
	
	/**
	 * Constructeur qui cree l'objet en lui attribuant un nom
	 * @param nomFamille
	 */
	public Famille(String nomFamille) {
		this.intitule = nomFamille;
	}
	
	/**
	 * Constructeur avec tous les attributs comme parametre
	 * @param id, nomFamille
	 */
	public Famille(int id, String nomFamille) {
		this.id = id;
		this.intitule = nomFamille;
	}

	/**
	 * @return id
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
	 * @return intitule
	 */
	public String getIntitule() {
		return intitule;
	}

	/**
	 * @param intitule the intitule to set
	 */
	public void setIntitule(String intitule) {
		this.intitule = intitule;
	}
	
	public String toString() {
		return this.id + " - " + this.intitule + " - " ;
	}
}
