package com.compass.productstorage.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compass.productstorage.model.ProductModel;
import com.compass.productstorage.services.ProductService;


@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/product-storage")
public class ProductController {

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductModel> register(@RequestBody ProductModel product) {
		return ResponseEntity.status(HttpStatus.CREATED).body(productService.register(product));
	}
	
	@GetMapping
    public ResponseEntity<Page<ProductModel>> getAllProducts(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable){
        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
    }
}
