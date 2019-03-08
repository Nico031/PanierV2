package fr.afpa.panier.commandes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import devWeb.ICommand;
import fr.afpa.panier.commun.IConstantes;
import fr.afpa.panier.services.ServiceFiltre;

public class InitCommande implements ICommand {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("Je suis dans : " + this.getClass());
		
		//initialisation des blocFiltre et des lignes
		ServiceFiltre.init();
		
		// recup des listes dans la session
		request.getSession().setAttribute(IConstantes.CLEF_LISTE_FILTRE, ServiceFiltre.getListBlocFiltre());
		
		return (IConstantes.JSP_ROOT + "login_succes.jsp");
	}

}
