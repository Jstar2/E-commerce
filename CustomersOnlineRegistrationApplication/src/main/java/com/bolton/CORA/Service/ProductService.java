package com.bolton.CORA.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolton.CORA.Domains.Product;
import com.bolton.CORA.Repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;

	public Iterable<Product> findAllProducts() {
		return this.productRepository.findAll();
	}

	public Product findByBarcode(String barcode) {
		Optional<Product> productExist = productRepository.findByBarcode(barcode);
		Product product = productExist.get();
		return product;
	}

	public Iterable<Product> findByProductName(String input) {

		return productRepository.findByProductName(input);
	}

}
