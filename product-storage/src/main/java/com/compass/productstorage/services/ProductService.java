package com.compass.productstorage.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.RequestParam;

import com.compass.productstorage.dto.ProductDto;
import com.compass.productstorage.entity.Product;

public interface ProductService {

	// REGISTER METHOD
	Product save(Product product);

	// DELET BY ID METHOD
	void delete(Product productDto);

	// SELECT BY ID METHOD
	Optional<Product> findById(int id);

	// SELECT ALL METHOD
	Page<Product> list(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable);

	// SEARCH METHOD
	List<ProductDto> search(@RequestParam(required = false) Double maxPricedb,
			@RequestParam(required = false) Double minPricedb, @RequestParam(required = false) String q);
}
