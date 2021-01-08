package com.warner.dsDeliver.services;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.warner.dsDeliver.dto.OrderDto;
import com.warner.dsDeliver.dto.ProductDto;
import com.warner.dsDeliver.entities.Order;
import com.warner.dsDeliver.entities.OrderStatus;
import com.warner.dsDeliver.entities.Product;
import com.warner.dsDeliver.repositories.OrderRepository;
import com.warner.dsDeliver.repositories.ProductRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	@Autowired
	private ProductRepository productRepository;
	
	@Transactional(readOnly = true)
	public List<OrderDto> findAll(){
		List<Order> list = repository.findOrdersWithProduct();
		return list.stream().map(x -> new OrderDto(x)).collect(Collectors.toList());
	}
	
	@Transactional
	public OrderDto insert(OrderDto dto){
		Order order = new Order(
				null,
				dto.getAddress(),
				dto.getLatitude(),
				dto.getLongitude(),
				Instant.now(),
				OrderStatus.PENDING
				);
		for (ProductDto p : dto.getProducts()) {
			Product product = productRepository.getOne(p.getId());
			order.getProducts().add(product);
		}
		order = repository.save(order);
		return new OrderDto(order);
	}
	
	@Transactional
	public OrderDto setDelivered(Long id){
		Order order = repository.getOne(id);
		order.setStatus(OrderStatus.DELIVERED);
		order = repository.save(order);
		return new OrderDto(order);
	}
}
