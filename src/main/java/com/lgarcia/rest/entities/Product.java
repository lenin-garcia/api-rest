package com.lgarcia.rest.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

//Clase producto

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "producto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //la base datos generara el id
    private Long id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "precio")
    private BigDecimal price; //trabaja con decimales con mayor presicion

    // Relacion: un prodcuto solo podra tener un solo fabricante, tiene que llamarse igual que el atributo colocado en la clase
    //relacionada mappedBy
    @ManyToOne
    @JoinColumn(name ="id_fabricante",nullable = false)
    @JsonIgnore //serializara solo cuando se le pida
    private Maker maker;

}
