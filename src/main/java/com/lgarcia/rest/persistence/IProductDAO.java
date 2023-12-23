package com.lgarcia.rest.persistence;

import com.lgarcia.rest.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

//metodos que tendra nuestra appa referente a prodcutos
public interface IProductDAO {

    List<Product> findAll();
    Optional<Product> findById(Long id);
    void save (Product producto);
    void deleteById (Long id);
    List<Product> findByPriceRange(BigDecimal minPrice ,BigDecimal maxPrice);



}
