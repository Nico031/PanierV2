package fr.afpa.panier.commandes;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devWeb.ICommand;
import fr.afpa.panier.beans.BlocFiltre;
import fr.afpa.panier.beans.LigneFiltre;
import fr.afpa.panier.commun.IConstantes;
import fr.afpa.panier.dao.impl.ProduitDAO;
import fr.afpa.panier.dao.pojo.Client;
import fr.afpa.panier.dao.pojo.Produit;

public class CheckboxCheckedCommande implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Je suis dans : " + this.getClass());
	
		// je recup l'objet client dans la session depuis ma jsp
				Client cl = (Client) request.getSession().getAttribute("client");
				
				// je recup mon objet liste de filtres dans la session depuis la jsp (et non depuis ServiceFiltre qui l'initialise la 1ère fois)
				List<BlocFiltre> listeFiltre = (List<BlocFiltre>) request.getSession().getAttribute(IConstantes.CLEF_LISTE_FILTRE);

				if (listeFiltre == null) {
					
					return("/WEB-INF/jsp/login_error.jsp");
					
				} else {


					// on parcourt la liste pour comparer les lignes avec le tab qu'on parcourt
					// également
					// pour chaque bloc de la liste de bloc
					for (BlocFiltre liste : listeFiltre) {
						
						// recup des parametres validés (checkbox cochées) dans un tab
						String[] tabCheckboxChecked = request.getParameterValues(liste.getLibelle()); 	// correspond au name donné dans le input checkbox jsp
						
						// dans lesquels, pour chaque ligne des listes de lignes
						for (LigneFiltre ligne : liste.getListLigneFiltre()) {
							ligne.setChecked(false);
							// si tab != null => on le parcourt et on marque les lignes checked
							if (tabCheckboxChecked != null) {

								for (int i = 0; i < tabCheckboxChecked.length; i++) {

									// quand une ligne du tab correspond à une ligne de la liste => je marque cette
									// dernière comme checked
									if (Integer.parseInt(tabCheckboxChecked[i]) == ligne.getId()) {

										ligne.setChecked(true);

									}

								}
							}

						}

					}
					//TODO aller chercher le catalogue
					ProduitDAO prodDAO = new ProduitDAO();
					
				}
				// on enregistre la liste des checkboxCheched dans la session
				request.getSession().setAttribute(IConstantes.CLEF_LISTE_FILTRE, listeFiltre);
		
		
		return (IConstantes.JSP_ROOT +"login_succes.jsp");
	}

}
