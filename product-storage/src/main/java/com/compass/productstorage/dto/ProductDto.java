package com.compass.productstorage.dto;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.constraints.NotBlank;

import org.springframework.data.domain.Page;

import com.compass.productstorage.entity.Product;

public class ProductDto extends Product {
	@NotBlank
	private int id;
	@NotBlank
	private String name;
	private String description;
	@NotBlank
	private double price;

	public ProductDto(Product product) {
		this.id = product.getId();
		this.name = product.getName();
		this.description = product.getDescription();
		this.price = product.getPrice();
	}

	public ProductDto() {
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

	public static List<ProductDto> convertToList(List<Product> products) {
		return products.stream().map(ProductDto::new).collect(Collectors.toList());

		}
	
	public static Page<ProductDto> convertToPage(Page<Product> products){
		return products.map(ProductDto::new);
		}

}
