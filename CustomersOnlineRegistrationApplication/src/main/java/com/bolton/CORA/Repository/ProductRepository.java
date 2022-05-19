package com.bolton.CORA.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolton.CORA.Domains.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

	Optional<Product> findByBarcode(String barcode);

	Iterable<Product> findByProductName(String input);

}