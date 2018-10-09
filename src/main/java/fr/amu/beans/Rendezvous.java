package fr.amu.beans;

import java.io.Serializable;
/**
 * 
 */
import java.util.ArrayList;

import javax.annotation.ManagedBean;
/**
 * 
 * @author mahdi hassan djilal
 *
 */

public class Rendezvous implements Serializable {
	
	private int id;
	private int duree;
	private ArrayList<String> personnes;
	private String lieu;
	private String type;
	/**
	 * cette methode retourne la durée du rendez-vous
	 * @return duree 
	 */
	public int getDuree() {
		return duree;
	}
	/**
	 * retourne la liste de personnes impliquées
	 * @return personnes
	 */

	public ArrayList<String> getPersonnes() {
		return personnes;
	}
	/**
	 * met a jour la liste de personnes
	 * @param personnes
	 */

	public void setPersonnes(ArrayList<String> personnes) {
		this.personnes = personnes;
	}
	/**
	 * cette methode la retourne le lieu de rendez-vous
	 * @return lieu
	 */

	public String getLieu() {
		return lieu;
	}
	/**
	 * mise à jour du lieu de rendez-vous
	 * @param lieu
	 */

	public void setLieu(String lieu) {
		this.lieu = lieu;
	}
	/**
	 * cette nous renvoie le type de rendez-vous
	 * @return
	 */

	public String getType() {
		return type;
	}
	/**
	 * le mise a jour du type de rendezv-vous
	 * @param type
	 */

	public void setType(String type) {
		this.type = type;
	}
	/**
	 * cette methode met à jour la durée du rendez-vous
	 * @param duree
	 */

	public void setDuree(int duree) {
		this.duree = duree;
	}
	/**
	 * constructeur par defaut
	 */
	
	 public Rendezvous() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * la methode NombrePersonn() retourne les nombres de personnes 
	 * @return
	 */
	public int NombrePersonne() {
		return this.getPersonnes().size();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
