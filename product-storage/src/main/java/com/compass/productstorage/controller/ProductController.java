package com.compass.productstorage.controller;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.compass.productstorage.Form.ProductForm;
import com.compass.productstorage.Form.ProductUpdateForm;
import com.compass.productstorage.dto.ProductDto;
import com.compass.productstorage.entity.Product;
import com.compass.productstorage.repository.ProductRepository;
import com.compass.productstorage.services.ProductServiceImp;

@RestController
@RequestMapping("/product-storage")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	final ProductServiceImp productService;

	public ProductController(ProductServiceImp productService) {
		this.productService = productService;
	}

	// CREATE PRODUCT
	@PostMapping
	@Transactional
	public ResponseEntity<Object> create(@RequestBody ProductForm form) {
		var product = new Product();
		BeanUtils.copyProperties(form, product); //converting a Form to Entity
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

	// SELECT BY ID
	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> findById(@PathVariable int id) {
		Optional<Product> productOptional = productService.findById(id);
		if (!productOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ProductDto(productOptional.get()));
	}

	// DELETE BY ID
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> delete(@PathVariable int id) {
		Optional<Product> productDtoOptional = productService.findById(id);

		if (!productDtoOptional.isPresent()) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		}
		productService.delete(productDtoOptional.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto deletado com sucesso");

	}

	// UPDATE BY ID
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<Product> update(@PathVariable int id, @RequestBody @Valid ProductUpdateForm form) {
		Optional<Product> optional = productRepository.findById(id);
		if (optional.isPresent()) {
			Product product = form.updateForm(id, productRepository);
			return ResponseEntity.ok(new ProductDto(product));
		}
		return ResponseEntity.notFound().build();
	}

	// SELECT ALL
	@GetMapping
	public Page<ProductDto> list(
			@PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.ASC) Pageable pageable) {
		Page<Product> products = productService.list(pageable);
		return ProductDto.convertToPage(products);
	}

	// SEARCH
	@GetMapping("/search")
	public List<ProductDto> search(@RequestParam(required = false) Double maxPricedb,
			@RequestParam(required = false) Double minPricedb, @RequestParam(required = false) String q) {
		return productService.search(maxPricedb, minPricedb, q);
	}

}
