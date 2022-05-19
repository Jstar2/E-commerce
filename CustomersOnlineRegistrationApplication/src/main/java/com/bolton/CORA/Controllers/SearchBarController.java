package com.bolton.CORA.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.bolton.CORA.Domains.Product;
import com.bolton.CORA.Service.ProductService;

@Controller
@SessionAttributes("customerName")
public class SearchBarController {
	@Autowired
	ProductService productService;

	List<Product> productList1 = new ArrayList<>();

	// search bar mapping ------------
	@GetMapping("sea")
	public String searchBar() {		
		return "result";
	}// ------------------------------
	
	// search Bar------------------------------------------------------------------
	@RequestMapping("/sear")
     public String 	searchProducts(@RequestParam String input, ModelMap model) {
		Iterable<Product> ProductsFound = productService.findByProductName(input);
		model.put("searchRsults", ProductsFound);
		return "result";		
	}//-----------------------------------------------------------------------------	
}