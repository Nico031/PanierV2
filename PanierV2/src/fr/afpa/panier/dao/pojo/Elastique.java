package fr.afpa.panier.dao.pojo;

/**
 * @author nico
 */
public class Elastique extends Produit {
	
	private int stock;

	private float prix;

	protected Couleur couleur;
	
	protected Produit produit;

	public Elastique(Produit prod, Couleur couleur, int stck, float f) {
		
		this.produit = prod;
		this.couleur = couleur;
		this.stock = stck;
		this.prix = f;
		

	}


	

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Couleur getCouleur() {
		return couleur;
	}

	public void setCouleur(Couleur couleur) {
		this.couleur = couleur;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	/**
	 * @return the hello
	 */
	public float getPrix() {
		return prix;
	}

	/**
	 * @param prix the prix to set
	 */
	public void setPrix(float prix) {
		this.prix = prix;
	}

	public String toString() {
		
		return  this.produit.getIntituleProduit() + " - " + this.couleur.getNomCouleur() + " - " + this.stock + " - " + this.prix;
				
	}

}
