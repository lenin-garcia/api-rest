package com.lgarcia.rest.service;

import com.lgarcia.rest.entities.Product;
import com.lgarcia.rest.persistence.IProductDAO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface IProductsService  {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save (Product producto);
    void deleteById (Long id);
    List<Product> findByPriceRange(BigDecimal minPrice ,BigDecimal maxPrice);

}
