package com.compass.productstorage.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.productstorage.entitie.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
