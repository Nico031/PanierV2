package fr.afpa.panier.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BlocFiltre implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Attributs
	 */
	private String libelle;
	
	private List<LigneFiltre> listLigneFiltre = new ArrayList();	// si on n'instancie pas => null pointer exception
	
	
	/**
	 * Constructeur
	 * 
	 */
	public BlocFiltre(String libelle) {
		super();
		this.libelle = libelle;
	}

	public BlocFiltre(String libelle, List<LigneFiltre> listLigneFiltre) {
		super();
		this.libelle = libelle;
		this.listLigneFiltre = listLigneFiltre;
	}

	
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	@Override
	public String toString() {
		return this.libelle;
	}

	public List<LigneFiltre> getListLigneFiltre() {
		return listLigneFiltre;
	}

	public void setListLigneFiltre(List<LigneFiltre> listLigneFiltre) {
		this.listLigneFiltre = listLigneFiltre;
	}
	
	/**méthode pour ajouter des lignes filtre au bloc
	* 
	* @param listLF
	*/
	public void add(LigneFiltre listLF) {
		
		this.listLigneFiltre.add(listLF);
		
	}

}
