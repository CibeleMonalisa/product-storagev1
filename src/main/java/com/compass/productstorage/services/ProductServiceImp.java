package com.compass.productstorage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.compass.productstorage.dto.ProductDto;
import com.compass.productstorage.entity.Product;
import com.compass.productstorage.repository.ProductRepository;

@Service
public class ProductServiceImp implements ProductService {

	final ProductRepository productRepository;

	public ProductServiceImp(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// REGISTER
	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	// GET BY ID
	@Override
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}

	// DELETE BY ID
	@Override
	public void delete(Product product) {
		productRepository.delete(product);

	}

	// GET ALL
	@Override
	public Page<Product> list(Pageable pageable) {
		return productRepository.findAll(pageable);
	}

	// UPDATE GET ProductRepository
	public ProductRepository getProductRepository(Product product) {
		return productRepository;
	}

	// SEARCH
	@Override
	public List<ProductDto> search(@RequestParam(required = false) Double max_price,
			@RequestParam(required = false) Double min_price, @RequestParam(required = false) String q) {
		List<Product> product = productRepository.findByPrice(max_price, min_price, q);
		return ProductDto.convertToList(product);
	}	 

}
