package fr.amu.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import fr.amu.models.*;

import javax.servlet.*;
import fr.amu.services.*;



public class Controller {

	@Autowired 
	ProductService pservice;
	/**
	 * to print on the screen the list of the product
	 * @param pModel
	 * @return
	 */
	@RequestMapping(value = "/print", method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Product> listeproducts = pservice.getAllProducts();
		if(listeproducts.size()> 0) {
			pModel.put("listProducts", listeproducts);
		}else {
			System.out.println("the liste is empty.");
		}
		
		return "homepage";
	}
	/**
	 * to add a product
	 * @param model
	 * @param titre
	 * @param description
	 * @param cate
	 * @return
	 */
	@RequestMapping(value="/add", method =RequestMethod.POST)
	public String add(ModelMap model, @RequestParam("title") String titre, @RequestParam("description") String description, @RequestParam("category") String cate) {
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
	@RequestMapping(value="/remove", method =RequestMethod.POST)
	public String remove(ModelMap model, @RequestParam("productId") int id) {
	
		pservice.removeProduct(id);
		final List<Product> listeproducts = pservice.getAllProducts();
		model.put("listProducts", listeproducts);
		return "homepage";
	}
}
	
	

