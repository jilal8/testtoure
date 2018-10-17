package fr.amu.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.amu.models.Product;
import fr.amu.services.ProductService;

@org.springframework.stereotype.Controller
public class ProductController {
	@Autowired
	ProductService pservice;

	/**
	 * to add a product
	 * @param model
	 * @param titre
	 * @param description
	 * @param cate
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(ModelMap model, @RequestParam("title") String titre,
			@RequestParam("description") String description, @RequestParam("category") String cate) {
		pservice.addProduct(titre, description, cate);
		final List<Product> listeproducts = pservice.getAllProducts();
		model.put("listProducts", listeproducts);
		return "homepage";
	}

	/**
	 * to delete a product
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public String remove(ModelMap model, @RequestParam("productId") int id) {
		pservice.removeProduct(id);
		final List<Product> listeproducts = pservice.getAllProducts();
		model.put("listProducts", listeproducts);
		return "homepage";
	}
	/**
	 * to filtre or searche
	 * @param model
	 * @param category
	 * @return
	 */
	@RequestMapping(value = "/category", method = RequestMethod.POST)
	public String research(ModelMap model, @RequestParam("category") String category) {
		final List<Product> listeproducts;
		//si la category est vide on afficher getallproduct
		if(category.isEmpty()) {
			listeproducts = pservice.getAllProducts();
		}else {//si non affiche on filtre selon le category
			 listeproducts = pservice.findProductByCategory(category);
		}
		//on passe la liste a la vue
		model.put("listProducts", listeproducts);
		return "homepage";

	}

}
