package com.warner.dsDeliver.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.warner.dsDeliver.entities.Order;
import com.warner.dsDeliver.entities.OrderStatus;

public class OrderDto implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String address;
	private Double longitude;
	private Double latitude;
	private Instant moment;
	private OrderStatus status;
	private List<ProductDto> products = new ArrayList<>();
	
	public OrderDto() {
		
	}

	public OrderDto(Long id, String address, Double longitude, Double latitude, Instant moment, OrderStatus status) {
		super();
		this.id = id;
		this.address = address;
		this.longitude = longitude;
		this.latitude = latitude;
		this.moment = moment;
		this.status = status;
	}
	
	public OrderDto(Order entity) {
		id = entity.getId();
		address = entity.getAddress();
		longitude = entity.getLongitude();
		latitude = entity.getLatitude();
		moment = entity.getMoment();
		status = entity.getStatus();
		
		products = entity.getProducts().stream().map(x-> new ProductDto(x)).collect(Collectors.toList());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<ProductDto> getProducts() {
		return products;
	}
}
