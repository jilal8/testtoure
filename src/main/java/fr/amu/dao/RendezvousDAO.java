package fr.amu.dao;

import java.util.ArrayList;
import java.util.List;

import fr.amu.beans.Rendezvous;


public interface RendezvousDAO {
	public void insertion(Rendezvous rdv);
	public void update(Rendezvous rdv);
	public void delete(Rendezvous rdv);
	public Rendezvous findById(int id);
	public List<Rendezvous> getAllRendezvous();
	public List<Rendezvous> getRendezvousType(String type);
}
