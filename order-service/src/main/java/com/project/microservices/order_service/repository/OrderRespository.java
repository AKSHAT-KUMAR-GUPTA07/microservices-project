package com.project.microservices.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.microservices.order_service.entity.Order;

@Repository
public interface OrderRespository extends JpaRepository<Order , Long>{

}
