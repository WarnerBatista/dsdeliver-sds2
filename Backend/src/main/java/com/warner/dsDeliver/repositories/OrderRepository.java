package com.warner.dsDeliver.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.warner.dsDeliver.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
