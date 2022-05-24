package com.compass.productstorage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.compass.productstorage.dto.ProductDto;
import com.compass.productstorage.entitie.Product;
import com.compass.productstorage.repository.ProductRepository;

@Service
public class ProductService {

	final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	// REGISTER
	public Product register(Product product) {
		return this.productRepository.save(product);
	}

	public Page<Product> findAll(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

	//SELECT ALL
	public List<ProductDto> list() {
		List<Product> product = productRepository.findAll(); 
		return ProductDto.convertToList(product);
	}

	//SELECT BY ID
	public Optional<Product> findById(int id){return productRepository.findById(id);}

	//DELETE BY ID
	public void delete(Product productDto){
		productRepository.delete(productDto);

	}

}
