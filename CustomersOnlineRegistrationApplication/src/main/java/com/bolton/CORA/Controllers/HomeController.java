package com.bolton.CORA.Controllers;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.CORA.Domains.Product;
import com.bolton.CORA.Repository.ProductRepository;
import com.bolton.CORA.Service.ProductService;

@Controller
@SessionAttributes("customerName")
public class HomeController {
	public static Object getSess;
	@Autowired
	ProductRepository productRepoitory;
	@Autowired
	
	ProductService productService;

	List<Product> productList = new ArrayList<>();

	// Home page Mapping -------------
	@RequestMapping(value = {"/", "/index", "index"})
	public String homePage(ModelMap model, HttpSession session) {
		model.put("products", productService.findAllProducts());
		LoginController.geTsession(model, session);		
		return "index";
	}// ------------------------------	
		
}