package fr.afpa.panier.logging;

import org.apache.log4j.Logger;

public class TestLogging {

	private static Logger logger = Logger.getLogger(TestLogging.class);

	public static void main(String[] args) {

		logger.debug("msg de debogage");

		logger.info("msg d'information");

		logger.warn("msg d'avertissement");

		logger.error("msg d'erreur");

		logger.fatal("msg d'erreur fatale");

	}

}
