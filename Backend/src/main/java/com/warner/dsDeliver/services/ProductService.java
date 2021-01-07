package com.warner.dsDeliver.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warner.dsDeliver.dto.ProductDto;
import com.warner.dsDeliver.entities.Product;
import com.warner.dsDeliver.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository repository;
	
	@Transactional(readOnly = true)
	public List<ProductDto> findAll(){
		List<Product> list = repository.findAllByOrderByNameAsc();
		return list.stream().map(x -> new ProductDto(x)).collect(Collectors.toList());
	}
}
