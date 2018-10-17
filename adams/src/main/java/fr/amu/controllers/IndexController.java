package fr.amu.controllers;
import java.util.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import javax.servlet.*;
import javax.servlet.http.HttpSession;

import fr.amu.models.Product;
import fr.amu.services.ProductService;

@org.springframework.stereotype.Controller
public class IndexController {
	
	@Autowired
	private HttpSession httpSession;
	
	@Autowired
	ServletContext context;
	
	@Autowired
	ProductService pservice;

	/**
	 * to print on the screen the list of the product
	 * @param pModel
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String afficher(ModelMap pModel) {
		final List<Product> listeproducts = pservice.getAllProducts();
		if(listeproducts.size()> 0) {
			pModel.put("listProducts", listeproducts);
		}else {
			System.out.println("the liste is empty.");
		}
		
		return "homepage";
	}
}