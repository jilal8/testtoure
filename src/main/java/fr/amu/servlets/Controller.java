package fr.amu.servlets;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import javax.servlet.*;
import fr.amu.Services.*;

@org.springframework.stereotype.Controller
public class Controller {

	
	@Autowired
	ServletContext context;
	
	@Autowired
	RendezvousService rdvservice;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET) 
	public String add(){
	
	return "index"; 
	}
}
