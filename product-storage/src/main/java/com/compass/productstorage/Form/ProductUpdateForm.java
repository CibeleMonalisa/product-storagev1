package com.compass.productstorage.Form;

import com.compass.productstorage.entity.Product;
import com.compass.productstorage.repository.ProductRepository;

public class ProductUpdateForm {
    private String name;
    private String description;
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
        Product product = productRepository.getReferenceById(id); //getById() caiu em desuso, substituição por getReferenceById() 
        product.setDescription(this.description);
        product.setName(this.name);
        product.setPrice(this.price);
        return product;
    }

}
