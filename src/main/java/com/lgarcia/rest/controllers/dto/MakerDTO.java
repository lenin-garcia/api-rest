package com.lgarcia.rest.controllers.dto;

import com.lgarcia.rest.entities.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MakerDTO {

    private Long id;

    private String name;

    private List<Product> productList = new ArrayList<>(); //Relacion: un fabricante puede tenr un listado de prodcutos

}
