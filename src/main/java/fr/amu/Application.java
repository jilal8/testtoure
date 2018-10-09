package fr.amu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import fr.amu.Services.RendezvousService;
import fr.amu.beans.Rendezvous;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	JdbcTemplate jbdc;

	@Autowired
	RendezvousService rdvservice;
	
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String args[]) {
		SpringApplication.run(Application.class, args);
//        Utils.openBrowser("http://localhost:8090"); // pour ouvrir le navigateur par défaut au démarrage (sans implements CommandLineRunner)

	}

	@Override
	public void run(String... strings) throws Exception {
		log.info("run something");
		jbdc.execute("DROP TABLE rendezvous IF EXISTS");
		jbdc.execute("CREATE TABLE IF NOT EXISTS rendezvous " + "  (id INT IDENTITY PRIMARY KEY," + "    duree INT,"
				+ "    lieu VARCHAR(100)," + "    type VARCHAR(255));");
		
		
		rdvservice.addRdv(8, "Aska","entretien d'embauche..");
		rdvservice.addRdv(5, "Aska","entretien d'embauche..");
		rdvservice.addRdv(82, "Aska","entretien d'embauche..");
		rdvservice.remove(2);
		rdvservice.update(1,"Djibouti","reunion",999);
		rdvservice.afficher();
	}
}