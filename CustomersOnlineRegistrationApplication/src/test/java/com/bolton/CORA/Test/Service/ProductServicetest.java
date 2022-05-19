package com.bolton.CORA.Test.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.bolton.CORA.Service.ProductService;

public class ProductServicetest {
@Autowired
ProductService productService; 
	
@Test
	void contextLoads() {
		productService.findAllProducts();
	}
}
