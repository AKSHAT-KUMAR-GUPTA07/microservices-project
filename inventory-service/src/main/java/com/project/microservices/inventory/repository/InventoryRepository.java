package com.project.microservices.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.microservices.inventory.entity.Inventory;


@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long>{
    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode , Integer quantity);
}
