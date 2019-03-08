package fr.afpa.panier.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import devWeb.ICommand;
import fr.afpa.panier.commun.IConstantes;
import fr.afpa.panier.logging.TestLogging;

/**
 * Servlet implementation class FrontControler
 */
@WebServlet("/frontControler")

public class FrontControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontControler() {
        super();
      
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		process(request,response);		
		
	}
	
	protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Logger logger = Logger.getLogger(FrontControler.class);
		
		logger.info("Je suis dans : " + this.getServletName());
		
		response.setContentType("text/html");
		
		//recup de la saisie dans le param cmd de l'action du form de la jsp, dans une var "cmd"
		//le cmd du form = la saisie + correspond au début variable du nom de la classe Java qui va effectuer le traitement
		String cmd = IConstantes.PACKAGE_COMMANDE + request.getParameter("cmd") + IConstantes.CLASS_COMMANDE;
		System.out.println("recup de la cmd qui va etre traité par: " + cmd);
		
		ICommand iCom=null;
		try {
			//On instancie un objet commande qui hérite de ICommand
			iCom = (ICommand)Class.forName(cmd).newInstance();
			logger.info("Instanciation d'un objet Icom : " + iCom);
			
			//execution de la commande et recup du chemin de la page  (selon le traitement fait) dans var urlSuite
			String urlSuite = iCom.execute(request, response);
			logger.info("execute ok. Lien page reçu apres traitement: " + urlSuite);
			
			//envoie vers la jsp choisie selon le traitement
			request.getRequestDispatcher(urlSuite).forward(request,response);
			logger.info("envoi requete vers : " + urlSuite);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
