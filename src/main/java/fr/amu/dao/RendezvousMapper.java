package fr.amu.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import fr.amu.beans.Rendezvous;

public class RendezvousMapper {
	public Rendezvous mapRow(ResultSet rs, int rowNum) throws SQLException{
		Rendezvous rdv = new Rendezvous();
		rdv.setDuree(rs.getInt("duree"));
		rdv.setLieu(rs.getString("lieu"));
		rdv.setType(rs.getString("type"));
		return rdv;	
	}
}
