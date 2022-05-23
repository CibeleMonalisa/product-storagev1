package com.compass.productstorage.services;

import org.springframework.stereotype.Service;

import com.compass.productstorage.model.ProductModel;
import com.compass.productstorage.repository.ProductRepository;

@Service
public class ProductService {

	final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// REGISTER
	public ProductModel register(ProductModel product) {
		return this.productRepository.save(product);
	}
}
