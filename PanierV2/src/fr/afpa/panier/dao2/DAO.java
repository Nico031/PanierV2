package fr.afpa.panier.dao2;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * DAO est la classe abstraite (avec au moins 1 methode abstraite + sans constructeur) qui permet de g�n�rer des m�thodes abstraites de DAO 
 * (pour se connecter � la BD) et des methodes create, delete, update, find, ArrayList, � compl�ter dans les classes sp�cifiques DAO.
 * 
 * @author nico
 * @param <K>
 */

public interface  DAO<T > {	// interface = impose un comportement via les methodes
	
	/**
	* M�thode de cr�ation
	* @param obj
	*/
	public T create(T obj);		// on renvoie l'objet T avec les modification qu'il a subit

	/**
	* M�thode pour effacer
	* @param obj 
	*/
	public T delete(T obj);

	/**
	* M�thode de mise � jour
	* @param obj
	*/
	public T update(T obj);

	/**
	* M�thode de recherche des informations
	* @param id
	*/
	public T find(int id);
  
  	/** 
  	 * M�thode de recherche de toutes les lignes d'une table
  	 */
	public List<T> findAll();
	
	
}


