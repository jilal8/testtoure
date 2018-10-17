package fr.amu.models;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public class ProductDAOImpl implements ProductDAO {
	
	
	@Autowired
	JdbcTemplate jbdc; 
	
	public void add(Product product) {
		String sql = "INSERT INTO products (title,description, category)" + "VALUES(?,?,?)";
		jbdc.update(sql, product.getTitle(),product.getDescription(),product.getCategory());
	}
	
	public void update(Product product) {
		String sql = "UPDATE products SET title = ?, description = ?"
				+ ", category = ? WHERE id = ?";
		jbdc.update(sql, product.getTitle(),product.getDescription(),product.getCategory(), product.getId());
	}
	
	public void delete(Product product) {
		String sql = "DELETE FROM products WHERE id = ?";
		jbdc.update(sql, product.getId());
	}
	
	public List<Product> findAll(){
		String sql = "SELECT * FROM products";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jbdc.query(sql, rowMapper);
	}
	
	public Product findById(Integer id) {
		String sql = "SELECT * FROM products where id = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jbdc.queryForObject(sql, rowMapper,id);
	}
	
	public List<Product> findByCategory(String category){
		String sql = "SELECT * FROM products where category = ?";
		RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
		return jbdc.query(sql, rowMapper, category);
		
	}
}
