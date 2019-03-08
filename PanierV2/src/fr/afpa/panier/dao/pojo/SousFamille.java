package fr.afpa.panier.dao.pojo;

/**
 * @author nico
 */
public class SousFamille {
	
	private int id;
	
	private String intitule_ssFamille;
	
	
	/**
	 * Constructeur sans param�tre
	 */
	
	public SousFamille() {
	
	}
	
	/**
	 * Constructeur avec l'intitule
	 */
	
	public SousFamille(String ssFam) {
		this.intitule_ssFamille = ssFam;
	
	}
	
	/**
	 * Constructeur avec id + intitule
	 */
	
	public SousFamille(int id, String ssFam) {
		this.id=id;
		this.intitule_ssFamille = ssFam;
	
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
	public String getIntitule_ssFamille() {
		return intitule_ssFamille;
	}

	/**
	 * @param intitule_ssFamille the intitule_ssFamille to set
	 */
	public void setIntitule_ssFamille(String intitule_ssFamille) {
		this.intitule_ssFamille = intitule_ssFamille;
	}
	
	public String toString() {
		return this.id + " - " + this.intitule_ssFamille + " - ";
		
	}

}
