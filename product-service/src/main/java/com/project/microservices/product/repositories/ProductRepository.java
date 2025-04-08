package com.project.microservices.product.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.project.microservices.product.entities.Product;

public interface ProductRepository extends MongoRepository<Product , String>{

}
