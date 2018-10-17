package fr.amu.services;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.amu.models.*;
@Repository
public class ProductService {
	
	@Autowired
	ProductDAO pdao;
	
	Product prod;
	/**
	 * pour avoir la liste des produits
	 * @return
	 */
	public List<Product> getAllProducts() {
		return pdao.findAll();
	}
	
	public void addProduct(String title, String description, String category) {
		prod = new Product();
		prod.setTitle(title);
		prod.setDescription(description);
		prod.setCategory(category);
		pdao.add(prod);
	}
	
	public void removeProduct(int id) {
		pdao.delete(pdao.findById(id));
	}
	
	public List<Product> findProductByCategory(String category){
		return pdao.findByCategory(category);
	}
}
