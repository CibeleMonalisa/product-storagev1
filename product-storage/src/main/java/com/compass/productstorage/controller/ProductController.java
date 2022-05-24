package com.compass.productstorage.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.compass.productstorage.entitie.Product;
import com.compass.productstorage.Form.ProductForm;
import com.compass.productstorage.Form.ProductUp;
import com.compass.productstorage.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import com.compass.productstorage.dto.ProductDto;
import com.compass.productstorage.services.ProductService;

@RestController
@RequestMapping("/product-storage")
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}
/*
	@PostMapping

	@Transactional
	public ResponseEntity<ProductDto> registerProduct(@RequestBody ProductForm productForm, UriComponentsBuilder uriBuilder){
	return productService.registerProduct(productForm, uriBuilder);
	}
*/
	@PostMapping
	@Transactional
	public ResponseEntity<ProductDto> registerProduct(@RequestBody @Valid ProductForm form, UriComponentsBuilder uriBuilder) {
		Product product = form.converter(productRepository);
		productRepository.save(product);
		// para devolver código 201 (que deu certo e foi add mais algo)
		URI uri = uriBuilder.path("/products/{id}").buildAndExpand(product.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProductDto(product));
	}

	@GetMapping
	public List<ProductDto> list(){
		return productService.list();
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductDto> detalhar(@PathVariable int id) {
		Optional<Product> productOptional = productService.findById(id);
		if (!productOptional.isPresent()) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(new ProductDto(productOptional.get()));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteParkingSpot(@PathVariable int id){
		Optional<Product> productDtoOptional = productService.findById(id);

		if(!productDtoOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
		}
		productService.delete(productDtoOptional.get());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto deletado com sucesso");

	}
/*
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable int id,@RequestBody ProductDto productDto){
		Optional<Product> productOptional = productService.findById(id);
		if(!productOptional.isPresent()){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrada ");
		}
		var produtoModel = productOptional.get();

		produtoModel.setId(productOptional.get().getId());
		produtoModel.setName(productOptional.get().getName());
		produtoModel.setDescription(productOptional.get().getDescription());
		produtoModel.setPrice(productOptional.get().getPrice());

		return ResponseEntity.status(HttpStatus.OK).body(productService.register(produtoModel));
	}
*/
		@PutMapping("/{id}")
		@Transactional // comando pra salvar no banco de dados as novas info
		public ResponseEntity<ProductDto> atualizar(@PathVariable int id, @RequestBody @Valid ProductUp form) {
			Optional<Product> optional = productRepository.findById(id);
			if (optional.isPresent()) {
				Product product = form.update(id, productRepository);
				return ResponseEntity.ok(new ProductDto(product));
			}
			return ResponseEntity.notFound().build();
		}

	
//	@GetMapping
//    public ResponseEntity<Page<Product>> getAllProducts(@PageableDefault(page = 0, size = 10, sort = "id", direction = Direction.ASC) Pageable pageable){
//        return ResponseEntity.status(HttpStatus.OK).body(productService.findAll(pageable));
//    }
}
