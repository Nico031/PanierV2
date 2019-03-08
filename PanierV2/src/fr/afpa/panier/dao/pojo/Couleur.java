package fr.afpa.panier.dao.pojo;

/**
 * @author nico
 */
public class Couleur {
	
	private int idCouleur;
	
	private String nomCouleur;
	
	
	public Couleur() {
	
	}
	
	public Couleur(String couleur) {
		this.nomCouleur=couleur;
	}
	
	public Couleur(int id, String couleur) {
		this.idCouleur=id;
		this.nomCouleur=couleur;
	}

	/**
	 * @return the hello
	 */
	public int getIdCouleur() {
		return idCouleur;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.idCouleur = id;
	}

	/**
	 * @return the hello
	 */
	public String getNomCouleur() {
		return nomCouleur;
	}

	/**
	 * @param nomCouleur the nomCouleur to set
	 */
	public void setNomCouleur(String nomCouleur) {
		this.nomCouleur = nomCouleur;
	}
	
	public String toString() {
		return this.idCouleur + " - " + this.nomCouleur + " - ";
	}

}
