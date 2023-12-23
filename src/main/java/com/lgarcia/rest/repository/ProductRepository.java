package com.lgarcia.rest.repository;

import com.lgarcia.rest.entities.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository <Product,Long> {

    List<Product> findProductsByPriceBetween(BigDecimal minPrice, BigDecimal maxPrice);
}
