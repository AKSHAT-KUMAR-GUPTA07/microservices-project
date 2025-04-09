package com.project.microservices.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.project.microservices.order_service.dto.OrderRequest;
import com.project.microservices.order_service.entity.Order;
import com.project.microservices.order_service.repository.OrderRespository;

@Service
public class OrderService {

    private final OrderRespository orderRespository;

    public OrderService(OrderRespository orderRespository){
        this.orderRespository = orderRespository;
    }

    public void placeOrder(OrderRequest orderRequest){

        //map order request to order entity

        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString());
        order.setSkuCode(orderRequest.skuCode());
        order.setPrice(orderRequest.price());
        order.setQuantity(orderRequest.quantity());
        orderRespository.save(order);
    }

}
