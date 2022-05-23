package com.compass.productstorage.controller;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.productstorage.dto.ProductDto;
import com.compass.productstorage.model.Product;
import com.compass.productstorage.services.ProductService;

@RestController
@RequestMapping("/product-storage")
public class ProductController {

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping
	public List<ProductDto> list(){
		return productService.list();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> registerProduct(@RequestBody ProductForm productForm, UriComponentsBuilder uriBuilder){

	return productService.registerProduct(productForm, uriBuilder);

	}
	
//	@GetMapping
//    public ResponseEntity<Page<Product>> getAllProducts(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable){
//        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
//    }
}
