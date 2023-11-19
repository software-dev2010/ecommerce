package com.ds.ecommerce.repository;

import com.ds.ecommerce.entity.ListProductId;
import com.ds.ecommerce.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface PricesRepository extends JpaRepository<Price, ListProductId> {

    @Query("SELECT u FROM prices u WHERE u.listProductId.brandId = :brandId AND u.listProductId.productId = :productId AND u.startDate <= :dateTime AND u.endDate >= :dateTime")
    List<Price> findAllPricesInAPeriod(
            @Param("brandId") int brandId,
            @Param("productId") int productId,
            @Param("dateTime") LocalDateTime dateTime);
}