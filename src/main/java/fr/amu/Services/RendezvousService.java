package fr.amu.Services;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.amu.Application;
import fr.amu.beans.Rendezvous;
import fr.amu.dao.RendezvousDAO;;

@Service
public class RendezvousService {
	/**
	 * @author mahdi hassan djilal
	 */
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	private ArrayList<Rendezvous> listeRendezVous = new ArrayList<Rendezvous>();// liste de rendez-vous

	@Autowired
	RendezvousDAO daordv;

	public RendezvousService() {

		Rendezvous rdv = new Rendezvous();// on cree un rendez-vous
		rdv.setDuree(9);// on donne une durée a cette rendez-vous
		rdv.setLieu(" Marseille");// on donne un lieu
		rdv.setType(" entretien d'embauche.");// et on donne un type
		ArrayList<String> personnes = new ArrayList<>();// on cree une liste de personne
		// on ajoute des personnes dans la liste.
		personnes.add("loko");
		personnes.add("loko1");
		personnes.add("loko2");
		personnes.add("loko-tacos");
		// on affecte les personnes le rendez-vous precedement créée
		rdv.setPersonnes(personnes);
		Rendezvous rdv1 = new Rendezvous();// on cree un autre rendez-vous et on fait la meme chose.
		rdv1.setDuree(9);// on donne une durée a cette rendez-vous
		rdv1.setLieu(" Lyon");// on donne un lieu
		rdv1.setType(" entretien");// et on donne un type
		personnes.add("Mahdi");
		personnes.add("Hassan");
		personnes.add("Djilal");
		personnes.add("Adam");
		rdv1.setPersonnes(personnes);// on affecte les personnes le rendez-vous precedement créée
		// on ajoute les rendez-vous créée dans la liste de rendez-vous
		listeRendezVous.add(rdv);
		listeRendezVous.add(rdv1);
	}

	/**
	 * on met a jour la liste de rendez-vous
	 * 
	 * @param rdv
	 */

	public void addRdv(int duree, String lieu, String type) {
		Rendezvous rdv = new Rendezvous();
		rdv.setDuree(duree);
		rdv.setLieu(lieu);
		rdv.setType(type);
		daordv.insertion(rdv);

	}

	/**
	 * cette methode nous retourne le nombre de rendez-vous.
	 * 
	 * @return
	 */
	public int getNombreRdv() {
		return listeRendezVous.size();
	}

	/**
	 * cette nous renvoie une liste de rendez-vous selon un type de rendez-vous
	 * passé en parametre.
	 * 
	 * @param types
	 * @return
	 */

	public ArrayList<Rendezvous> recupereRDV(ArrayList<String> types) {

		ArrayList<Rendezvous> rdv = new ArrayList<>();

		for (Rendezvous rendezvous : this.listeRendezVous) {
			if (types.contains(rendezvous.getType())) {
				rdv.add(rendezvous);
			}
		}

		return rdv;
	}
	public void remove(int id) {
		daordv.delete(daordv.findById(id));
	}
	
	public void update(int id, String lieu, String type, int duree) {
		Rendezvous rdv = daordv.findById(id);
		rdv.setDuree(duree);
		rdv.setLieu(lieu);
		rdv.setType(type);
		daordv.update(rdv);
	}

	/**
	 * cette permet de nous affichés ou visualisées les informations ainsi
	 * enregistrés.
	 */
	public void afficher() {

		// log.info(rendezvous.getDuree()+" "+rendezvous.getLieu()+"
		// "+rendezvous.getType()+" ");
		for (Rendezvous rd : daordv.getAllRendezvous()) {
			log.info(String.format("%s %s %s", String.valueOf(rd.getDuree()), rd.getLieu(), rd.getType()));
		}
		System.out.println();
	}

}
