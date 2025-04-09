package com.project.microservices.order_service.service;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.project.microservices.order_service.client.InventoryClient;
import com.project.microservices.order_service.dto.OrderRequest;
import com.project.microservices.order_service.entity.Order;
import com.project.microservices.order_service.repository.OrderRespository;

@Service
public class OrderService {

    private final OrderRespository orderRespository;
    private final InventoryClient inventoryClient;

    public OrderService(OrderRespository orderRespository , InventoryClient inventoryClient){
        this.orderRespository = orderRespository;
        this.inventoryClient = inventoryClient;
    }


    public void placeOrder(OrderRequest orderRequest){

        var isProductInStock = inventoryClient.isInStock(orderRequest.skuCode(), orderRequest.quantity());

        if(isProductInStock){
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setSkuCode(orderRequest.skuCode());
            order.setPrice(orderRequest.price());
            order.setQuantity(orderRequest.quantity());
            orderRespository.save(order);
        }else{
            throw new RuntimeException("product with skuCode "+ orderRequest.skuCode()+" is not in stock");
        }
        //map order request to order entity
    }

}
