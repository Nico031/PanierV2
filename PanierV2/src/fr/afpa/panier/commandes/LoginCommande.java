package fr.afpa.panier.commandes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionActivationListener;

import org.apache.log4j.Logger;

import devWeb.ICommand;
import fr.afpa.panier.commun.IConstantes;
import fr.afpa.panier.dao.pojo.Client;
import fr.afpa.panier.servlet.FrontControler;

/**
 * Classe qui va recup la saisie dans un objet client puis va renvoyer vers les pages correspondantes selon la vérification de la saisie
 * @author nico
 *
 */
public class LoginCommande implements ICommand {
	
	private static Logger logger = Logger.getLogger(LoginCommande.class);

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		logger.info("Je suis dans : " + this.getClass());

		// recup ident et pass du client depuis la jsp
		String ident = request.getParameter("ident");
		String pass = request.getParameter("pass");

		// objet client à partir de sa saisie
		Client client = new Client(ident, pass);

		// verification de la saisie grace à la methode validate() de la classe Client:
		// si elle est valide => le servlet demande a la page "loging_succes.jsp" de
		// s'afficher, sinon page error
		
		
		// si le client est bien nv dans la session
		if(request.getSession().getAttribute("ident")==null && request.getSession().getAttribute("pass")==null) {
			
			// si le client est valide
			if (client.validate()) {

				// on enregistre le client dans la session
				request.getSession().setAttribute("client", client);
				logger.info("Le client " + client + "  is VALIDATED");
				
				// on renvoie vers la commande qui initialise les filtres
				return("frontControler?cmd=Init");
				//System.out.println("Client " + client + "valide");
				
			} else {
				// sinon on renvoie vers
				logger.info("Le client " + client + "  is NOT VALIDATED");
				return ("/WEB-INF/jsp/login_error.jsp");
				
			}
		} else { 
			return (IConstantes.JSP_ROOT + "login.jsp");
		}
		
		
	}

}
