package com.compass.productstorage.dto.form;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.compass.productstorage.entity.Product;
import com.compass.productstorage.repository.ProductRepository;

public class ProductUpdateForm {
	@NotNull @NotEmpty
	private String name;
	private String description;
	@NotNull
	@DecimalMin(value ="0.01" ,message = "")
	private double price;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Product updateForm(int id, ProductRepository productRepository) {
		Product product = productRepository.getById(id);
																	
		product.setDescription(this.description);
		product.setName(this.name);
		product.setPrice(this.price);
		return product;
	}

}
