package com.lgarcia.rest.controllers.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.lgarcia.rest.entities.Maker;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {

    private Long id;
    private String name;
    private BigDecimal price; //trabaja con decimales con mayor presicion
    private Maker maker;



}
