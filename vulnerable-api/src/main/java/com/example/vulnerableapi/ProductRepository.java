package com.example.vulnerableapi;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM Products e ORDER BY e.id LIMIT :limit", nativeQuery = true)
    List<Product> getProductsByLimit(@Param("limit") int limit);
}
