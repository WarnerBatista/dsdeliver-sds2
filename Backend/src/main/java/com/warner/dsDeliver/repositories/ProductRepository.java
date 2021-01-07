package com.warner.dsDeliver.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warner.dsDeliver.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	List<Product> findAllByOrderByNameAsc();
}
