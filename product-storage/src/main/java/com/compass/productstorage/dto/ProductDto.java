package com.compass.productstorage.dto;

import javax.validation.constraints.NotBlank;

import com.compass.productstorage.model.ProductModel;

public class ProductDto {
	@NotBlank
	private int id;
	@NotBlank
	private String name;
	private String description;
	@NotBlank
	private double price;

	public ProductDto(ProductModel product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}

}
