package fr.amu.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.amu.beans.Rendezvous;

@Transactional
@Repository
public class RendezvousDAOImpl implements RendezvousDAO {
	
	@Autowired
	JdbcTemplate jbdc; 
	
	@Override
	public void insertion(Rendezvous rdv) {
		String sql = "INSERT INTO rendezvous(duree,lieu, Type)" + "VALUES(?,?,?)";
		jbdc.update(sql, rdv.getDuree(),rdv.getLieu(),rdv.getType());
	}
	
	@Override
	public List<Rendezvous> getAllRendezvous() {
		String sql = "SELECT * FROM rendezvous";
		RowMapper<Rendezvous> rowMapper = new BeanPropertyRowMapper<Rendezvous>(Rendezvous.class);
		return jbdc.query(sql, rowMapper);
//		return null;
	}
	
	@Override
	public List<Rendezvous> getRendezvousType(String type) {
		String sql = "SELECT * FROM rendezvous where type = ?";
		RowMapper<Rendezvous> rowMapper = new BeanPropertyRowMapper<Rendezvous>(Rendezvous.class);
//		return jbdc.query;
		return null;
	}

	@Override
	public void update(Rendezvous rdv) {
		String sql = "UPDATE rendezvous SET duree = ?, lieu = ?"
				+ ", Type = ? WHERE id = ?";
		jbdc.update(sql, rdv.getDuree(),rdv.getLieu(), rdv.getType(), rdv.getId());
	}

	@Override
	public void delete(Rendezvous rdv) {
		String sql = "DELETE FROM rendezvous WHERE id = ?";
		jbdc.update(sql, rdv.getId());
	}
	
	public Rendezvous findById(int id) {
		String sql = "SELECT * FROM rendezvous where id = ?";
		RowMapper<Rendezvous> rowMapper = new BeanPropertyRowMapper<Rendezvous>(Rendezvous.class);
		return jbdc.queryForObject(sql, rowMapper,id);
	}
	

}
