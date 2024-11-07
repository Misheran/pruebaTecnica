package com.pruebatecnica.pruebatecnica.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.pruebatecnica.pruebatecnica.entities.Price;

@Repository
public interface PriceRepository extends JpaRepository<Price, Integer>{
    @Query("SELECT p FROM Price p WHERE p.productId = :productId AND p.brandId = :brandId AND :applicationDate BETWEEN p.startDate AND p.endDate ORDER BY p.priority DESC")
    List<Price> findApplicablePrices(@Param("productId") Long productId, @Param("brandId") Long brandId, @Param("applicationDate") LocalDateTime applicationDate);
}
